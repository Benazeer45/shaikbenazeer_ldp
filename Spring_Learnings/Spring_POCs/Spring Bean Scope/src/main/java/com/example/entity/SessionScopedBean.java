package com.example.entity;

public class SessionScopedBean {
    public SessionScopedBean() {
        System.out.println("SessionScopedBean instance created.");
    }

    public String getMessage() {
        return "I am a Session scoped bean.";
    }
}
