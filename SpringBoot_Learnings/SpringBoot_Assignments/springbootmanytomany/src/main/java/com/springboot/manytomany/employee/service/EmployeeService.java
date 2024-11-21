package com.springboot.manytomany.employee.service;

import com.springboot.manytomany.employee.entity.Employee;
import com.springboot.manytomany.employee.repository.EmployeeRepository;
import com.springboot.manytomany.project.entity.Project;
import com.springboot.manytomany.project.repository.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private ProjectRepository projectRepository;

    public String saveOrUpdateEmployee(Employee emp, List<Long> projectId) {
        // Convert List to Set of Projects
        Set<Project> projects = new HashSet<>(projectRepository.findAllById(projectId));

        // Check if an employee with the same name and same project assignments already exists
        List<Employee> existingEmployees = employeeRepository.findByEmpNameAndAssignedProjects(emp.getEmpName(), projects);
        if (!existingEmployees.isEmpty()) {
            return "Employee with the same name and assigned projects already exists."; // Return error message
        }

        // If no duplicate exists, save or update the employee
        emp.setAssignedProjects(projects);
        employeeRepository.save(emp);  // Save employee, if ID is present, it will update
        return null;  // No error, successful save or update
    }

    // Get all employee details or by employee ID
    public List<Employee> getEmployeeDetails(Long empId) {
        if (empId != null) {
            return employeeRepository.findAllByEmpId(empId);
        } else {
            return employeeRepository.findAll();
        }
    }

    // Delete employee
    public void deleteEmployee(Long empId) {
        employeeRepository.deleteById(empId);
    }

    // Get employee details by ID
    public Employee getEmployeeById(Long empId) {
        return employeeRepository.findById(empId).orElse(null);
    }

    // Assign project to employee
    public Employee assignProjectToEmployee(Long empId, Long projectId) {
        Employee employee = employeeRepository.findById(empId).get();
        Project project = projectRepository.findById(projectId).get();
        employee.getAssignedProjects().add(project);
        return employeeRepository.save(employee);
    }

}
