package cn.linyt.thinktankmedicine;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

@SpringBootApplication
@ServletComponentScan
public class ThinkTankMedicineApplication {

    public static void main(String[] args) {
        SpringApplication.run(ThinkTankMedicineApplication.class, args);
    }

}
