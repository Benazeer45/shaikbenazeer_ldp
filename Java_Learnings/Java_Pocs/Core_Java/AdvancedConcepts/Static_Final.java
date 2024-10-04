package Core_Java.AdvancedConcepts;

public class Static_Final {
    // Student class containing constants, instance variables, and methods
    static class Student {
        // Constants
        public static final int MY_CONSTANT = 8; // A constant value

        // Instance variables
        public String name;
        public static String studentClass;
        public static int count = 0;

        // Constructor
        public Student() {
            count++; // Increment the count when a new student is created
        }

        public void studentName() {
            System.out.println(name + " is enrolled in: " + studentClass);
        }

        // Static method to display the class info
        public static void classInfo() {
            System.out.println("Class Info: " + studentClass);
        }

    }

    public static void main(String[] args) {
        // Set the static class variable
        Student.studentClass = "Web Development Fundamentals";

        System.out.println("Student class: " + Student.studentClass);
        Student.classInfo();

        System.out.println("Before creating objects: Student.count = " + Student.count);

        Student student1 = new Student();
        Student student2 = new Student();

        System.out.println("After creating objects: Student.count = " + Student.count);

        student1.name = "Steven";
        student2.name = "Daniel";

        student1.studentName();
        student2.studentName();
    }
}
