package com.springboot.manytomany.employee.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.springboot.manytomany.employee.entity.Employee;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Getter
@Setter
@Table(name = "PROJECT")
public class Project {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "project_seq")
    @SequenceGenerator(name = "project_seq", sequenceName = "project_seq", allocationSize = 1)
    private Long projectId;

    private String projectName;

    @JsonIgnore
    @ManyToMany(mappedBy = "assignedProjects") // Inverse side of the relationship
    private Set<Employee> setEmployees = new HashSet<>();

    public void setEmployees(List<Employee> employees) {
    }
}
