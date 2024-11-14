package org.example;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import java.util.List;

public class RetrieveReviews {

    public static void main(String[] args) {
        // Step 1: Configure Hibernate and build the SessionFactory
        SessionFactory sessionFactory = new Configuration()
                .configure("hibernate.cfg.xml")  // Ensure this file is properly configured
                .addAnnotatedClass(Uni_Instructor.class)
                .addAnnotatedClass(Uni_Course.class)
                .addAnnotatedClass(Uni_Review.class)  // Ensure the Review class is included
                .buildSessionFactory();

        // Step 2: Initialize session and transaction
        Session session = sessionFactory.getCurrentSession();
        Transaction transaction = null;

        try {
            // Step 3: Start a transaction
            transaction = session.beginTransaction();

            // Step 4: Retrieve all courses with their reviews
            List<Uni_Course> courses = session.createQuery("from Uni_Course", Uni_Course.class).getResultList();

            // Step 5: Print out the courses and associated reviews
            for (Uni_Course course : courses) {
                System.out.println("Course: " + course.getTitle());

                // Lazy loading: reviews will be fetched only when accessed (due to fetch = FetchType.LAZY)
                if (course.getReviews() != null) {
                    for (Uni_Review uniReview : course.getReviews()) {
                        System.out.println("\tReview: " + uniReview.getComment());
                    }
                } else {
                    System.out.println("\tNo reviews found for this course.");
                }
                System.out.println();
            }

            // Step 6: Commit the transaction (not really needed for retrieval)
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
