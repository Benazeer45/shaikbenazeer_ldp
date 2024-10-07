package Core_Java.Packages.Student_Main_Package;

import Core_Java.Packages.Student_Package.Student; // Importing the Student class from the Student Package

public class Main {
    public static void main(String[] args) {
        // Creating Student objects
        Student student1 = new Student("Alice", 20, "Computer Science");
        Student student2 = new Student("Bob", 22, "Mathematics");
        Student student3 = new Student("Charlie", 21, "Physics");

        System.out.println("Student Details:");
        student1.displayDetails();
        System.out.println();
        student2.displayDetails();
        System.out.println();
        student3.displayDetails();
    }
}

