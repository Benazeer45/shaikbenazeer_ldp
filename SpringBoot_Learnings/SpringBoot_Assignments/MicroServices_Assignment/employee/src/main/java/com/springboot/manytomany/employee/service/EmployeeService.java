package com.springboot.manytomany.employee.service;

import com.springboot.manytomany.employee.entity.Employee;
import com.springboot.manytomany.employee.entity.Project;

import java.util.List;

public interface EmployeeService {
    String saveOrUpdateEmployee(Employee emp, List<Long> projectIds);
    List<Employee> getEmployeeDetails(Long empId);
    void deleteEmployee(Long empId);
    Employee getEmployeeById(Long empId);
    Employee assignProjectToEmployee(Long empId, Long projectId);
}
