package com.springboot.manytomany.employee.repository;

import com.springboot.manytomany.employee.entity.Employee;
import com.springboot.manytomany.project.entity.Project;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Set;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
    List<Employee> findAllByEmpId(Long empId);
    // Custom query to find employee by name and assigned projects
    List<Employee> findByEmpNameAndAssignedProjects(String empName, Set<Project> assignedProjects);
}
