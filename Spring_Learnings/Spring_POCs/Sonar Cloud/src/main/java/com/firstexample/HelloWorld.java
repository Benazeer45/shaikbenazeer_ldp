package com.firstexample;

public class HelloWorld {
    public static void main(String[] args) {
        printGreeting();
    }

    public static void printGreeting() {
        System.out.println(getGreeting());
    }

    public static String getGreeting() {
        return "Hello, World!";
    }
}