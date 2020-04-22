package cn.linyt.thinktankmedicine;

import org.apache.dubbo.config.spring.context.annotation.DubboComponentScan;
import org.apache.dubbo.config.spring.context.annotation.EnableDubbo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@EnableDubbo
@DubboComponentScan(basePackages = "cn.linyt.thinktankmedicine.interceptor")
@SpringBootApplication
public class ThinkTankMedicineApplication {

    public static void main(String[] args) {
        SpringApplication.run(ThinkTankMedicineApplication.class, args);
    }

}
