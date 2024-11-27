package com.example.springrestdemo.controller;

import org.springframework.security.access.annotation.Secured;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DemoController {

    @GetMapping("/")
    public String home(Model model) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String username = authentication.getName();
        String roles = authentication.getAuthorities().toString();

        model.addAttribute("username", username);
        model.addAttribute("roles", roles);
        return "home";
    }

        @GetMapping("/manager")
        public String managerPage() {
            return "manager"; // manager.jsp
        }

        @GetMapping("/admin")
        public String adminPage() {
            return "admin"; // admin.jsp
        }

    @GetMapping("/access-denied")
    public String accessDenied() {
        return "access-denied"; // Return access-denied.jsp
    }
    }



