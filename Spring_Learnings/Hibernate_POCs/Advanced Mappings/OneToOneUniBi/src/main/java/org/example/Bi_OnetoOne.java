package org.example;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Bi_OnetoOne {

    public static void main(String[] args) {
        // Create session factory
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Bi_Instructor.class)
                .addAnnotatedClass(Bi_InstructorDetail.class)
                .buildSessionFactory();

        // Create session
        Session session = factory.getCurrentSession();

        try {
            // Create Instructor and InstructorDetail objects
            Bi_Instructor instructor1 = new Bi_Instructor("John", "Doe", "john.doe@example.com");
            Bi_InstructorDetail detail1 = new Bi_InstructorDetail("http://www.youtube.com/johndoe", "Guitar");
            instructor1.setInstructorDetail(detail1);
            detail1.setInstructor(instructor1);

            // Create another Instructor and InstructorDetail
            Bi_Instructor instructor2 = new Bi_Instructor("Jane", "Smith", "jane.smith@example.com");
            Bi_InstructorDetail detail2 = new Bi_InstructorDetail("http://www.youtube.com/janesmith", "Photography");
            instructor2.setInstructorDetail(detail2);
            detail2.setInstructor(instructor2);

            // Create another Instructor and InstructorDetail
            Bi_Instructor instructor3 = new Bi_Instructor("Mike", "Johnson", "mike.johnson@example.com");
            Bi_InstructorDetail detail3 = new Bi_InstructorDetail("http://www.youtube.com/mikejohnson", "Cycling");
            instructor3.setInstructorDetail(detail3);
            detail3.setInstructor(instructor3);

            // Begin transaction
            session.beginTransaction();

            // Save instructors (InstructorDetails will also be saved due to CascadeType.ALL)
            System.out.println("Saving instructors and their details...");
            session.save(instructor1);
            session.save(instructor2);
            session.save(instructor3);

            // Commit transaction
            session.getTransaction().commit();
            System.out.println("Instructors and InstructorDetails saved successfully!");

            // Get a new session and begin a new transaction for delete operation
            session = factory.getCurrentSession();
            session.beginTransaction();

            // Retrieve an instructor by primary key
            int instructorId = instructor2.getId(); // Assuming instructor2 is the one to delete
            Bi_Instructor instructorToDelete = session.get(Bi_Instructor.class, instructorId);

            // Print the instructor before deleting
            System.out.println("Instructor to delete: " + instructorToDelete);

            // Delete the instructor (InstructorDetail will be deleted due to CascadeType.ALL)
            System.out.println("Deleting instructor: " + instructorToDelete);
            session.delete(instructorToDelete);

            // Commit transaction to finalize delete
            session.getTransaction().commit();
            System.out.println("Instructor and InstructorDetail deleted successfully!");

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // Close session and factory
            session.close();
            factory.close();
        }
    }
}
