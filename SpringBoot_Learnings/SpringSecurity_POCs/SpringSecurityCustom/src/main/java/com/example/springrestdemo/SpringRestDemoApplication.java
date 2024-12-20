package com.example.springrestdemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

@SpringBootApplication
@EnableGlobalMethodSecurity(prePostEnabled=true,proxyTargetClass=true)
public class SpringRestDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringRestDemoApplication.class, args);
    }
}
