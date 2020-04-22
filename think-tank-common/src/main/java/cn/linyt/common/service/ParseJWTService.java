package cn.linyt.common.service;

import cn.linyt.common.exception.CustomException;
import io.jsonwebtoken.Claims;

import java.io.IOException;

/**
 * @InterfaceName ParseJWTService
 * @Description TODO
 * @Author Mojo
 * @Date 2020/4/23 1:16
 * @Version 1.0
 **/
public interface ParseJWTService {

    Claims parseJWT(String jsonWebToken) throws CustomException;
}
