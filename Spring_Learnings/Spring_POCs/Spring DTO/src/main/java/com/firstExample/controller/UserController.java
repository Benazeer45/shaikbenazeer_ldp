//package com.firstExample.controller;
//
//import com.firstExample.dto.UserDTO;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PostMapping;
//
//@Controller
//public class UserController {
//
//    @GetMapping("/about")
//    public String about() {
//        return "about";
//    }
//
//    @GetMapping("/userForm")
//    public String showUserForm(Model model) {
//        // Add an empty UserDTO object to the model
//        model.addAttribute("userDTO", new UserDTO());
//        return "userForm";
//    }
//
//    @PostMapping("/submitUser")
//    public String submitUser(UserDTO userDTO, Model model) {
//        // Display the submitted data (in a real application, you'd save this to a database)
//        model.addAttribute("user", userDTO);
//        return "userDetails";
//    }
//}
//
////package com.firstExample.controller;
////
////import com.firstExample.dto.UserDTO;
////import com.firstExample.entity.User;
////import com.firstExample.repository.UserRepository;
////import org.springframework.beans.factory.annotation.Autowired;
////import org.springframework.stereotype.Controller;
////import org.springframework.ui.Model;
////import org.springframework.web.bind.annotation.GetMapping;
////import org.springframework.web.bind.annotation.PostMapping;
////
////@Controller
////public class UserController {
////
////    @Autowired
////    private UserRepository userRepository;
////
////    @GetMapping("/about")
////    public String about() {
////        return "about"; // Ensure there's an about.html template
////    }
////
////    @GetMapping("/userForm")
////    public String showUserForm(Model model) {
////        model.addAttribute("userDTO", new UserDTO());
////        return "userForm"; // Ensure there's a userForm.html template
////    }
////
////    @PostMapping("/submitUser")
////    public String submitUser(UserDTO userDTO, Model model) {
////        User user = new User();
////        user.setName(userDTO.getName());
////        user.setEmail(userDTO.getEmail());
////
////        // Save user to the database
////        userRepository.save(user);
////
////        model.addAttribute("user", user);
////        return "userDetails"; // Ensure there's a userDetails.html template
////    }
////}

//
//package com.firstExample.controller;
//
//import com.firstExample.dto.UserDTO;
//import jakarta.validation.Valid;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.validation.BindingResult;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PostMapping;
//
//@Controller
//public class UserController {
//
//    @GetMapping("/about")
//    public String about() {
//        return "about";
//    }
//
//    @GetMapping("/userForm")
//    public String showUserForm(Model model) {
//        model.addAttribute("userDTO", new UserDTO());
//        return "userForm";
//    }
//
//    @PostMapping("/submitUser")
//    public String submitUser(@Valid UserDTO userDTO, BindingResult result, Model model) {
//        if (result.hasErrors()) {
//            return "userForm";
//        }
//        model.addAttribute("user", userDTO);
//        return "userDetails";
//    }
//}

package com.firstExample.controller;

import com.firstExample.dto.UserDTO;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class UserController {

    @GetMapping("/about")
    public String about() {
        return "about";
    }

    @GetMapping("/userForm")
    public String showUserForm(Model model) {
        model.addAttribute("userDTO", new UserDTO());
        return "userForm";
    }

    @PostMapping("/submitUser")
    public String submitUser(@Valid UserDTO userDTO, BindingResult result, Model model) {
        // Check for validation errors
        if (result.hasErrors()) {
            model.addAttribute("error", "Validation failed. Please check your input.");
            return "userForm";
        }

        if (userDTO.getId() < 1) {
            result.rejectValue("id", "error.userDTO", "ID must be a positive integer, give +ve number");
            return "userForm";
        }

        if (userDTO.getName() == null || userDTO.getName().length() < 2) {
            result.rejectValue("name", "error.userDTO", "Name must be at least 2 characters long");
            return "userForm";
        }

        // Simulate email validation error (if needed)
        if (!userDTO.getEmail().matches("^[A-Za-z0-9+_.-]+@(.+)$")) {
            result.rejectValue("email", "error.userDTO", "Email should be valid");
            return "userForm";
        }

        model.addAttribute("user", userDTO);
        return "userDetails";
    }
}

