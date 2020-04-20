package cn.linyt.thinktankmedicine.filter;


import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Enumeration;

/**
 * @ClassName CustomCorsFilter
 * @Description TODO
 * @Author Mojo
 * @Date 2020/4/20 21:55
 * @Version 1.0
 **/
@Configuration
@Order(Integer.MIN_VALUE)
@Slf4j
public class CustomCorsFilter implements Filter {

    @Override
    public void destroy() {

    }

    @Override
    public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain)
            throws IOException, ServletException {

        HttpServletRequest request = (HttpServletRequest) req;
        HttpServletResponse response = (HttpServletResponse) res;
        log.info("Authorization={}",request.getHeader("Authorization"));
        Enumeration<String> es = request.getHeaderNames();
        String s = "";
        while (es.hasMoreElements()){
            s = es.nextElement()+","+s;
        }
        log.info(s);
        response.setHeader("Access-Control-Allow-Origin", "*");
        response.setHeader("Access-Control-Allow-Methods", "POST, GET, OPTIONS, DELETE,PUT");
        response.setHeader("Access-Control-Max-Age", "3600");
        response.setHeader("Access-Control-Allow-Headers", "Content-Type,X-Requested-With,accept,Origin,Access-Control-Request-Method,Access-Control-Request-Headers,Authorization");
        chain.doFilter(req, res);

    }

    @Override
    public void init(FilterConfig arg0) throws ServletException {

    }
}
