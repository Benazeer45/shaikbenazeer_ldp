package com.firstExample;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;

@Controller
public class ContactController {

    @RequestMapping("/contact")
    public String showForm(Model model) {
        return "contactForm"; // Ensure you have contactForm.html in the correct location
    }

//    @RequestMapping(path="/processForm",method = RequestMethod.POST)
//    public String handleForm(HttpServletRequest request) {
//        String email = request.getParameter("email");
//        System.out.println("Email is: " + email);
//        return "formSuccess"; // Redirect to a success page or back to the form
//    }

    @RequestMapping(path="/processForm",method = RequestMethod.POST)
    public String handleForm(@RequestParam("email") String userEmail, @RequestParam("username") String username, @RequestParam("password") String userPassword) {
        System.out.println("Email is: " + userEmail);
        System.out.println("Username is: "+username);
        System.out.println(("User Password is: "+userPassword));
        return "success"; // Redirect to a success page or back to the form
    }
}
