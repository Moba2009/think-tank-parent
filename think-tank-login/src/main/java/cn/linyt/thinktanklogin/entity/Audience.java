package cn.linyt.thinktanklogin.entity;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @ClassName Audience
 * @Description TODO    JWT配置信息的实体类，以便获取JWT配置
 * @Author Mojo
 * @Date 2020/4/14 3:41
 * @Version 1.0
 **/
@ConfigurationProperties(prefix = "audience")
@Data
@Component
public class Audience {

    private String clientId;
    private String base64Secret;
    private String name;
    private int expiresSecond;
}
