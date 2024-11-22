package com.example.springboot.thymeleafdemo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.time.LocalDate;

@Controller
public class DemoController {

    @GetMapping("/hello")
    public String showHelloPage(Model model) {
        // Add attributes to the model
        model.addAttribute("message", "Hello, World!");
        model.addAttribute("currentDate", LocalDate.now());

        // Return the Thymeleaf template name
        return "hello";
    }
}
