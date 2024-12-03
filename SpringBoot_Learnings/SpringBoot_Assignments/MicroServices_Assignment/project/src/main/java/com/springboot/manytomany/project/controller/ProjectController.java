package com.springboot.manytomany.project.controller;

import com.springboot.manytomany.project.entity.Project;
import com.springboot.manytomany.project.exception.ResourceNotFoundException;
import com.springboot.manytomany.project.service.ProjectService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/projects")  // Use versioning at the API level
public class ProjectController {

    private final ProjectService projectService;

    public ProjectController(ProjectService projectService) {  // Use constructor injection
        this.projectService = projectService;
    }

    @GetMapping
    public ResponseEntity<List<Project>> getAllProjects() {
        List<Project> projects = projectService.getAllProjects();
        return new ResponseEntity<>(projects, HttpStatus.OK);
    }

    @GetMapping("/{id}")  // Replaced projectId with id for consistent naming
    public ResponseEntity<Project> getProjectById(@PathVariable Long id) {
        Project project = projectService.getProjectById(id);
        if (project == null) {
            throw new ResourceNotFoundException("Project not found with ID: " + id);
        }
        return new ResponseEntity<>(project, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<String> createOrUpdateProject(@RequestBody Project project) {
        try {
            projectService.createOrUpdate(project);
            return new ResponseEntity<>("Project saved successfully", HttpStatus.CREATED);
        } catch (IllegalArgumentException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/{id}")  // Replaced projectId with id for consistent naming
    public ResponseEntity<String> deleteProject(@PathVariable Long id) {
        try {
            if (!projectService.existsById(id)) {  // Check if the project exists at the service level
                throw new ResourceNotFoundException("Project not found with ID: " + id);
            }
            projectService.deleteProject(id);
            return new ResponseEntity<>("Project deleted successfully", HttpStatus.OK);
        } catch (ResourceNotFoundException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        } catch (Exception e) {
            return new ResponseEntity<>("Error deleting project", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
