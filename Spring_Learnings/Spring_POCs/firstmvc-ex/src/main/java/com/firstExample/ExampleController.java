package com.firstExample;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
//@RequestMapping("/app")
public class ExampleController {

    private final Map<Integer, User> users = new HashMap<>();
    private int currentId = 1;

    // User class to hold user data
    static class User {
        String name;
        String email;

        User(String name, String email) {
            this.name = name;
            this.email = email;
        }
    }

    // @GetMapping example with Model attribute
    @RequestMapping(value="/home", method = RequestMethod.GET)
    public String home(Model model) {
        model.addAttribute("name", "Benazeer");
        model.addAttribute("id", 1234);

        List<String> friends = new ArrayList<>();
        friends.add("Alice");
        friends.add("Bob");
        friends.add("Charlie");
        model.addAttribute("friends", friends);

        return "home";
    }

    // @RequestParam example
    @GetMapping("/greet")
    public String greet(@RequestParam(name = "lang", defaultValue = "en") String language, Model model) {
        model.addAttribute("language", language);
        return "greet";
    }

    // @PathVariable example
    @GetMapping("/user/{id}")
    public String getUser(@PathVariable("id") int id, Model model) {
        model.addAttribute("userId", id);
        return "user";
    }

    // @ModelAttribute example
    @ModelAttribute("defaultUser")
    public String populateDefaultUser() {
        return "Guest";
    }

    // @ResponseBody example
    @GetMapping("/api/data")
    @ResponseBody
    public String getData() {
        return "Some data returned from /api/data endpoint";
    }

    // Example with ModelAndView
    @RequestMapping("/help")
    public ModelAndView help() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("name", "Shaik");
        modelAndView.addObject("rollnumber", 123);
        LocalDateTime now = LocalDateTime.now();
        modelAndView.addObject("time", now);
        modelAndView.setViewName("help");
        return modelAndView;
    }

//    // --- POST Example ---
//    @PostMapping("/addUser")
//    public String addUser(@RequestParam("name") String name, @RequestParam("email") String email, Model model) {
//        User user = new User(name, email);
//        users.put(currentId++, user); // Simulate adding a user
//        model.addAttribute("status", "User added successfully");
//        return "user"; // Returns to a "user" view or any relevant view
//    }
//
//    // --- PUT Example ---
//    @PutMapping("/updateUser/{id}")
//    @ResponseBody
//    public String updateUser(@PathVariable("id") int id, @RequestParam("name") String name, @RequestParam("email") String email) {
//        User user = users.get(id);
//        if (user != null) {
//            user.name = name;
//            user.email = email;
//            return "User with ID " + id + " updated with name: " + name + " and email: " + email;
//        }
//        return "User not found!";
//    }
//
//    // --- DELETE Example ---
//    @DeleteMapping("/deleteUser/{id}")
//    @ResponseBody
//    public String deleteUser(@PathVariable("id") int id) {
//        if (users.remove(id) != null) {
//            return "User with ID " + id + " has been deleted";
//        }
//        return "User not found!";
//    }

    // Handles 404 errors (page not found)
    @RequestMapping("/error-404")
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public String handleNotFound() {
        return "error-404";
    }
}