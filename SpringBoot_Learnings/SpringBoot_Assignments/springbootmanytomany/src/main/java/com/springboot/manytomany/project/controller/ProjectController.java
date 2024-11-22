package com.springboot.manytomany.project.controller;

import com.springboot.manytomany.project.entity.Project;
import com.springboot.manytomany.project.service.ProjectService;
import com.springboot.manytomany.employee.service.EmployeeService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("/project")
public class ProjectController {

    private final ProjectService projectService;
    private final EmployeeService employeeService;

    public ProjectController(ProjectService projectService, EmployeeService employeeService) {
        this.projectService = projectService;
        this.employeeService = employeeService;
    }

    // Displays the list of projects
    @GetMapping("/getProjects")
    public String getProjects(Model model) {
        model.addAttribute("projects", projectService.getProjectDetails(null));  // Refactored to directly set attribute
        return "project-list";  // Return Thymeleaf view for project list
    }

    // Displays the form to add or update a project
    @GetMapping("/save")
    public String addOrUpdateProjectForm(@RequestParam(required = false) Long projectId, Model model) {
        model.addAttribute("project", projectService.getProjectById(projectId).orElse(new Project()));  // Directly use it in addAttribute
        model.addAttribute("employees", employeeService.getEmployeeDetails(null));  // Add list of employees to model
        return "project-form";  // Return Thymeleaf view for adding or updating a project
    }

    // Save or update project data
    @PostMapping("/save")
    public String saveOrUpdateProject(@ModelAttribute Project project, @RequestParam("employeeIds") List<Long> employeeIds, Model model) {
        try {
            projectService.saveProject(project, employeeIds);
        } catch (IllegalArgumentException e) {
            model.addAttribute("errorMessage", e.getMessage());
            model.addAttribute("project", project);
            model.addAttribute("employees", employeeService.getEmployeeDetails(null));
            return "project-form";
        }
        return "redirect:/project/getProjects";
    }

    // Delete a project and display a message
    @GetMapping("/delete/{projectId}")
    public String removeProject(@PathVariable Long projectId, RedirectAttributes redirectAttributes) {
        try {
            projectService.deleteProject(projectId);
            redirectAttributes.addFlashAttribute("message", "Project deleted successfully!");
        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("error", "Error occurred while deleting the project due to constraints.");
        }
        return "redirect:/project/getProjects";
    }
}
