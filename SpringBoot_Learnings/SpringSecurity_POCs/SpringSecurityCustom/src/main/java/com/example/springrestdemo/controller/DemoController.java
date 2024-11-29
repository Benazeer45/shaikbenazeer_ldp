package com.example.springrestdemo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DemoController {

    @GetMapping("/login")
    public String login() {
        return "login"; // Return the view name for your login page
    }

    @GetMapping("/")
    public String home() {
        return "home"; // Return the view name for your home page
    }
}