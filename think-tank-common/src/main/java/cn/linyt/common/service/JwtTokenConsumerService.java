package cn.linyt.common.service;

import java.io.IOException;

/**
 * @InterfaceName JwtTokenService
 * @Description TODO
 * @Author Mojo
 * @Date 2020/4/19 5:56
 * @Version 1.0
 **/
public interface JwtTokenConsumerService {

    boolean parseJwt(String token) throws IOException;
}