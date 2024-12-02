package com.springboot.manytomany.project.controller;//package com.springboot.manytomany.project.controller;
//
//import com.springboot.manytomany.project.entity.Project;
//import com.springboot.manytomany.project.service.ProjectService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.List;
//
//@RestController
//@RequestMapping("/api/project")
//public class ProjectController {
//
//    @Autowired
//    private ProjectService projectService;
//
//    // Endpoint to get all projects or project by ID
//    @GetMapping("/getProjects")
//    public ResponseEntity<List<Project>> getProjects() {
//        List<Project> projects = projectService.getProjectDetails(null);  // Pass null to get all projects
//        return new ResponseEntity<>(projects, HttpStatus.OK);  // Return the list of projects with status 200
//    }
//
//    // Get a specific project by its ID
//    @GetMapping("/{projectId}")
//    public ResponseEntity<Project> getProjectById(@PathVariable Long projectId) {
//        Project project = projectService.getProjectById(projectId);
//        if (project == null) {
//            return new ResponseEntity<>(HttpStatus.NOT_FOUND);  // Return 404 if project is not found
//        }
//        return new ResponseEntity<>(project, HttpStatus.OK);  // Return project with status 200
//    }
//
//    // Save or update project data
//    @PostMapping("/save")
//    public ResponseEntity<String> saveOrUpdateProject(@RequestBody Project project) {
//        try {
//            projectService.saveProject(project);  // Save the project without employees
//            return new ResponseEntity<>("Project saved successfully", HttpStatus.CREATED);  // Return 201 on success
//        } catch (IllegalArgumentException e) {
//            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);  // Return 400 if validation fails
//        }
//    }
//
//    // Delete a project by its ID
//    @DeleteMapping("/delete/{projectId}")
//    public ResponseEntity<String> deleteProject(@PathVariable Long projectId) {
//        try {
//            projectService.deleteProject(projectId);  // Attempt to delete the project
//            return new ResponseEntity<>("Project deleted successfully!", HttpStatus.OK);  // Return 200 on success
//        } catch (Exception e) {
//            return new ResponseEntity<>("Error occurred while deleting the project", HttpStatus.INTERNAL_SERVER_ERROR);  // Return 500 if error occurs
//        }
//    }
//}



import com.springboot.manytomany.project.entity.Project;
import com.springboot.manytomany.project.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/projects")
public class ProjectController {

    @Autowired
    private ProjectService projectService;

    @GetMapping
    public ResponseEntity<List<Project>> getAllProjects() {
        List<Project> projects = projectService.getAllProjects();
        return new ResponseEntity<>(projects, HttpStatus.OK);
    }

//     Endpoint to get all projects or project by ID
    @GetMapping("/getProjects")
    public ResponseEntity<List<Project>> getProjects() {
        List<Project> projects = projectService.getProjectDetails(null);  // Pass null to get all projects
        return new ResponseEntity<>(projects, HttpStatus.OK);  // Return the list of projects with status 200
    }

    @GetMapping("/{projectId}")
    public ResponseEntity<Project> getProjectById(@PathVariable Long projectId) {
        Project project = projectService.getProjectById(projectId);
        if (project == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
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

//    @PostMapping("/save")
//    public ResponseEntity<String> saveOrUpdateProject(@RequestBody Project project) {
//        try {
//            projectService.saveProject(project);  // Save the project without employees
//            return new ResponseEntity<>("Project saved successfully", HttpStatus.CREATED);  // Return 201 on success
//        } catch (IllegalArgumentException e) {
//            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);  // Return 400 if validation fails
//        }
//    }

    @DeleteMapping("/{projectId}")
    public ResponseEntity<String> deleteProject(@PathVariable Long projectId) {
        try {
            projectService.deleteProject(projectId);
            return new ResponseEntity<>("Project deleted successfully", HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("Error deleting project", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
