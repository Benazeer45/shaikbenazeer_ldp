package com.example.springboot.thymeleafdemo.service;

import com.example.springboot.thymeleafdemo.entity.Employee;

import java.util.List;

public interface EmployeeService {
    public List<Employee> findAll();
    public Employee findById(int employeeId);
    public void save(Employee theEmployee);
    public void deleteById(int employeeId);
    public void saveOrUpdate(Employee employee);
}
