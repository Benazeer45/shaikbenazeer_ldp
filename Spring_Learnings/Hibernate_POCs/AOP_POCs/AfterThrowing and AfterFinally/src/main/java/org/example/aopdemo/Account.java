package org.example.aopdemo;

public class Account {
    private String name;
    private String level;

    // Default constructor
    public Account() {
    }

    // Parameterized constructor
    public Account(String name, String level) {
        this.name = name;
        this.level = level;
    }

    // Getter for name
    public String getName() {
        return name;
    }

    // Setter for name
    public void setName(String name) {
        this.name = name;
    }

    // Getter for level
    public String getLevel() {
        return level;
    }

    // Setter for level
    public void setLevel(String level) {
        this.level = level;
    }

    // Overridden toString method
    @Override
    public String toString() {
        return "Account{name='" + name + "', level='" + level + "'}";
    }
}
