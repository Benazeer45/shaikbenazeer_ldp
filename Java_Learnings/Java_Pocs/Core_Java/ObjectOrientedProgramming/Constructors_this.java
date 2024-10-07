package Core_Java.ObjectOrientedProgramming;

public class Constructors_this {
    // Instance variables
    private String name;
    private int age;

    // Constructor with parameters
    public Constructors_this(String name, int age) {
        this.name = name; // Using 'this' to refer to the instance variable
        this.age = age;
        System.out.println("Constructor with parameters called.");
    }

    // Default constructor
    public Constructors_this() {
        this("Unknown"); // Calling the constructor with name only
        System.out.println("Default constructor called.");
    }

    // Constructor that calls the other constructor
    public Constructors_this(String name) {
        this(name, 0); // Calling the constructor with parameters using 'this()'
        System.out.println("Constructor with name only called.");
    }

    public void displayInfo() {
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
    }

    public static void main(String[] args) {
        // Creating objects using different constructors
        Constructors_this obj1 = new Constructors_this("Alice", 25);
        obj1.displayInfo();
        System.out.println();

        Constructors_this obj2 = new Constructors_this("Bob");
        obj2.displayInfo();
        System.out.println();

        Constructors_this obj3 = new Constructors_this();
        obj3.displayInfo();
    }
}
