package org.example;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Bi_OneToManyApp {

    public static void main(String[] args) {

        // Create a SessionFactory using Hibernate Configuration
        SessionFactory sessionFactory = new Configuration()
                .configure("hibernate.cfg.xml") // Make sure this XML file is configured properly
                .addAnnotatedClass(Bi_Instructor.class)
                .addAnnotatedClass(Bi_Course.class)
                .addAnnotatedClass(Bi_InstructorDetail.class)
                .buildSessionFactory();

        // Create session
        Session session = sessionFactory.getCurrentSession();

        try {
            // 1. Create Instructor and InstructorDetail
            Bi_Instructor tempInstructor = new Bi_Instructor("John", "Doe", "john.doe@example.com");
            Bi_InstructorDetail tempInstructorDetail = new Bi_InstructorDetail("https://www.youtube.com/johndoe", "Teaching");

            // Associate the instructor with the instructorDetail
            tempInstructor.setInstructorDetail(tempInstructorDetail);

            // Start a transaction
            session.beginTransaction();

            // 3. Save the instructor and courses
            System.out.println("Saving instructor: " + tempInstructor);
            session.save(tempInstructor);

            // Commit transaction
            session.getTransaction().commit();
            System.out.println("Instructor saved: " + tempInstructor);

            // ---- Fetching Instructor and Courses ----
            session = sessionFactory.getCurrentSession();
            session.beginTransaction();

            // Retrieve the instructor based on the id
            int instructorId = tempInstructor.getId();
            Bi_Instructor retrievedInstructor = session.get(Bi_Instructor.class, instructorId);

            System.out.println("Instructor retrieved: " + retrievedInstructor);


            // Commit the transaction
            session.getTransaction().commit();
        } finally {
            sessionFactory.close();
        }
    }
}
