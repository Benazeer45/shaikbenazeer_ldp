package Core_Java.ObjectOrientedProgramming;

// Abstract class
abstract class Animal_ {
    // Abstract method (no body)
    public abstract void makeSound();

    // Concrete method
    public void eat() {
        System.out.println("This animal eats food.");
    }
}

// Subclass Dog inherits from Animal
class Dog_ extends Animal_ {
    // Implementing the abstract method
    @Override
    public void makeSound() {
        System.out.println("Bow Bow");
    }
}

// Subclass Cat inherits from Animal
class Cat_ extends Animal_ {
    // Implementing the abstract method
    @Override
    public void makeSound() {
        System.out.println("Meow Meow");
    }
}

// Main class to test the abstract class
public class Abstract_Class {
    public static void main(String[] args) {
        Animal_ dog = new Dog_();
        Animal_ cat = new Cat_();

        System.out.println("Dog:");
        dog.makeSound(); // Calls the Dog's implementation of makeSound
        dog.eat();       // Calls the inherited method from Animal

        System.out.println("\nCat:");
        cat.makeSound(); // Calls the Cat's implementation of makeSound
        cat.eat();       // Calls the inherited method from Animal
    }
}
