package com.springboot.manytomany.employee.controller;

import com.springboot.manytomany.employee.entity.Employee;
import com.springboot.manytomany.employee.service.EmployeeService;
import com.springboot.manytomany.project.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/employee")
public class EmployeeController {

    private final EmployeeService employeeService;
    private final ProjectService projectService;

    @Autowired
    public EmployeeController(EmployeeService employeeService, ProjectService projectService) {
        this.employeeService = employeeService;
        this.projectService = projectService;
    }

    // Displays the list of employees
    @GetMapping("/getEmployees")
    public String getEmployees(Model model) {
        model.addAttribute("employees", employeeService.getEmployeeDetails());  // Add employees directly to model
        return "employee-list";  // Return Thymeleaf view for employee list
    }

    // Displays the form to add or update an employee
    @GetMapping("/save")
    public String addEmployeeForm(Model model) {
        model.addAttribute("employee", new Employee());  // Add an empty employee object to the model
        model.addAttribute("projects", projectService.getProjectDetails(null));  // Add list of projects to model
        return "employee-form";  // Return Thymeleaf view for adding a new employee
    }

    // Displays the form to edit an existing employee
    @GetMapping("/edit/{empId}")
    public String editEmployeeForm(@PathVariable Long empId, Model model) {
        Employee employee = employeeService.getEmployeeById(empId);  // Get employee by ID
        model.addAttribute("employee", employee);  // Add employee data to model
        model.addAttribute("projects", projectService.getProjectDetails(null));  // Add list of projects to model
        return "employee-form";  // Return the edit employee form
    }

    // Save or update the employee data
    @PostMapping("/save")
    public String saveOrUpdateEmployee(@ModelAttribute Employee empObj, @RequestParam("projectId") List<Long> projectId, Model model) {
        String errorMessage = employeeService.saveOrUpdateEmployee(empObj, projectId);  // Save or update employee with project validation
        if (errorMessage != null) {
            model.addAttribute("errorMessage", errorMessage);  // Add error message to model
            model.addAttribute("employee", empObj);  // Add employee data to model
            model.addAttribute("projects", projectService.getProjectDetails(null));  // Add list of projects to model
            return "employee-form";  // Return to the employee form view with error
        }
        return "redirect:/employee/getEmployees";  // Redirect to employee list if no error
    }

    // Deletes an employee
    @GetMapping("/delete/{empId}")
    public String removeEmployee(@PathVariable Long empId) {
        employeeService.deleteEmployee(empId);  // Delete the employee using the service
        return "redirect:/employee/getEmployees";  // Redirect to the employee list after deletion
    }

    // Assign a project to an employee
    @PutMapping("/{empId}/project/{projectId}")
    public String assignProjectToEmployee(@PathVariable Long empId, @PathVariable Long projectId) {
        employeeService.assignProjectToEmployee(empId, projectId);  // Assign project to employee
        return "redirect:/employee/getEmployees";  // Redirect to employee list after assignment
    }
}
