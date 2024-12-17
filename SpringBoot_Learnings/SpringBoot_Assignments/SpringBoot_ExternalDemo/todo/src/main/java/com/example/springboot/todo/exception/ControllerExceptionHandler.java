package com.example.springboot.todo.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

@RestControllerAdvice
public class ControllerExceptionHandler {

  @ExceptionHandler(ResourceNotFoundException.class)
  @ResponseStatus(value = HttpStatus.NOT_FOUND)
  public ErrorMessage resourceNotFoundException(ResourceNotFoundException ex, WebRequest request) {
    ErrorMessage message = new ErrorMessage(
            HttpStatus.NOT_FOUND.value(),
            new Date(),
            ex.getMessage(),
            request.getDescription(false));

    return message;
  }


  @ExceptionHandler(ResourceNotFoundException.ContentMissingException.class)
  @ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
  public ErrorMessage contentMissingException(ResourceNotFoundException.ContentMissingException ex, WebRequest request) {
    ErrorMessage message = new ErrorMessage(
            HttpStatus.INTERNAL_SERVER_ERROR.value(),
            new Date(),
            ex.getMessage(),
            "uri=" + request.getDescription(false));
    return message;
  }

  @ExceptionHandler(MethodArgumentNotValidException.class)
  public ResponseEntity<Map<String, Object>> handleGlobalException(MethodArgumentNotValidException ex, WebRequest request) {
    Map<String, Object> response = new LinkedHashMap<>();

    Map<String, String> errors = new HashMap<>();
    ex.getBindingResult()
            .getAllErrors()
            .forEach(error -> {
              String message = error.getDefaultMessage();
              String field = ((FieldError) error).getField();
              errors.put(field, message);
            });

    response.put("statusCode", HttpStatus.INTERNAL_SERVER_ERROR.value());
    response.put("timestamp", new Date());
    response.put("errors", errors);
    response.put("description", request.getDescription(false));

    return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
  }


  @ExceptionHandler(Exception.class)
  public ResponseEntity<ErrorMessage> handleGlobalException(Exception ex, WebRequest request) {
    ErrorMessage errorMessage = new ErrorMessage(
            HttpStatus.INTERNAL_SERVER_ERROR.value(),
            new Date(),
            ex.getMessage(),
            request.getDescription(false)
    );
    return new ResponseEntity<>(errorMessage, HttpStatus.INTERNAL_SERVER_ERROR);
  }

}