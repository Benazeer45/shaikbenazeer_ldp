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
@JsonIgnoreProperties(ignoreUnknown = true) // Ignores unknown JSON properties during deserialization
public class StudentPOJO {
    private int id;
    private String firstName;
    private String lastName;
    private boolean active;
    private Address address; 
    private List<String> languages; 
}
