//package com.example.entity;
//
//import jakarta.annotation.PostConstruct;
//import jakarta.annotation.PreDestroy;
//import org.springframework.stereotype.Component;
//
//@Component
//public class Book {
//    private String title;
//    private String author;
//
//    public Book() {
//        System.out.println("Book bean is being created!");
//        this.title = "Default Title";
//        this.author = "Default Author";
//    }
//
//    @PostConstruct
//    public void init() {
//        System.out.println("Initializing Book bean: " + title + " by " + author);
//    }
//
//    public void setTitle(String title) {
//        this.title = title;
//    }
//
//    public void setAuthor(String author) {
//        this.author = author;
//    }
//
//    public String getTitle() {
//        return title;
//    }
//
//    public String getAuthor() {
//        return author;
//    }
//
//    public void displayInfo() {
//        System.out.println("Book Title: " + title + ", Author: " + author);
//    }
//
//    @PreDestroy
//    public void cleanup() {
//        System.out.println("Destroying Book bean: " + title);
//    }
//}
