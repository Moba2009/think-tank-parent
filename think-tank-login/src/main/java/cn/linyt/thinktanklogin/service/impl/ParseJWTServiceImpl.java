package cn.linyt.thinktanklogin.service.impl;

import cn.linyt.common.exception.CustomException;
import cn.linyt.common.service.ParseJWTService;
import cn.linyt.thinktanklogin.entity.Audience;
import cn.linyt.thinktanklogin.utils.JwtTokenUtil;
import io.jsonwebtoken.Claims;
import org.apache.dubbo.config.annotation.Service;
import org.springframework.beans.factory.annotation.Autowired;


/**
 * @ClassName ParseJWTServiceImpl
 * @Description TODO
 * @Author Mojo
 * @Date 2020/4/23 1:19
 * @Version 1.0
 **/
@Service
public class ParseJWTServiceImpl implements ParseJWTService {

    @Autowired
    private Audience audience;

    @Override
    public Claims parseJWT(String jsonWebToken) throws CustomException {

        return JwtTokenUtil.parseJWT(jsonWebToken, audience.getBase64Secret());
    }

    @Override
    public String getHello() {

        return "hello world";
    }
}
