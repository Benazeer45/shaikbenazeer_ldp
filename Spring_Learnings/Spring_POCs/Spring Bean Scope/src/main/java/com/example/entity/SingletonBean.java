package com.example.entity;

public class SingletonBean {
    public SingletonBean() {
        System.out.println("SingletonBean instance created.");
    }

    public String getMessage() {
        return "I am a Singleton bean.";
    }
}
