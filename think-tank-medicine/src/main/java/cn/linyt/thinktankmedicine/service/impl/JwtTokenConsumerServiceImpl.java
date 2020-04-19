package cn.linyt.thinktankmedicine.service.impl;

import cn.linyt.common.service.JwtTokenConsumerService;
import cn.linyt.common.service.JwtTokenProviderService;
import com.alibaba.dubbo.config.annotation.Reference;
import org.springframework.stereotype.Component;

import java.io.IOException;

/**
 * @ClassName JwtTokenConsumerServiceImpl
 * @Description TODO
 * @Author Mojo
 * @Date 2020/4/19 7:27
 * @Version 1.0
 **/
@Component
public class JwtTokenConsumerServiceImpl implements JwtTokenConsumerService {

    @Reference
    private JwtTokenProviderService jwtTokenProviderService;

    @Override
    public boolean parseJwt(String token) throws IOException {

        return jwtTokenProviderService.parseJwt(token);
    }

    @Override
    public String setValue() {

        return jwtTokenProviderService.setValue();
    }
}
