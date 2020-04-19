package cn.linyt.thinktanklogin.service.impl;

import cn.linyt.thinktanklogin.service.JwtTokenProviderService;
import cn.linyt.thinktanklogin.entity.Audience;
import cn.linyt.thinktanklogin.utils.JwtTokenUtil;
import com.alibaba.dubbo.config.annotation.Service;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.IOException;

/**
 * @ClassName JwtTokenServiceImpl
 * @Description TODO
 * @Author Mojo
 * @Date 2020/4/19 6:17
 * @Version 1.0
 **/
@Service
public class JwtTokenProviderServiceImpl implements JwtTokenProviderService {

    @Autowired
    private Audience audience;

    @Override
    public boolean parseJwt(String token) throws IOException {

        return JwtTokenUtil.parseJwt(token, audience.getBase64Secret());
    }

    @Override
    public String setValue() {

        return "dubbo";
    }
}
