package Core_Java.ObjectOrientedProgramming;

// Base class
class Animal {
    // Public variable accessible from anywhere
    public String species;

    // Protected variable accessible in the same package and subclasses
    protected int age;

    // Private variable accessible only within the Animal class
    private String color;

    // Constructor
    public Animal(String species, int age, String color) {
        this.species = species;
        this.age = age;
        this.color = color; // Only accessible within this class
    }

    // Public method
    public void displayInfo() {
        System.out.println("Species: " + species);
        System.out.println("Age: " + age);
        System.out.println("Color: " + color); // Accessible here
    }
}

// Derived class
class Dog extends Animal {
    // Additional variable for Dog class
    public String breed;

    // Constructor
    public Dog(String species, int age, String color, String breed) {
        super(species, age, color); // Call to base class constructor
        this.breed = breed; // Initialize breed
    }

    // Method to display Dog information
    public void displayDogInfo() {
        // Accessing inherited public and protected variables
        System.out.println("Dog Breed: " + breed);
        System.out.println("Species: " + species); // Accessible (public)
        System.out.println("Age: " + age); // Accessible (protected)
        // System.out.println("Color: " + color); // Not accessible (private)
    }
}

// Main class to run the example
public class Inheritance_AccessModifiers {
    public static void main(String[] args) {
        // Create an Animal object
        Animal animal = new Animal("Lion", 5, "Golden");
        System.out.println("Animal Info:");
        animal.displayInfo();

        System.out.println(); // For spacing

        // Create a Dog object
        Dog dog = new Dog("Canine", 3, "Brown", "Labrador");
        System.out.println("Dog Info:");
        dog.displayDogInfo();

        // Accessing public member directly
        System.out.println("Accessing species directly: " + dog.species);
    }
}
