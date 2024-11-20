package org.example;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class CreateCourses {

    public static void main(String[] args) {
        // Step 1: Configure Hibernate and build the SessionFactory
        SessionFactory sessionFactory = new Configuration()
                .configure("hibernate.cfg.xml")  // Ensure this file is properly configured
                .addAnnotatedClass(Bi_Instructor.class)
                .addAnnotatedClass(Bi_Course.class)
                .buildSessionFactory();

        // Step 2: Initialize a session and transaction
        Session session = sessionFactory.getCurrentSession();
        Transaction transaction = null;

        try {
            // Step 3: Start a transaction
            transaction = session.beginTransaction();

            // Step 4: Retrieve the instructor from the database using its ID
            int instructorId = 1;  // Change this ID to match an existing instructor in your database
            Bi_Instructor instructor = session.get(Bi_Instructor.class, instructorId);

            if (instructor == null) {
                System.out.println("Instructor not found!");
            } else {
                // Step 5: Create new courses
                Bi_Course course1 = new Bi_Course("Java Programming");
                Bi_Course course2 = new Bi_Course("Data Structures");

                // Step 6: Add courses to the instructor
                instructor.addCourse(course1);
                instructor.addCourse(course2);

                // Step 7: Save the courses (because of cascade settings, this may save the courses automatically)
                session.save(course1);
                session.save(course2);

                // Step 8: Commit the transaction
                transaction.commit();

                System.out.println("Courses successfully added to instructor and saved.");
            }
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
