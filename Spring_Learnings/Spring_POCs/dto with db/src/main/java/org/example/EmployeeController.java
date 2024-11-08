package org.example;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/employees")
public class EmployeeController {
    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/add")
    public String showAddEmployeeForm(Model model) {
        model.addAttribute("employee", new EmployeeDTO());
        return "addEmployee";
    }

    @PostMapping("/submit")
    public String submitEmployeeForm(@ModelAttribute EmployeeDTO employee, Model model) {
        try {
            System.out.println("Received employee data: Name - " + employee.getName() + ", Department - " + employee.getDepartment());
            employeeService.createEmployee(employee);
            model.addAttribute("message", "Employee added successfully!");
            return "success";
        } catch (Exception e) {
            System.out.println("Error adding employee: " + e.getMessage());
            model.addAttribute("error", "An error occurred while adding the employee. Please try again.");
            return "error";
        }
    }
}