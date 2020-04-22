package cn.linyt.thinktankmedicine.service.impl;

import cn.linyt.common.exception.CustomException;
import cn.linyt.common.service.ParseJWTService;
import io.jsonwebtoken.Claims;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.stereotype.Service;

import java.io.IOException;

/**
 * @ClassName ParseJWTServiceImpl
 * @Description TODO
 * @Author Mojo
 * @Date 2020/4/23 1:26
 * @Version 1.0
 **/
@Service
public class ParseJWTServiceImpl implements ParseJWTService {

    @Reference
    private ParseJWTService parseJWTService;

    @Override
    public Claims parseJWT(String jsonWebToken) throws CustomException {

        return parseJWTService.parseJWT(jsonWebToken);
    }
}
