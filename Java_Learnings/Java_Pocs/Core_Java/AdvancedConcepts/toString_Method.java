package Core_Java.AdvancedConcepts;

public class toString_Method {

    private String name;
    private int age;

    // Constructor to initialize the object
    public toString_Method(String name, int age) {
        this.name = name;
        this.age = age;
    }

    // Overriding the toString() method
    @Override
    public String toString() {
        return "Name: " + name + ", Age: " + age;
    }

    public static void main(String[] args) {
        // Creating an object of toString_Method
        toString_Method person = new toString_Method("Alice", 30);

        // Using the toString() method
        System.out.println(person); // This implicitly calls the toString() method
    }
}
