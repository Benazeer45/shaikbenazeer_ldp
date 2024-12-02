package com.springboot.manytomany.employee.service.Impl;

import com.springboot.manytomany.employee.entity.Employee;
import com.springboot.manytomany.employee.entity.Project;
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
        // Get the projects from the Project Service using Feign client
        List<Project> projects = projectClient.getProjectsByIds(projectIds);

        // Check if employee already exists with the same name and project assignments
        List<Employee> existingEmployees = employeeRepository.findByEmpNameAndAssignedProjects(emp.getEmpName(), new HashSet<>(projects));
        if (!existingEmployees.isEmpty()) {
            return "Employee with the same name and assigned projects already exists.";
        }

        // Assign projects to the employee
        emp.setAssignedProjects(new HashSet<>(projects));
        employeeRepository.save(emp);
        return null;
    }

    @Override
    public List<Employee> getEmployeeDetails(Long empId) {
        if (empId != null) {
            return employeeRepository.findAllByEmpId(empId);
        } else {
            return employeeRepository.findAll();
        }
    }

    @Override
    public void deleteEmployee(Long empId) {
        employeeRepository.deleteById(empId);
    }

    @Override
    public Employee getEmployeeById(Long empId) {
        return employeeRepository.findById(empId).orElse(null);
    }

    @Override
    public Employee assignProjectToEmployee(Long empId, Long projectId) {
        Employee employee = employeeRepository.findById(empId).orElseThrow(() -> new RuntimeException("Employee not found"));
        Project project = projectClient.getProjectById(projectId);  // Fetch project details from Project Service
        employee.getAssignedProjects().add(project);
        return employeeRepository.save(employee);
    }
}
