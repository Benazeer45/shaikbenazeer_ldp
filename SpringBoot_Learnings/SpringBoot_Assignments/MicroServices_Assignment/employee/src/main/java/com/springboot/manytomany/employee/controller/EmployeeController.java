package com.springboot.manytomany.employee.controller;

import com.springboot.manytomany.employee.entity.Employee;
import com.springboot.manytomany.employee.service.Impl.EmployeeServiceImpl;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

    private final EmployeeServiceImpl employeeService;

    public EmployeeController(EmployeeServiceImpl employeeService) {
        this.employeeService = employeeService;
    }

    // Get all employees
    @GetMapping
    public List<Employee> getAllEmployees() {
        return employeeService.getEmployeeDetails(); // Removed null parameter
    }

    // Get employee by ID
    @GetMapping("/{id}")
    public Employee getEmployeeById(@PathVariable Long id) {
        return employeeService.getEmployeeById(id); // Fetch employee by ID
    }

    // Create a new employee
    @PostMapping
    public ResponseEntity<Employee> createEmployee(@RequestBody Employee employee) {
        Employee createdEmployee = employeeService.saveOrUpdateEmployee(employee, null); // Save employee without projects
        return new ResponseEntity<>(createdEmployee, HttpStatus.CREATED); // Return newly created entity
    }

    // Update an existing employee
    @PutMapping("/{id}")
    public ResponseEntity<String> updateEmployee(@PathVariable Long id, @RequestBody Employee employee) {
        Employee existingEmployee = employeeService.getEmployeeById(id);
        if (existingEmployee == null) {
            return new ResponseEntity<>("Employee not found with ID: " + id, HttpStatus.NOT_FOUND);
        }
        existingEmployee.setEmpName(employee.getEmpName());
        employeeService.saveOrUpdateEmployee(existingEmployee, null);
        return new ResponseEntity<>("Updated employee successfully", HttpStatus.OK);
    }

    // Delete an employee
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteEmployee(@PathVariable Long id) {
        employeeService.deleteEmployee(id);
        return new ResponseEntity<>("Employee deleted successfully", HttpStatus.OK);
    }

    // Assign a project to an employee
    @PutMapping("/{empId}/projects/{projectId}")
    public ResponseEntity<String> assignProject(@PathVariable Long empId, @PathVariable Long projectId) {
        employeeService.assignProjectToEmployee(empId, projectId);
        return new ResponseEntity<>("Assigned project to employee successfully", HttpStatus.OK);
    }
}
