package cn.linyt.thinktankmedicine.service.impl;

import cn.linyt.common.exception.CustomException;
import cn.linyt.common.service.ParseJWTService;
import io.jsonwebtoken.Claims;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.stereotype.Service;

/**
 * @ClassName ParseTokenServiceImpl
 * @Description TODO
 * @Author Mojo
 * @Date 2020/4/23 4:57
 * @Version 1.0
 **/
//@Service
public class ParseTokenServiceImpl{

    @Reference
    private static ParseJWTService parseJWTService;

    public static Claims parseToken(String jsonWebToken) throws CustomException {

        return parseJWTService.parseJWT(jsonWebToken);
    }
}
