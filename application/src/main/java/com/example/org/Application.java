
package com.example.org;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = {"com.example.org.persistence.config", "com.example.org.controller"})
public class  Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}