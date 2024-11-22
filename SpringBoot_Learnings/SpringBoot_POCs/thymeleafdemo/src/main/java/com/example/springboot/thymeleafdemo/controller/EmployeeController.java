package com.example.springboot.thymeleafdemo.controller;

import com.example.springboot.thymeleafdemo.entity.Employee;
import com.example.springboot.thymeleafdemo.service.EmployeeService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/employee")
public class EmployeeController {

    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/list")
    public String listEmployees(Model model) {
        model.addAttribute("employees", employeeService.findAll());
        return "employee-list"; // Thymeleaf template for employee list
    }

    @GetMapping("/form")
    public String showFormForAdd(Model model) {
        model.addAttribute("employee", new Employee()); // Create an empty employee object and add to the model
        return "employee-form"; // Thymeleaf template for adding new employee
    }

    @PostMapping("/save")
    public String saveOrUpdateEmployee(@ModelAttribute("employee") Employee employee) {
        // Use ternary operator to decide whether to save a new employee or update an existing one
        employee.getId() == 0 ? employeeService.save(employee) : employeeService.saveOrUpdate(employee);
    
        return "redirect:/employee/list"; // Redirect to the employee list page after save/update
    }
    @GetMapping("/update")
    public String showFormForUpdate(@RequestParam("employeeId") int id, Model model) {
        model.addAttribute("employee", employeeService.findById(id)); // Fetch and add employee to the model
        return "employee-form"; // Return to the employee form view for updating
    }

    // Delete an employee by ID (with confirmation)
    @GetMapping("/delete")
    public String deleteEmployee(@RequestParam("employeeId") int id, Model model) {
        model.addAttribute("employeeId", id);
        return "employee-delete-confirm"; // Thymeleaf template for confirmation
    }

    @RequestMapping("/delete")
    public String deleteEmployeeConfirmed(@RequestParam("employeeId") int id) {
        employeeService.deleteById(id); // Delete the employee by ID
        return "redirect:/employee/list"; // Redirect to the employee list page after deletion
    }
}
