package org.example.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "customer")  // The table name in the database
public class Customer {

    @Id  // Specifies the primary key
    @GeneratedValue(strategy = GenerationType.IDENTITY)  // Auto-generate the ID value
    @Column(name = "id", nullable = false)  // Maps the field to the 'id' column in the database
    private int id;

    @Column(name = "first_name", nullable = false, length = 50)  // Maps the 'first_name' field to a column
    private String firstName;

    @Column(name = "last_name", nullable = false, length = 50)  // Maps the 'last_name' field to a column
    private String lastName;

    @Column(name = "email", nullable = false, length = 100, unique = true)  // Ensures email is unique
    private String email;

    // Default constructor for JPA
    public Customer() {}

    // Constructor for convenience when creating a customer
    public Customer(String firstName, String lastName, String email) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
    }


    // Getters and setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
