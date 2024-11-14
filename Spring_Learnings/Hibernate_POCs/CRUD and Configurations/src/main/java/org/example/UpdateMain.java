package org.example;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class UpdateMain {
    public static void main(String[] args) {
        // Create session factory
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Student.class)
                .buildSessionFactory();

        // Create session
        Session session = factory.getCurrentSession();

        try {
            // Start a new transaction
            session.beginTransaction();

            // Retrieve the student based on the primary key (ID)
            int studentId = 1; // ID of the student to update
            Student myStudent = session.get(Student.class, studentId);

            // Update the student’s details
            if (myStudent != null) {
                myStudent.setName("Shaik Benazeer");  // Modify the name
                myStudent.setAge(25);  // Modify the age
            }

            // Update all email addresses with @example.com to @gmail.com
            session.createQuery("update Student set email = replace(email, '@example.com', '@gmail.com')")
                    .executeUpdate();

            // Commit the transaction
            session.getTransaction().commit();
            System.out.println("Student updated and email addresses modified successfully.");

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            factory.close();
        }
    }
}
