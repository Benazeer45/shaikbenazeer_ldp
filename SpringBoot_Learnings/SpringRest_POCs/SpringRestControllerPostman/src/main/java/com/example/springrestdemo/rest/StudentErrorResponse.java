package com.example.springrestdemo.rest;

public class StudentErrorResponse {

    private int status;
    private String message;
    private Long timeStamp;

    // No-argument constructor
    public StudentErrorResponse() {
    }

    // Parameterized constructor
    public StudentErrorResponse(int status, String message, Long timeStamp) {
        this.status = status;
        this.message = message;
        this.timeStamp = timeStamp;
    }

    // Getters and Setters
    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Long getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(Long timeStamp) {
        this.timeStamp = timeStamp;
    }
}
