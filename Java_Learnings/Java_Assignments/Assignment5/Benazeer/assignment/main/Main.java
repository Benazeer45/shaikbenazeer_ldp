package Java_Assignments.Assignment5.Benazeer.assignment.main;


import Java_Assignments.Assignment5.Benazeer.assignment.data.DefaultInitializationAssignment;
import Java_Assignments.Assignment5.Benazeer.assignment.singleton.SingletonExample;

public class Main {
    public static void main(String[] args) {
        DefaultInitializationAssignment dataInstance = new DefaultInitializationAssignment();
        dataInstance.printVariables();
        dataInstance.printLocalVariables();

        SingletonExample singletonInstance = SingletonExample.createInstance("Hello, Singleton!");
        singletonInstance.printMessage();
    }
}
