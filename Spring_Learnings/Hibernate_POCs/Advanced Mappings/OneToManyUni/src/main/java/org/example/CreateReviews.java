package org.example;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class CreateReviews {

    public static void main(String[] args) {
        // Step 1: Configure Hibernate and build the SessionFactory
        SessionFactory sessionFactory = new Configuration()
                .configure("hibernate.cfg.xml")  // Ensure this file is properly configured
                .addAnnotatedClass(Uni_Instructor.class)
                .addAnnotatedClass(Uni_Course.class)
                .addAnnotatedClass(Uni_Review.class)  // Add Review class to configuration
                .buildSessionFactory();

        // Step 2: Initialize a session and transaction
        Session session = sessionFactory.getCurrentSession();
        Transaction transaction = null;

        try {
            // Step 3: Start a transaction
            transaction = session.beginTransaction();

            // Step 4: Create a new Course
            Uni_Course course = new Uni_Course("Java Programming");

            // Step 5: Create and add Reviews to the course
            course.addReview(new Uni_Review("Excellent course!"));
            course.addReview(new Uni_Review("Very well explained!"));
            course.addReview(new Uni_Review("Great instructor and content"));

            // Step 6: Save the course (this will also save the reviews because of CascadeType.ALL)
            session.save(course);

            // Step 7: Commit the transaction
            transaction.commit();

            System.out.println("Course and associated reviews saved successfully!");

        } catch (Exception e) {
            if (transaction != null) transaction.rollback();
            e.printStackTrace();
        } finally {
            // Step 9: Clean up the session and close the factory
            session.close();
            sessionFactory.close();
        }
    }
}
