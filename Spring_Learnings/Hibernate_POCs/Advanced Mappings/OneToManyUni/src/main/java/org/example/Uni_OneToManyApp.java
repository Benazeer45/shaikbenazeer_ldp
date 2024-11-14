package org.example;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Uni_OneToManyApp {

    public static void main(String[] args) {

        // Create a SessionFactory using Hibernate Configuration
        SessionFactory sessionFactory = new Configuration()
                .configure("hibernate.cfg.xml") // Make sure this XML file is configured properly
                .addAnnotatedClass(Uni_Instructor.class)
                .addAnnotatedClass(Uni_Course.class)
                .addAnnotatedClass(Uni_InstructorDetail.class)
                .buildSessionFactory();

        // Create session
        Session session = sessionFactory.getCurrentSession();

        try {
            // 1. Create Instructor and InstructorDetail
            Uni_Instructor tempInstructor = new Uni_Instructor("John", "Doe", "john.doe@example.com");
            Uni_InstructorDetail tempInstructorDetail = new Uni_InstructorDetail("https://www.youtube.com/johndoe", "Teaching");

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
            Uni_Instructor retrievedInstructor = session.get(Uni_Instructor.class, instructorId);

            System.out.println("Instructor retrieved: " + retrievedInstructor);


            // Commit the transaction
            session.getTransaction().commit();
        } finally {
            sessionFactory.close();
        }
    }
}
