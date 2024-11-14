package org.example;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Uni_OnetoOne {

    public static void main(String[] args) {

        // Create session factory
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml") // load the configuration file
                .addAnnotatedClass(Uni_Instructor.class)
                .addAnnotatedClass(Uni_InstructorDetail.class)
                .buildSessionFactory();

        // Create session
        Session session = factory.getCurrentSession();

        try {
            // Create the Instructor and InstructorDetail objects
            Uni_Instructor tempInstructor = new Uni_Instructor("John", "Doe", "john.doe@example.com");
            Uni_InstructorDetail tempInstructorDetail = new Uni_InstructorDetail("http://www.youtube.com/johndoe", "Guitar");

            // Associate the objects
            tempInstructor.setInstructorDetail(tempInstructorDetail);

            // Begin a transaction
            session.beginTransaction();

            // Save the instructor (also saves the InstructorDetail because of CascadeType.ALL)
            System.out.println("Saving the instructor and instructor detail...");
            session.save(tempInstructor);

            // Commit the transaction
            session.getTransaction().commit();
            System.out.println("Transaction committed!");


//            int instructorId = 1; // The ID of the instructor to delete
//
//            // Begin a transaction
//            session.beginTransaction();
//
//            // Retrieve the instructor by ID
//            Uni_Instructor tempInstructor = session.get(Uni_Instructor.class, instructorId);
//
//            if (tempInstructor != null) {
//                System.out.println("Deleting instructor: " + tempInstructor);
//
//                // Delete the instructor (also deletes InstructorDetail due to CascadeType.ALL)
//                session.delete(tempInstructor);
//            } else {
//                System.out.println("Instructor not found with ID: " + instructorId);
//            }
//
//            // Commit the transaction
//            session.getTransaction().commit();
//            System.out.println("Deletion committed!");

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // Close the session and factory
            session.close();
            factory.close();
        }
    }
}
