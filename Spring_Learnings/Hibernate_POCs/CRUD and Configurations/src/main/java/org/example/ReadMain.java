package org.example;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import java.util.List;

public class ReadMain {
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
            Student newStudent1 = new Student("Benazeer", 22,"benazeer@example.com");
            Student newStudent2 = new Student("John", 23,"John@example.com");
            Student newStudent3 = new Student("Alex", 24,"alex@example.com");

            // Start a transaction
            session.beginTransaction();

            // Save the student objects
            session.save(newStudent1);
            session.save(newStudent2);
            session.save(newStudent3);
            System.out.println("Students saved successfully!");

            // Commit the transaction
            session.getTransaction().commit();

            // -------------------- HQL Queries --------------------

            // 1. Retrieve all students
            session = factory.getCurrentSession();
            session.beginTransaction();
            Query<Student> query = session.createQuery("FROM Student", Student.class);
            List<Student> students = query.getResultList();
            System.out.println("All Students:");
            for (Student student : students) {
                System.out.println(student);
            }
            session.getTransaction().commit();

            // 2. Retrieve students with a specific condition (e.g., age = 22)
            session = factory.getCurrentSession();
            session.beginTransaction();
            query = session.createQuery("FROM Student WHERE age = :studentAge", Student.class);
            query.setParameter("studentAge", 22);
            students = query.getResultList();
            System.out.println("Students with age 22:");
            for (Student student : students) {
                System.out.println(student);
            }
            session.getTransaction().commit();

            // 3. Retrieve students using 'LIKE' predicate (e.g., names containing 'Alex')
            session = factory.getCurrentSession();
            session.beginTransaction();
            query = session.createQuery("FROM Student WHERE name LIKE :studentName", Student.class);
            query.setParameter("studentName", "%Alex%");
            students = query.getResultList();
            System.out.println("Students with name containing 'Alex':");
            for (Student student : students) {
                System.out.println(student);
            }
            session.getTransaction().commit();

            // 4. Retrieve students with 'AND' predicate (e.g., age = 22 and name = 'Benazeer')
            session = factory.getCurrentSession();
            session.beginTransaction();
            query = session.createQuery("FROM Student WHERE age = :studentAge AND name = :studentName", Student.class);
            query.setParameter("studentAge", 22);
            query.setParameter("studentName", "Benazeer");
            students = query.getResultList();
            System.out.println("Students with age 22 and name 'Benazeer':");
            for (Student student : students) {
                System.out.println(student);
            }
            session.getTransaction().commit();

            // 5. Retrieve students using 'OR' predicate (e.g., age = 22 or name = 'Alex')
            session = factory.getCurrentSession();
            session.beginTransaction();
            query = session.createQuery("FROM Student WHERE age = :studentAge OR name = :studentName", Student.class);
            query.setParameter("studentAge", 22);
            query.setParameter("studentName", "Alex");
            students = query.getResultList();
            System.out.println("Students with age 22 or name 'Alex':");
            for (Student student : students) {
                System.out.println(student);
            }
            session.getTransaction().commit();


        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // Clean up and close the factory
            factory.close();
        }
    }
}
