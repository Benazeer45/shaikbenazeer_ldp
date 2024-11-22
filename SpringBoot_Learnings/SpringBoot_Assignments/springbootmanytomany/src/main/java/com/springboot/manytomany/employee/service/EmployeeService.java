package com.springboot.manytomany.employee.service;

import com.springboot.manytomany.employee.entity.Employee;
import com.springboot.manytomany.employee.repository.EmployeeRepository;
import com.springboot.manytomany.project.entity.Project;
import com.springboot.manytomany.project.repository.ProjectRepository;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
public class EmployeeService {

    private final EmployeeRepository employeeRepository;
    private final ProjectRepository projectRepository;

    // Constructor injection instead of @Autowired on fields
    public EmployeeService(EmployeeRepository employeeRepository, ProjectRepository projectRepository) {
        this.employeeRepository = employeeRepository;
        this.projectRepository = projectRepository;
    }

    public String saveOrUpdateEmployee(Employee emp, List<Long> projectId) {
        Set<Project> projects = new HashSet<>(projectRepository.findAllById(projectId));

        List<Employee> existingEmployees = employeeRepository.findByEmpNameAndAssignedProjects(emp.getEmpName(), projects);
        if (!existingEmployees.isEmpty()) {
            return "Employee with the same name and assigned projects already exists.";
        }

        emp.setAssignedProjects(projects);
        employeeRepository.save(emp);
        return null;
    }

    public List<Employee> getEmployeeDetails() {
        return employeeRepository.findAll();
    }

    public List<Employee> getEmployeeDetails(Long empId) {
        return Optional.ofNullable(empId)
                .map(id -> employeeRepository.findAllByEmpId(id))
                .orElseGet(this::getEmployeeDetails);
    }

    public void deleteEmployee(Long empId) {
        if (!employeeRepository.existsById(empId)) {
            throw new IllegalArgumentException("Employee with ID " + empId + " not found.");
        }
        employeeRepository.deleteById(empId);
    }

    public Employee getEmployeeById(Long empId) {
        return employeeRepository.findById(empId)
                .orElseThrow(() -> new IllegalArgumentException("Employee with ID " + empId + " not found."));
    }

    public Employee assignProjectToEmployee(Long empId, Long projectId) {
        Employee employee = employeeRepository.findById(empId)
                .orElseThrow(() -> new IllegalArgumentException("Employee with ID " + empId + " not found."));
        Project project = projectRepository.findById(projectId)
                .orElseThrow(() -> new IllegalArgumentException("Project with ID " + projectId + " not found."));
        employee.getAssignedProjects().add(project);
        return employeeRepository.save(employee);
    }
}
