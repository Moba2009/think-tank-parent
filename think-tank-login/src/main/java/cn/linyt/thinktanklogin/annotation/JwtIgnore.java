package cn.linyt.thinktanklogin.annotation;

import java.lang.annotation.*;

/**
 * @Description TODO    JWT验证忽略注解
 * @Author Mojo
 * @Date 2020/4/14 4:55
 **/
@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface JwtIgnore {
}
