package cn.linyt.common.service;

import cn.linyt.common.exception.CustomException;
import io.jsonwebtoken.Claims;

/**
 * @InterfaceName ParseTokenService
 * @Description TODO
 * @Author Mojo
 * @Date 2020/4/23 4:56
 * @Version 1.0
 **/
public interface ParseTokenService {

    Claims parseToken(String jsonWebToken) throws CustomException;
}
