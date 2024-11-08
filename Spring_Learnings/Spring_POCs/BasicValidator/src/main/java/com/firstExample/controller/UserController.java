package com.firstExample.controller;

import com.firstExample.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

@Controller
public class UserController {

    @GetMapping("/register")
    public String showForm(Model model) {
        model.addAttribute("user", new User());
        return "register"; // Return the registration page
    }

    @PostMapping("/register") // Ensure the endpoint matches the form action
    public String submitForm(@Valid @ModelAttribute("user") User user, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "register";  // Return to the registration page if validation fails
        }
        System.out.println(result);
        model.addAttribute("message", "User registered successfully!");
        return "success";  // Render the success page if no validation errors
    }
}
