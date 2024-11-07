package com.example.entity;

public class RequestScopedBean {
    public RequestScopedBean() {
        System.out.println("RequestScopedBean instance created.");
    }

    public String getMessage() {
        return "I am a Request scoped bean.";
    }
}
