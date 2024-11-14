package org.example;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class GetterOption {

    public static void main(String[] args) {
        SessionFactory sessionFactory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Bi_Instructor.class)
                .addAnnotatedClass(Bi_InstructorDetail.class)
                .addAnnotatedClass(Bi_Course.class)
                .buildSessionFactory();

        Session session = null;

        try {
            // Start a session and begin a transaction
            session = sessionFactory.getCurrentSession();
            session.beginTransaction();

            // Retrieve the instructor
            int instructorId = 1;  // Replace with an existing ID
            Bi_Instructor instructor = session.get(Bi_Instructor.class, instructorId);

            // Print the instructor details
            System.out.println("Instructor details: " + instructor);
            System.out.println("Courses: " + instructor.getCourses()); //calling getter method to solve lazy issue


            // Commit the transaction and close the session
            session.getTransaction().commit();
            session.close();

            // Attempt to access lazy-loaded courses after session is closed
            System.out.println("Courses: " + instructor.getCourses());  // Should throw LazyInitializationException

        } catch (Exception e) {
            e.printStackTrace();  // Expected LazyInitializationException here

        } finally {
            if (session != null) {
                session.close();
            }
            sessionFactory.close();
        }
    }
}
