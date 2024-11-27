package com.example.springrestdemo.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test")
public class DemoRestController {

    public DemoRestController() {
        System.out.println("DemoRestController initialized!");
    }

    @GetMapping("/hello")
    public String sayHello() {
        return "Hello World";
    }
}
