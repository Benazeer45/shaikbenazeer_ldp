package com.example.jackson.json;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import lombok.ToString;
import lombok.EqualsAndHashCode;

import java.util.List;

@Getter // Generates getters for all fields
@Setter // Generates setters for all fields
@NoArgsConstructor // No-args constructor
@AllArgsConstructor // All-args constructor
public class Student {
    private int id;
    private String firstName;
    private String lastName;

}
