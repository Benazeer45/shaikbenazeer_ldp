package com.springboot.manytomany.project.service.Impl;//package com.springboot.manytomany.project.service.Impl;
//
//import com.springboot.manytomany.project.entity.Project;
//import com.springboot.manytomany.project.repository.ProjectRepository;
//import com.springboot.manytomany.project.service.ProjectService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import java.util.List;
//
//@Service
//public class ProjectServiceImpl implements ProjectService {
//
//    @Autowired
//    private ProjectRepository projectRepository;
//
//    // Method to save a project (without employee handling)
//    @Override
//    public String saveProject(Project project) {
//        if (project.getProjectName() == null || project.getProjectName().isEmpty()) {
//            throw new IllegalArgumentException("Project name should not be empty");
//        }
//
//        // Save the project without worrying about employees
//        projectRepository.save(project);
//        return "Project saved successfully";
//    }
//
//    // This method is now unused but still defined (can be removed if not required in the future)
//    @Override
//    public String saveProject(Project project, List<Long> employeeIds) {
//        return "Method not used for employee association";  // Placeholder response
//    }
//
//    // Fetch project details by ID or all projects
//    @Override
//    public List<Project> getProjectDetails(Long projectId) {
//        return projectId != null ? projectRepository.findAllById(List.of(projectId)) : projectRepository.findAll();
//    }
//
//    // Delete project by its ID
//    @Override
//    public void deleteProject(Long projectId) {
//        projectRepository.deleteById(projectId);
//    }
//
//    // Fetch project by its ID
//    @Override
//    public Project getProjectById(Long projectId) {
//        return projectRepository.findById(projectId).orElse(null);
//    }
//}


//package com.springboot.manytomany.project.service.Impl;
//
//import com.springboot.manytomany.project.entity.Project;
//import com.springboot.manytomany.project.repository.ProjectRepository;
//import com.springboot.manytomany.project.service.ProjectService;
//import org.springframework.stereotype.Service;
//
//import java.util.List;
//
//@Service
//public class ProjectServiceImpl implements ProjectService {
//
//    private final ProjectRepository projectRepository;
//
//    public ProjectServiceImpl(ProjectRepository projectRepository) {
//        this.projectRepository = projectRepository;
//    }
//
//    @Override
//    public Project createOrUpdate(Project project) {
//        if (project.getProjectName() == null || project.getProjectName().isEmpty()) {
//            throw new IllegalArgumentException("Project name should not be empty");
//        }
//        return projectRepository.save(project); // Save or update the project
//    }
//
//    @Override
//    public List<Project> getAllProjects() {
//        return projectRepository.findAll(); // Return all projects
//    }
//
//    @Override
//    public Project getProjectById(Long projectId) {
//        return projectRepository.findById(projectId)
//                .orElseThrow(() -> new RuntimeException("Project not found with ID: " + projectId)); // Find project by ID or throw an exception
//    }
//
//    @Override
//    public void deleteProject(Long projectId) {
//        projectRepository.deleteById(projectId); // Delete project by ID
//    }
//
//    @Override
//    public List<Project> getProjectDetails(Long projectId) {
//        return projectId != null ? projectRepository.findAllById(List.of(projectId)) : projectRepository.findAll();
//    }
//
//
//}


import com.springboot.manytomany.project.entity.Project;
import com.springboot.manytomany.project.repository.ProjectRepository;
import com.springboot.manytomany.project.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProjectServiceImpl implements ProjectService {

    @Autowired
    private ProjectRepository projectRepository;

    @Override
    public void createOrUpdate(Project project) {
        if (project.getProjectName() == null || project.getProjectName().isEmpty()) {
            throw new IllegalArgumentException("Project name should not be empty");
        }
        if (project.getProjectId() == null) {
            // Manually set the ID if auto-generation is unavailable
            project.setProjectId(generateProjectId());
        }
        projectRepository.save(project);
    }

    private Long generateProjectId() {
        // Custom logic to generate a unique ID if the database doesn’t auto-generate it
        Long maxId = projectRepository.findMaxProjectId();
        return maxId != null ? maxId + 1 : 1L;
    }

    @Override
    public List<Project> getAllProjects() {
        return projectRepository.findAll();
    }

    @Override
    public List<Project> getProjectDetails(Long projectId) {
        return projectId != null ? projectRepository.findAllById(List.of(projectId)) : projectRepository.findAll();
    }

    @Override
    public Project getProjectById(Long projectId) {
        return projectRepository.findById(projectId).orElse(null);
    }

    @Override
    public void deleteProject(Long projectId) {
        projectRepository.deleteById(projectId);
    }
}

