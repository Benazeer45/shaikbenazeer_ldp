package org.example;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import java.util.List;

public class RetrievingDetails{
    public static void main(String[] args) {
        // Create SessionFactory using Hibernate Configuration
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml") // This will read hibernate.cfg.xml
                .addAnnotatedClass(Uni_Course.class)
                .addAnnotatedClass(Uni_Student.class)
                .buildSessionFactory();

        // Create session
        Session session = factory.getCurrentSession();

        try {
            // Start a transaction
            Transaction transaction = session.beginTransaction();

            // Retrieve all courses
            List<Uni_Course> courses = session.createQuery("from Uni_Course", Uni_Course.class).getResultList();
            System.out.println("All Courses and their Students:");
            for (Uni_Course course : courses) {
                System.out.println("Course: " + course.getTitle()+ ", Students: " + course.getStudents());
            }

            // Retrieve all students
            List<Uni_Student> students = session.createQuery("from Uni_Student", Uni_Student.class).getResultList();
            System.out.println("\nAll Students and their Courses:");
            for (Uni_Student student : students) {
                System.out.println("Student: " + student.getFirstName() + ", Courses: " + student.getCourses());
            }

            // Commit the transaction
            transaction.commit();
            System.out.println("Transaction committed.");
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