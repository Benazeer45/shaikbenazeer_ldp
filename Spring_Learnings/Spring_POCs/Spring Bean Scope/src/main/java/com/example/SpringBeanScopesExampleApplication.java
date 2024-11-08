package com.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringBeanScopesExampleApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringBeanScopesExampleApplication.class, args);
        System.out.println("Application has started successfully!");
    }
}
