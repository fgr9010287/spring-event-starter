package cn.mashang.event.sample;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "cn.mashang")
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
