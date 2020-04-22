package cn.linyt.thinktankmedicine;

import org.apache.dubbo.config.spring.context.annotation.EnableDubbo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@EnableDubbo
@SpringBootApplication
public class ThinkTankMedicineApplication {

    public static void main(String[] args) {
        SpringApplication.run(ThinkTankMedicineApplication.class, args);
    }

}
