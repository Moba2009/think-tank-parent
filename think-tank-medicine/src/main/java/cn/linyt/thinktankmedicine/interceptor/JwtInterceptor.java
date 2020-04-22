package cn.linyt.thinktankmedicine.interceptor;

import cn.linyt.common.annotation.JwtIgnore;
import cn.linyt.common.exception.CustomException;
import cn.linyt.common.response.Result;
import cn.linyt.common.response.ResultCode;
import cn.linyt.common.service.ParseJWTService;
import com.alibaba.fastjson.JSONObject;
import lombok.extern.slf4j.Slf4j;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @ClassName JwtInterceptor
 * @Description TODO    token验证拦截器
 * @Author Mojo
 * @Date 2020/4/14 4:44
 * @Version 1.0
 **/
@Slf4j
public class JwtInterceptor extends HandlerInterceptorAdapter {

    public static final String AUTH_HEADER_KEY = "Authorization";
    public static final String TOKEN_PREFIX = "Bearer ";

    @Reference
    private ParseJWTService parseJWTService;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws IOException {

        //如果不是映射到方法直接通过
        if (!(handler instanceof HandlerMethod)) {
            return true;
        }
        HandlerMethod handlerMethod = (HandlerMethod) handler;
        JwtIgnore jwtIgnore = handlerMethod.getMethod().getAnnotation(JwtIgnore.class);
        // 忽略带JwtIgnore注解的请求, 不做后续token认证校验
        if (jwtIgnore != null){
            log.info("### jwtIgnore is exist ###");
            return true;
        }
        log.info("### jwtIgnore is non-exist ###");

        if (HttpMethod.OPTIONS.equals(request.getMethod())) {
            response.setStatus(HttpServletResponse.SC_OK);
            return true;
        }

        // 获取请求头信息authorization信息
        final String authHeader = request.getHeader(AUTH_HEADER_KEY);
        log.info("### authHeader= {}", authHeader);

        if (StringUtils.isEmpty(authHeader) || !authHeader.startsWith(TOKEN_PREFIX)) {
            //用户没有登录，请先登录
            log.info("### User is not logged in, please log in first ###");
            //设置响应状态码
            response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
            //设置响应数据类型和编码方式
            response.setContentType("application/json; charset=utf-8");
            response.getWriter().write(JSONObject.toJSONString(Result.FAIL()));
            throw new CustomException(ResultCode.USER_NOT_LOGGED_IN);
        }

        // 获取token
        final String token = authHeader.substring(7);

        // 验证token是否有效--无效已做异常抛出，由全局异常处理后返回对应信息
        return parseJWTService.parseJWT(token);
    }
}
