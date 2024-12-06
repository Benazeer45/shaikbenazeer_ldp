package com.springboot.onetomany_bi.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

import java.time.LocalDateTime;
import java.util.Date;

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

  // Remove this duplicate @ExceptionHandler for Exception
  /* @ExceptionHandler(Exception.class)
  @ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
  public ErrorMessage globalExceptionHandler(Exception ex, WebRequest request) {
    ErrorMessage message = new ErrorMessage(
        HttpStatus.INTERNAL_SERVER_ERROR.value(),
        new Date(),
        ex.getMessage(),
        request.getDescription(false));

    return message;
  } */

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

  // Use one of the two handlers for general exceptions
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
