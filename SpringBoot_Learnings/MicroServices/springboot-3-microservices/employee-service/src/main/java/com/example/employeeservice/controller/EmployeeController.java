package com.example.employeeservice.controller;

import com.example.employeeservice.model.Employee;
import com.example.employeeservice.repository.EmployeeRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

    private static final Logger LOGGER = LoggerFactory.getLogger(EmployeeController.class);

    private final EmployeeRepository repository;

    // Constructor injection for dependency
    public EmployeeController(EmployeeRepository repository) {
        this.repository = repository;
    }

    @PostMapping
    public Employee add(@RequestBody Employee employee) {
        LOGGER.info("Employee add: {}", employee);
        return repository.add(employee);
    }

    @GetMapping
    public List<Employee> findAll() {
        LOGGER.info("Employee find all");
        return repository.findAll();
    }

    @GetMapping("/{id}")
    public Employee findById(@PathVariable Long id) {
        LOGGER.info("Employee find: id={}", id);
        return repository.findById(id);
    }

    @GetMapping("/departments/{id}")
    public List<Employee> findByDepartment(@PathVariable Long id) {
        LOGGER.info("Employee find: departmentId={}", id);
        return repository.findByDepartment(id);
    }
}
