package org.example;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class RetrieveAllInstructorsAndCourses {

    public static void main(String[] args) {
        SessionFactory sessionFactory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Uni_Instructor.class)
                .addAnnotatedClass(Uni_Course.class)
                .buildSessionFactory();

        Session session = sessionFactory.getCurrentSession();
        Transaction transaction = null;

        try {
            session.beginTransaction();
            int theId=1;
            Uni_Instructor tempInstructor=session.get(Uni_Instructor.class,theId);
            System.out.println("Instructor: "+tempInstructor);
            System.out.println("Courses: "+tempInstructor.getCourses());
            session.getTransaction().commit();
            System.out.println("Done..!");


        } catch (Exception e) {
            if (transaction != null) transaction.rollback();
            e.printStackTrace();
        } finally {
            session.close();
            sessionFactory.close();
        }
    }
}
