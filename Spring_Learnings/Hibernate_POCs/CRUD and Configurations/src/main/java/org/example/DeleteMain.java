package org.example;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class DeleteMain {
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

            // 1. Retrieve a student object based on the primary key (ID)
            int studentId = 1; // ID of the student to delete
            Student myStudent = session.get(Student.class, studentId);

            // 2. If the student exists, delete it
            if (myStudent != null) {
                session.delete(myStudent); // Delete the student object
                System.out.println("Deleted student with ID: " + studentId);
            }

            // 3. Delete student by ID using HQL query
            int studentIdToDelete = 2; // Example ID for deletion
            session.createQuery("delete from Student where id = :studentId")
                    .setParameter("studentId", studentIdToDelete)
                    .executeUpdate();
            System.out.println("Deleted student with ID: " + studentIdToDelete);


            // Commit the transaction
            session.getTransaction().commit();
            System.out.println("Student deleted successfully.");

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            factory.close();
        }
    }
}
