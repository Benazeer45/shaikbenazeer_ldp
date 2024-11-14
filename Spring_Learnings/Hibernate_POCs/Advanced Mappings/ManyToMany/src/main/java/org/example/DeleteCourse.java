package org.example;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class DeleteCourse {
    public static void main(String[] args) {
        // Create SessionFactory using Hibernate Configuration
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml") // This will read hibernate.cfg.xml
                .addAnnotatedClass(Uni_Course.class)
                .buildSessionFactory();

        // Create session
        Session session = factory.getCurrentSession();

        try {
            // Start a transaction
            Transaction transaction = session.beginTransaction();

            // Retrieve the course based on its ID (e.g., courseId = 1)
            int courseId = 1; // Change this to the ID of the course you want to delete
            Uni_Course courseToDelete = session.get(Uni_Course.class, courseId);

            // Check if the course exists
            if (courseToDelete != null) {
                // Print course details before deletion
                System.out.println("Deleting course: " + courseToDelete.getTitle());

                // Delete the course
                session.delete(courseToDelete);
                System.out.println("Course deleted.");
            } else {
                System.out.println("No course found with ID: " + courseId);
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