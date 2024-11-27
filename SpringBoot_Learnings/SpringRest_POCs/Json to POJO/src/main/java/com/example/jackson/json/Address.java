package com.example.jackson.json;

import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import lombok.ToString;
import lombok.EqualsAndHashCode;

@Getter // Generates getters for all fields
@Setter // Generates setters for all fields
@NoArgsConstructor // No-args constructor
@AllArgsConstructor // All-args constructor
public class Address {
    private String street;
    private String city;
    private String state;
    private String zip;
}
