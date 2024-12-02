//package com.springboot.manytomany.project.entity;
//
//import jakarta.persistence.*;
//import lombok.Getter;
//import lombok.Setter;
//
//import java.util.HashSet;
//import java.util.Set;
//
//@Entity
//@Getter
//@Setter
//public class Employee {
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.AUTO)
//    private Long empId;
//
//    private String empName;
//
//    @ManyToMany
//    @JoinTable(
//            name = "employee_project",
//            joinColumns = @JoinColumn(name = "employee_id"),
//            inverseJoinColumns = @JoinColumn(name = "project_id")
//    )
//    private Set<Project> assignedProjects = new HashSet<>();
//}
