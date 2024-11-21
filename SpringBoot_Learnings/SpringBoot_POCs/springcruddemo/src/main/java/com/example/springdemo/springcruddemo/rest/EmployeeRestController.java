//package com.example.springdemo.springcruddemo.rest;
//
//import com.example.springdemo.springcruddemo.entity.Employee;
//import com.example.springdemo.springcruddemo.service.EmployeeService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.List;
//
//@RestController
//@RequestMapping("/api")
//public class EmployeeRestController {
//
//    private final EmployeeService employeeService;
//
//    @Autowired
//    public EmployeeRestController(EmployeeService employeeService) {
//        this.employeeService = employeeService;
//    }
//
//    // Expose /employees and return list of employees
//    @GetMapping("/employees")
//    public List<Employee> findAll() {
//        return employeeService.findAll();
//    }
//
//    // Expose /employees/{employeeId} and return a single employee
//    @GetMapping("/employees/{employeeId}")
//    public Employee getEmployee(@PathVariable int employeeId) {
//        Employee theEmployee = employeeService.findById(employeeId);
//        if (theEmployee == null) {
//            throw new RuntimeException("Employee id is not found - " + employeeId);
//        }
//        return theEmployee;
//    }
//
//    // Add a new employee (POST)
//    @PostMapping("/employees")
//    public Employee addEmployee(@RequestBody Employee theEmployee) {
//        theEmployee.setId(0);  // Ensure the ID is 0 to force an insert
//        employeeService.save(theEmployee);
//        return theEmployee;
//    }
//
//    // Update an existing employee (PUT)
//    @PutMapping("/employees")
//    public Employee updateEmployee(@RequestBody Employee theEmployee) {
//        // Ensure that the employee ID is valid (exists in the database)
//        if (theEmployee.getId() == 0) {
//            throw new RuntimeException("Employee ID cannot be 0 for update.");
//        }
//
//        // Save or update the employee
//        employeeService.save(theEmployee);
//        return theEmployee;
//    }
//
//    // Delete an employee by ID (DELETE)
//    @DeleteMapping("/employees/{employeeId}")
//    public String deleteEmployee(@PathVariable int employeeId) {
//        Employee theEmployee = employeeService.findById(employeeId);
//        if (theEmployee == null) {
//            throw new RuntimeException("Employee id is not found - " + employeeId);
//        }
//
//        // Delete the employee
//        employeeService.deleteById(employeeId);
//        return "Deleted employee id - " + employeeId;
//    }
//}
