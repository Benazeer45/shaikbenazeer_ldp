package com.springboot.manytomany.project.controller;

import com.springboot.manytomany.project.entity.Project;
import com.springboot.manytomany.project.service.ProjectService;
import com.springboot.manytomany.employee.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("/project")
public class ProjectController {

    @Autowired
    private ProjectService projectService;

    @Autowired
    private EmployeeService employeeService;

    // Displays the list of projects
    @GetMapping("/getProjects")
    public String getProjects(Model model) {
        List<Project> projects = projectService.getProjectDetails(null);  // Pass null to get all projects
        model.addAttribute("projects", projects);  // Add projects to model
        return "project-list";  // Return Thymeleaf view for project list
    }

    // Displays the form to add or update a project
    @GetMapping("/save")
    public String addOrUpdateProjectForm(@RequestParam(required = false) Long projectId, Model model) {
        if (projectId != null) {
            Project project = projectService.getProjectById(projectId);
            model.addAttribute("project", project);
        } else {
            model.addAttribute("project", new Project());  // Add an empty project object if creating a new project
        }
        model.addAttribute("employees", employeeService.getEmployeeDetails(null));  // Add list of employees to model
        return "project-form";  // Return Thymeleaf view for adding or updating a project
    }

    // Save or update project data
    @PostMapping("/save")
    public String saveOrUpdateProject(@ModelAttribute Project project, @RequestParam("employeeIds") List<Long> employeeIds, Model model) {
        try {
            projectService.saveProject(project, employeeIds);  // Save the project and associate employees
        } catch (IllegalArgumentException e) {
            model.addAttribute("errorMessage", e.getMessage());  // Add the error message to the model
            model.addAttribute("project", project);  // Add the project back to the model in case of error
            model.addAttribute("employees", employeeService.getEmployeeDetails(null));  // Add employees again
            return "project-form";  // Return the form view with the error message
        }
        return "redirect:/project/getProjects";  // Redirect to project list after saving or updating
    }

    // Delete a project and display a message
    @GetMapping("/delete/{projectId}")
    public String removeProject(@PathVariable Long projectId, RedirectAttributes redirectAttributes) {
        try {
            // Attempt to delete the project
            projectService.deleteProject(projectId);
            // Add a success message to be displayed on the next page
            redirectAttributes.addFlashAttribute("message", "Project deleted successfully!");
        } catch (Exception e) {
            // Add an error message if something goes wrong
            redirectAttributes.addFlashAttribute("error", "Error occurred while deleting the project due to contraints");
        }
        return "redirect:/project/getProjects";  // Redirect back to the project list page
    }
}
