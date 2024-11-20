package org.example;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class CreateMain {
    public static void main(String[] args) {
        // Create a session factory
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml") // Use the hibernate configuration file
                .addAnnotatedClass(Student.class) // Add annotated classes
                .buildSessionFactory();

        // Create a session
        Session session = factory.getCurrentSession();

        try {
            // Create a new Student object
            Student newStudent1 = new Student("BenazeerShaik", 22,"benazeershaik@example.com");

            // Start a transaction
            session.beginTransaction();

            // Save the student object
            System.out.println("Saved the Student Data Successfully");
            session.save(newStudent1);
            System.out.println("Done...!!");

            // Commit the transaction
            session.getTransaction().commit();

            // Retrieve the student based on the ID
            session = factory.getCurrentSession();  // Get a new session for a new transaction
            session.beginTransaction();

            // Retrieve the student using the primary key (ID)
            Student retrievedStudent = session.get(Student.class, newStudent1.getId());
            System.out.println("Retrieved student: " + retrievedStudent);

            // Commit the transaction
            session.getTransaction().commit();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // Clean up and close the factory
            factory.close();
        }
    }
}
