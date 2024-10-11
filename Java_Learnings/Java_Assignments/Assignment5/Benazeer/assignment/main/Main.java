package Java_Assignments.Assignment5.Benazeer.assignment.main;

import Java_Assignments.Assignment5.Benazeer.assignment.data.DefaultInitializationAssignment;
import Java_Assignments.Assignment5.Benazeer.assignment.singleton.SingletonExample;

public class Main {
    public static void main(String[] args) {
        // Create an instance of DefaultInitializationAssignment
        DefaultInitializationAssignment dataInstance = new DefaultInitializationAssignment();
        
        dataInstance.printVariables();
        
        // Uncommenting the following method call will result in a compile error 
        // because local variables in Java must be initialized before use.
        // dataInstance.printLocalVariables();

        // Create or retrieve the Singleton instance and print the message
        SingletonExample singletonInstance = SingletonExample.createInstance("Hello, Singleton!");
        singletonInstancintMessage();

        // Attempt to create another Singleton instance (but the existing one will be reused)
        SingletonExample anotherInstance = SingletonExample.createInstance("This should not change the message");
        anotherInstance.printMessage(); // Should still print "Hello, Singleton!" since it's the same instance
    }
}
