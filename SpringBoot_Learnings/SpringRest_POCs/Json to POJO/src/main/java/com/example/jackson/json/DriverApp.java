package com.example.jackson.json;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.util.List;

public class DriverApp {
    public static void main(String[] args) {
        try {
            // Path to JSON file
            File jsonFile = new File("data/student.json");

            // Create ObjectMapper instance
            ObjectMapper objectMapper = new ObjectMapper();

            // Deserialize JSON file to Java object
            StudentPOJO student = objectMapper.readValue(jsonFile, StudentPOJO.class);

            // Print the basic fields
            System.out.println("ID: " + student.getId());
            System.out.println("First Name: " + student.getFirstName());
            System.out.println("Last Name: " + student.getLastName());
            System.out.println("Active: " + student.isActive());

            // Print Address fields
            Address address = student.getAddress();
            System.out.println("Address:");
            System.out.println("  Street: " + address.getStreet());
            System.out.println("  City: " + address.getCity());
            System.out.println("  State: " + address.getState());
            System.out.println("  Zip: " + address.getZip());

            // Print Languages array
            List<String> languages = student.getLanguages();
            System.out.println("Languages: " + String.join(", ", languages));

        } catch (Exception e) {
            // Handle exceptions
            System.err.println("Error processing JSON: " + e.getMessage());
        }
    }
}
