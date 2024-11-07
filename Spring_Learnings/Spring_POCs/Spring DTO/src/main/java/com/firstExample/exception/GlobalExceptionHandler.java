package com.firstExample.exception;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.validation.BindException;

@ControllerAdvice
public class GlobalExceptionHandler {

    // Handle validation errors (like missing fields or invalid values)
    @ExceptionHandler(BindException.class)
    public String handleValidationException(BindException ex, RedirectAttributes redirectAttributes) {
        redirectAttributes.addFlashAttribute("error", "Validation failed: " + ex.getBindingResult().getAllErrors());
        return "redirect:/userForm";
    }

    // Handle general exceptions
    @ExceptionHandler(Exception.class)
    public String handleGeneralException(Exception ex, Model model) {
        model.addAttribute("errorMessage", "An error occurred: " + ex.getMessage());
        return "error"; // Display a generic error page
    }
}

