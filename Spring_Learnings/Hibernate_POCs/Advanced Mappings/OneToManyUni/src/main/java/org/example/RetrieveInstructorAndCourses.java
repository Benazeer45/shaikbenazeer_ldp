package org.example;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class RetrieveInstructorAndCourses {

    public static void main(String[] args) {
        // Step 1: Configure Hibernate and build the SessionFactory
        SessionFactory sessionFactory = new Configuration()
                .configure("hibernate.cfg.xml")  // Ensure this file is correctly configured
                .addAnnotatedClass(Uni_Instructor.class)
                .addAnnotatedClass(Uni_Course.class)
                .buildSessionFactory();

        // Step 2: Initialize a session and transaction
        Session session = sessionFactory.getCurrentSession();
        Transaction transaction = null;

        try {
            // Step 3: Start a transaction
            transaction = session.beginTransaction();

            // Step 4: Retrieve the instructor by ID
            int instructorId = 1;  // Set this to the ID of an existing instructor in your database
            Uni_Instructor instructor = session.get(Uni_Instructor.class, instructorId);

            if (instructor == null) {
                System.out.println("Instructor not found!");
            } else {
                // Step 5: Display the instructor's details
                System.out.println("Instructor Details:");
                System.out.println("ID: " + instructor.getId());
                System.out.println("Frist Name: " + instructor.getFirstName()); // Ensure `getName` method exists in Bi_Instructor
                System.out.println("Last Name: " + instructor.getLastName()); // Ensure `getName` method exists in Bi_Instructor

                // Step 6: Retrieve and display the associated courses
                System.out.println("Courses taught by " + instructor.getFirstName() + ":");
                for (Uni_Course course : instructor.getCourses()) {  // Ensure `getCourses` method returns a list of Bi_Course
                    System.out.println("Course ID: " + course.getId() + ", Title: " + course.getTitle());
                }
            }

            // Step 7: Commit the transaction
            transaction.commit();

        } catch (Exception e) {
            if (transaction != null) transaction.rollback();
            e.printStackTrace();
        } finally {
            // Step 8: Clean up the session and close the factory
            session.close();
            sessionFactory.close();
        }
    }
}
