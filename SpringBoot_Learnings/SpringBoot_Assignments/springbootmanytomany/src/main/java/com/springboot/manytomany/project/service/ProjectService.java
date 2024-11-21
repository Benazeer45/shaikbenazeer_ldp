package com.springboot.manytomany.project.service;

import com.springboot.manytomany.employee.entity.Employee;
import com.springboot.manytomany.employee.service.EmployeeService;
import com.springboot.manytomany.project.entity.Project;
import com.springboot.manytomany.project.repository.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class ProjectService {

    @Autowired
    private ProjectRepository projectRepository;

    @Autowired
    private EmployeeService employeeService;

    public void saveProject(Project projectObj, List<Long> employeeIds) {
        // Fetch and associate employees
        Set<Employee> employees = new HashSet<>();
        for (Long empId : employeeIds) {
            Employee employee = employeeService.getEmployeeById(empId);
            if (employee != null) {
                employees.add(employee);
                employee.getAssignedProjects().add(projectObj); // Update reverse relationship
            }
        }
        projectObj.setEmployeeSet(employees);

        // Check if a project with the same name and employees already exists
        if (isDuplicateProject(projectObj)) {
            throw new IllegalArgumentException("Project with the same name and employee assignments already exists.");
        }

        projectRepository.save(projectObj); // Save project with updated employee set
    }

    // Check for duplicate project (same name and employees)
    private boolean isDuplicateProject(Project projectObj) {
        List<Project> existingProjects = projectRepository.findAll();
        for (Project existingProject : existingProjects) {
            if (existingProject.getProjectName().equals(projectObj.getProjectName())) {
                // Check if the same set of employees is assigned
                if (existingProject.getEmployeeSet().containsAll(projectObj.getEmployeeSet())) {
                    return true;
                }
            }
        }
        return false;
    }
    public List<Project> getProjectDetails(Long projectId) {
        if (projectId != null) {
            return projectRepository.findAllByProjectId(projectId);
        } else {
            return projectRepository.findAll();
        }
    }

    public Project getProjectById(Long projectId) {
        return projectRepository.findById(projectId).orElse(null);
    }

    public void deleteProject(Long projectId) {
        projectRepository.deleteById(projectId);
    }
}
