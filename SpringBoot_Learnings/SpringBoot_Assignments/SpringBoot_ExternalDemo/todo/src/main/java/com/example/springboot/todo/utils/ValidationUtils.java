package com.example.springboot.todo.utils;

import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;

public class ValidationUtils {
    public static String collectValidationErrors(BindingResult bindingResult) {
        StringBuilder errorMessages = new StringBuilder();

        for (FieldError fieldError : bindingResult.getFieldErrors()) {
            errorMessages.append(fieldError.getDefaultMessage()).append("\n");
        }

        return errorMessages.toString().trim();
    }
}
