//package com.springboot.manytomany.project.service;
//
//import com.springboot.manytomany.project.entity.Project;
//
//import java.util.List;
//
//public interface ProjectService {
//
//    // Method to save a project without employees
//    String saveProject(Project project);
//
//    // Method to save a project with employee associations (currently not needed)
//    String saveProject(Project project, List<Long> employeeIds);
//
//    // Method to fetch project details by project ID
//    List<Project> getProjectDetails(Long projectId);
//
//    // Method to delete a project by ID
//    void deleteProject(Long projectId);
//
//    // Method to get project by its ID
//    Project getProjectById(Long projectId);
//}


package com.springboot.manytomany.project.service;


import com.springboot.manytomany.project.entity.Project;

import java.util.List;

public interface ProjectService {

//    // Create or update a project
//    Project createOrUpdate(Project project);
//
//    // Get all projects
//    List<Project> getAllProjects();
//
//    // Get a project by its ID
//    Project getProjectById(Long projectId);
//
//    // Delete a project by its ID
//    void deleteProject(Long projectId);
//
//    List<Project> getProjectDetails(Long projectId);

        void createOrUpdate(Project project);
        List<Project> getAllProjects();
        List<Project> getProjectDetails(Long projectId);
        Project getProjectById(Long projectId);
        void deleteProject(Long projectId);


}


