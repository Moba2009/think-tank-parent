package cn.linyt.thinktanklogin.controller;

import cn.linyt.common.response.Result;
import cn.linyt.common.annotation.JwtIgnore;
import cn.linyt.thinktanklogin.entity.Audience;
import cn.linyt.thinktanklogin.entity.User;
import cn.linyt.thinktanklogin.repository.UserRepository;
import cn.linyt.thinktanklogin.utils.JwtTokenUtil;
import com.alibaba.fastjson.JSONObject;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.Criteria;
import org.hibernate.criterion.Example;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.UUID;

/**
 * @ClassName AdminUserController
 * @Description TODO
 * @Author Mojo
 * @Date 2020/4/14 5:02
 * @Version 1.0
 **/
@Slf4j
@CrossOrigin
@RestController
public class AdminUserController {

    @Autowired
    private Audience audience;

    @Autowired
    private UserRepository userRepository;

    @JwtIgnore
    @PostMapping("/login")
    public Result adminLogin(Model model, HttpServletResponse response, @RequestBody User user) throws IOException {

        // 检测是否登录
        User user1 = userRepository.findByUsername(user.getUsername());
        if (null == user1) {
            //用户名错误
            log.info("### username is fail! ###");
            return Result.FAIL("用户名错误");
        } else if (!user1.getPassword().equals(user.getPassword())) {
            //用户名错误
            log.info("### password is fail! ###");
            return Result.FAIL("密码错误");
        }   //登录成功
        String userId = UUID.randomUUID().toString();
        String role = "admin";

        // 创建token
        String token = JwtTokenUtil.createJWT(userId, user.getUsername(), role, audience, response);
        log.info("### 登录成功, token={} ###", token);

        // 将token放在响应头
        response.setHeader(JwtTokenUtil.AUTH_HEADER_KEY, JwtTokenUtil.TOKEN_PREFIX + token);
        // 将token响应给客户端
        JSONObject result = new JSONObject();
        result.put("token", token);
        return Result.SUCCESS(result);
    }

}
