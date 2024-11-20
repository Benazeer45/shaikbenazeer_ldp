package org.example;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class StudentsCourses {
    public static void main(String[] args) {
        // Create SessionFactory using Hibernate Configuration
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml") // This will read hibernate.cfg.xml
                .addAnnotatedClass(Uni_Course.class)
                .addAnnotatedClass(Uni_Student.class)
                .addAnnotatedClass(Uni_Instructor.class) // Add other entity classes if needed
                .addAnnotatedClass(Uni_Review.class)
                .buildSessionFactory();

        // Create session
        Session session = factory.getCurrentSession();

        try {
            // Start a transaction
            session.beginTransaction();

            // Retrieve a student based on their id (or any condition you want)
            int studentId = 1; // You can change this based on your database
            Uni_Student student = session.get(Uni_Student.class, studentId);

            // Check if student exists, if not, handle the exception
            if (student == null) {
                System.out.println("No student found with id: " + studentId);
            } else {
                // Print student and their courses
                System.out.println("Retrieved student: " + student);
                System.out.println("Courses enrolled by the student: " + student.getCourses());

                // Create new courses
                System.out.println("Creating new courses...");
                Uni_Course course1 = new Uni_Course("Data Structures");
                Uni_Course course2 = new Uni_Course("Algorithms");

                // Add courses to the student
                course1.addStudent(student);
                course2.addStudent(student);

                // Save the courses (student will be saved automatically due to cascade)
                System.out.println("Saving new courses...");
                session.save(course1);
                session.save(course2);

                // Commit the transaction
                session.getTransaction().commit();
                System.out.println("Transaction committed.");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // Clean up the session and factory resources
            session.close();
            factory.close();
            System.out.println("Session closed and factory shut down.");
        }
    }
}
