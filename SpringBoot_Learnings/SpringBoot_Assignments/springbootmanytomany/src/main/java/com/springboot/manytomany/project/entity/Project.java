package com.springboot.manytomany.project.entity;

import com.springboot.manytomany.employee.entity.Employee;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@Setter
@Table(name = "PROJECT")
public class Project {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long projectId;
    private String projectName;

    @JsonIgnore
    @ManyToMany(mappedBy = "assignedProjects")
    private Set<Employee> employeeSet = new HashSet<>();
}
