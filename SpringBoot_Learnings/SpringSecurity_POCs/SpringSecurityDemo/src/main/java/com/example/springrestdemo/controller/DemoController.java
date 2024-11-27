package com.example.springrestdemo.controller;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DemoController {

    @GetMapping("/")
    public String home(Model model) {
        // Get the current authenticated user
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String username = authentication.getName(); // Get the username
        String roles = authentication.getAuthorities().toString(); // Get roles

        // Add user details to the model
        model.addAttribute("username", username);
        model.addAttribute("roles", roles);
        return "home"; // Return home.jsp
    }
}
