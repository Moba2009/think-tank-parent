package cn.linyt.thinktanklogin.service;

import java.io.IOException;

/**
 * @InterfaceName JwtTokenService
 * @Description TODO
 * @Author Mojo
 * @Date 2020/4/19 5:56
 * @Version 1.0
 **/
public interface JwtTokenProviderService {

    boolean parseJwt(String token) throws IOException;
    String setValue();
}
