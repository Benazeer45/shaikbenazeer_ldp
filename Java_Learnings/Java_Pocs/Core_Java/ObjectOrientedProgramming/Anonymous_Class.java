package Core_Java.ObjectOrientedProgramming;

public class Anonymous_Class {
    public static void main(String[] args) {
        // Creating an instance of an anonymous class
        MyInterface myInterface = new MyInterface() {
            @Override
            public void display() {
                System.out.println("Hello from the anonymous class!");
            }
        };

        // Calling the method of the anonymous class
        myInterface.display();
    }
}

// Sample interface to demonstrate anonymous class
interface MyInterface {
    void display();
}
