package com.springboot.manytomany.employee.service;

import com.springboot.manytomany.employee.entity.Project;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@FeignClient(name = "project")  // The name should match the service registered in Eureka
public interface ProjectClient {

    // Mapping the correct endpoint to fetch projects by IDs
    @GetMapping("/api/projects/getProjects")  // Correct path to match the ProjectController endpoint
    List<Project> getProjectsByIds(@RequestParam List<Long> ids);

    // Mapping the correct endpoint to fetch a project by ID
    @GetMapping("/api/projects/{projectId}")  // Correct path to match the ProjectController endpoint
    Project getProjectById(@PathVariable Long projectId);
}
