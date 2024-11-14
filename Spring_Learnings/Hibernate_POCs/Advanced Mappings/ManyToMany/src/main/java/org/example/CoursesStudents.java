package org.example;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class CoursesStudents {
    public static void main(String[] args) {
        // Create SessionFactory using Hibernate Configuration
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml") // This will read hibernate.cfg.xml
                .addAnnotatedClass(Uni_Course.class)
                .addAnnotatedClass(Uni_Student.class)
                .addAnnotatedClass(Uni_Instructor.class)
                .addAnnotatedClass(Uni_Review.class)
                .buildSessionFactory();

        // Create session
        Session session = factory.getCurrentSession();

        try {
            // Create and save a course
            System.out.println("Creating new course...");
            Uni_Course course = new Uni_Course("Java Programming");
            session.beginTransaction(); // Begin transaction

            // Save the course
            session.save(course);
            System.out.println("Course saved: " + course);

            // Create students
            System.out.println("Creating new students...");
            Uni_Student student1 = new Uni_Student("John", "Doe", "john.doe@example.com");
            Uni_Student student2 = new Uni_Student("Jane", "Smith", "jane.smith@example.com");

            // Add students to course
            course.addStudent(student1);
            course.addStudent(student2);

            // Save students (will also update the course-student join table due to the relationship)
            session.save(student1);
            session.save(student2);
            System.out.println("Students saved and enrolled in the course.");

            // Commit transaction
            session.getTransaction().commit();
            System.out.println("Transaction committed.");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            session.close(); // Close session
            factory.close(); // Close SessionFactory
        }
    }
}
