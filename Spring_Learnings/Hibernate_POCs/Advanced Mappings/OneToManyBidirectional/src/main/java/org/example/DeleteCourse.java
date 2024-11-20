package org.example;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.example.Bi_Course;

public class DeleteCourse {

    public static void main(String[] args) {
        // Step 1: Configure Hibernate and build the SessionFactory
        SessionFactory sessionFactory = new Configuration()
                .configure("hibernate.cfg.xml")  // Ensure this file is correctly configured
                .addAnnotatedClass(Bi_Course.class)
                .buildSessionFactory();

        // Step 2: Initialize session and transaction
        Session session = sessionFactory.getCurrentSession();
        Transaction transaction = null;

        try {
            // Step 3: Start a transaction
            transaction = session.beginTransaction();

            // Step 4: Retrieve the course by its ID
            int courseId = 2;  // Set this to the ID of the course you want to delete
            Bi_Course course = session.get(Bi_Course.class, courseId);

            if (course == null) {
                System.out.println("Course not found!");
            } else {
                // Step 5: Delete the course
                session.delete(course); // This will delete the course from the database
                System.out.println("Course deleted successfully!");
            }

            // Step 6: Commit the transaction
            transaction.commit();

        } catch (Exception e) {
            if (transaction != null) transaction.rollback();
            e.printStackTrace();
        } finally {
            // Step 7: Clean up the session and close the factory
            session.close();
            sessionFactory.close();
        }
    }
}
