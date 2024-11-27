package com.example.springrestdemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

@SpringBootApplication
@EnableWebSecurity // Ensure this annotation is present for security configuration to be picked up
public class SpringRestDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringRestDemoApplication.class, args);
    }
}
