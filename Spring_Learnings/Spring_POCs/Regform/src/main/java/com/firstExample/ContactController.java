package com.firstExample;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ContactController {

    @RequestMapping("/contact")
    public String showForm(Model model) {
        return "contactForm"; // Ensure you have contactForm.html in the correct location
    }

    @PostMapping("/processForm")
    public String handleForm(
            @RequestParam("email") String userEmail,
            @RequestParam("username") String username,
            @RequestParam("password") String userPassword,
            @RequestParam("dropdownOption") String dropdownOption,
            @RequestParam("gender") String gender,
            @RequestParam(value = "subscribe", required = false) String subscribe, // Optional parameter
            Model model) {

        // Add attributes to the model to display on the success page
        model.addAttribute("email", userEmail);
        model.addAttribute("username", username);
        model.addAttribute("dropdownOption", dropdownOption);
        model.addAttribute("gender", gender);
        model.addAttribute("subscribe", subscribe); // Can be null if not checked

        return "success"; // Redirect to the success page
    }
}
