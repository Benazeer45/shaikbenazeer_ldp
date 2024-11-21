package com.springboot.manytomany.project.repository;

import com.springboot.manytomany.project.entity.Project;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProjectRepository extends JpaRepository<Project, Long> {
    List<Project> findAllByProjectId(long projectId);
}
