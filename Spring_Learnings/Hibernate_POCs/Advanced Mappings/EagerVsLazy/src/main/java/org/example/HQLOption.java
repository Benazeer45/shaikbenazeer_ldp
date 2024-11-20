package org.example;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HQLOption {

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

            // Using HQL to fetch instructor with courses
            int instructorId = 1;  // Replace with an existing ID
            String hql = "SELECT i FROM Bi_Instructor i " +
                    "JOIN FETCH i.courses " +
                    "WHERE i.id = :instructorId";
            Bi_Instructor instructor = session.createQuery(hql, Bi_Instructor.class)
                    .setParameter("instructorId", instructorId)
                    .getSingleResult();

            // Commit the transaction
            session.getTransaction().commit();
            session.close();

            // Now we can access courses after session is closed
            System.out.println("Instructor details: " + instructor);
            System.out.println("Courses: " + instructor.getCourses());  // No LazyInitializationException

        } catch (Exception e) {
            e.printStackTrace();

        } finally {
            if (session != null) {
                session.close();
            }
            sessionFactory.close();
        }
    }
}
