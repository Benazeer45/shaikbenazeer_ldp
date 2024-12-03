package com.springboot.manytomany.project.service.Impl;

import com.springboot.manytomany.project.entity.Project;
import com.springboot.manytomany.project.exception.ResourceNotFoundException;
import com.springboot.manytomany.project.repository.ProjectRepository;
import com.springboot.manytomany.project.service.ProjectService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProjectServiceImpl implements ProjectService {

    private final ProjectRepository projectRepository;

    public ProjectServiceImpl(ProjectRepository projectRepository) {  // Use constructor injection
        this.projectRepository = projectRepository;
    }

    @Override
    public void createOrUpdate(Project project) {
        // Validate at the entity level using annotations (e.g., @NotEmpty, @NotNull in Project entity)
        projectRepository.save(project);
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
        return projectRepository.findById(projectId)
                .orElseThrow(() -> new ResourceNotFoundException("Project not found with ID: " + projectId));
    }

    @Override
    public void deleteProject(Long projectId) {
        if (!projectRepository.existsById(projectId)) {  // Check if the project exists before deleting
            throw new ResourceNotFoundException("Project not found with ID: " + projectId);
        }
        projectRepository.deleteById(projectId);
    }
}
