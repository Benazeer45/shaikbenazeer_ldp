package com.example.springsecurity.model;

import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import lombok.ToString;

@Getter // Generates getters for all fields
@Setter // Generates setters for all fields
@NoArgsConstructor // Generates a no-argument constructor
@AllArgsConstructor // Generates a constructor with all fields
@ToString // Generates a toString method
public class Student {
    private int id;
    private String name;
    private int marks;
}
