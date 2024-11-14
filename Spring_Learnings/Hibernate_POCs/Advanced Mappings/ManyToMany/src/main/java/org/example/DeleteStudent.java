package org.example;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class DeleteStudent {
    public static void main(String[] args) {
        // Create SessionFactory using Hibernate Configuration
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml") // This will read hibernate.cfg.xml
                .addAnnotatedClass(Uni_Student.class)
                .buildSessionFactory();

        // Create session
        Session session = factory.getCurrentSession();

        try {
            // Start a transaction
            Transaction transaction = session.beginTransaction();

            // Retrieve the student based on their ID (e.g., studentId = 1)
            int studentId = 1; // Change this to the ID of the student you want to delete
            Uni_Student studentToDelete = session.get(Uni_Student.class, studentId);

            // Check if the student exists
            if (studentToDelete != null) {
                // Print student details before deletion
                System.out.println("Deleting student: " + studentToDelete.getFirstName()+studentToDelete.getLastName());

                // Delete the student
                session.delete(studentToDelete);
                System.out.println("Student deleted.");
            } else {
                System.out.println("No student found with ID: " + studentId);
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