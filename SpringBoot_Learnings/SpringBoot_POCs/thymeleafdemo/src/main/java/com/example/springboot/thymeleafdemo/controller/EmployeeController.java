package com.example.springboot.thymeleafdemo.controller;

import com.example.springboot.thymeleafdemo.entity.Employee;
import com.example.springboot.thymeleafdemo.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/employee")
public class EmployeeController {

    private final EmployeeService employeeService;

    @Autowired
    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/list")
    public String listEmployees(Model model) {
        List<Employee> theEmployees = employeeService.findAll();
        model.addAttribute("employees", theEmployees);
        return "employee-list"; // Thymeleaf template for employee list
    }

    @GetMapping("/form")
    public String showFormForAdd(Model model) {
        Employee employee = new Employee(); // Create an empty employee object
        model.addAttribute("employee", employee); // Add employee object to the model
        return "employee-form"; // Thymeleaf template for adding new employee
    }

    @PostMapping("/save")
    public String saveOrUpdateEmployee(@ModelAttribute("employee") Employee employee) {
        if (employee.getId() == 0) {
            // New employee, save it
            employeeService.save(employee);
        } else {
            // Existing employee, update it
            employeeService.saveOrUpdate(employee);
        }
        return "redirect:/employee/list"; // Redirect to the employee list page after save/update
    }

    @GetMapping("/update")
    public String showFormForUpdate(@RequestParam("employeeId") int theId, Model model) {
        Employee employee = employeeService.findById(theId); // Fetch the employee by ID
        model.addAttribute("employee", employee); // Add employee object to the model
        return "employee-form"; // Return to the employee form view for updating
    }

    // Delete an employee by ID (with confirmation)
    @GetMapping("/delete")
    public String deleteEmployee(@RequestParam("employeeId") int theId, Model model) {
        model.addAttribute("employeeId", theId);
        return "employee-delete-confirm"; // Thymeleaf template for confirmation
    }

    @RequestMapping("/delete")
    public String deleteEmployeeConfirmed(@RequestParam("employeeId") int theId) {
        employeeService.deleteById(theId); // Delete the employee by ID
        return "redirect:/employee/list"; // Redirect to the employee list page after deletion
    }
}
