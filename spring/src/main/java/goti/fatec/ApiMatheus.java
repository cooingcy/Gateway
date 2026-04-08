package goti.fatec;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients(basePackages = "goti.fatec")
@SpringBootApplication(scanBasePackages = "goti.fatec")
public class ApiMatheus {
    public static void main(String[] args) {
        SpringApplication.run(ApiMatheus.class, args);
    }
}