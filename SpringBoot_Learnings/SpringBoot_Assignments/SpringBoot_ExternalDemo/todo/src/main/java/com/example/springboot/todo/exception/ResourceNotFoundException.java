package com.example.springboot.todo.exception;
public class ResourceNotFoundException extends RuntimeException {

  private static final long serialVersionUID = 1L;

  public ResourceNotFoundException(String msg) {
    super(msg);
  }

  public static class ContentMissingException extends RuntimeException {
    public ContentMissingException(String message) {
      super(message);
    }
  }
}