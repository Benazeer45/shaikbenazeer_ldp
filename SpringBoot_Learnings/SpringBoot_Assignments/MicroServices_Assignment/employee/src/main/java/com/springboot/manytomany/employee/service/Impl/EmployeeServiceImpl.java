package com.springboot.manytomany.employee.service.Impl;

import com.springboot.manytomany.employee.entity.Employee;
import com.springboot.manytomany.employee.entity.Project;
import com.springboot.manytomany.employee.exception.ResourceNotFoundException;
import com.springboot.manytomany.employee.repository.EmployeeRepository;
import com.springboot.manytomany.employee.service.EmployeeService;
import com.springboot.manytomany.employee.service.ProjectClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepository employeeRepository;
    private final ProjectClient projectClient;

    @Autowired
    public EmployeeServiceImpl(EmployeeRepository employeeRepository, ProjectClient projectClient) {
        this.employeeRepository = employeeRepository;
        this.projectClient = projectClient;
    }

    @Override
    public String saveOrUpdateEmployee(Employee emp, List<Long> projectIds) {
        List<Project> projects = projectClient.getProjectsByIds(projectIds);
        List<Employee> existingEmployees = employeeRepository.findByEmpNameAndAssignedProjects(emp.getEmpName(), new HashSet<>(projects));
        if (!existingEmployees.isEmpty()) {
            return "Employee with the same name and assigned projects already exists.";
        }
        emp.setAssignedProjects(new HashSet<>(projects));
        employeeRepository.save(emp);
        return null;
    }

    @Override
    public List<Employee> getEmployeeDetails() { // Removed id parameter
        return employeeRepository.findAll();
    }

    @Override
    public void deleteEmployee(Long empId) {
        employeeRepository.deleteById(empId);
    }

    @Override
    public Employee getEmployeeById(Long empId) {
        return employeeRepository.findById(empId).orElseThrow(() -> 
            new ResourceNotFoundException("Employee not found with ID: " + empId));
    }

    @Override
    public Employee assignProjectToEmployee(Long empId, Long projectId) {
        Employee employee = employeeRepository.findById(empId).orElseThrow(() -> 
            new ResourceNotFoundException("Employee not found with ID: " + empId));
        Project project = projectClient.getProjectById(projectId); 
        employee.getAssignedProjects().add(project);
        return employeeRepository.save(employee);
    }
}
