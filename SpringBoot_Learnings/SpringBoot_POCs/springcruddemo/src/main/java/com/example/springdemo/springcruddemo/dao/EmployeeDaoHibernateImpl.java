//package com.example.springdemo.springcruddemo.dao;
//
//import com.example.springdemo.springcruddemo.entity.Employee;
//import jakarta.persistence.EntityManager;
//import org.hibernate.Session;
//import org.hibernate.query.Query;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Repository;
//import org.springframework.transaction.annotation.Transactional;
//
//import java.util.List;
//
//@Repository
//public class EmployeeDaoHibernateImpl implements EmployeeDao {
//
//    // Define EntityManager (injected via constructor)
//    private final EntityManager entityManager;
//
//    // Constructor injection
//    @Autowired
//    public EmployeeDaoHibernateImpl(EntityManager entityManager) {
//        this.entityManager = entityManager;
//    }
//
//    @Override
//    @Transactional
//    public List<Employee> findAll() {
//        // Get the current Hibernate session
//        Session currentSession = entityManager.unwrap(Session.class);
//
//        // Create a query (HQL - Hibernate Query Language)
//        Query<Employee> query = currentSession.createQuery("from Employee", Employee.class);
//
//        // Execute the query and get the result list
//        return query.getResultList();
//    }
//
//    @Override
//    @Transactional
//    public Employee findById(int employeeId) {
//        // Get the current Hibernate session
//        Session currentSession = entityManager.unwrap(Session.class);
//
//        // Get the employee with the given id using Hibernate's get() method
//        return currentSession.get(Employee.class, employeeId);
//    }
//
//    @Override
//    @Transactional
//    public void save(Employee theEmployee) {
//        // Get the current Hibernate session
//        Session currentSession = entityManager.unwrap(Session.class);
//
//        // If the employee id is 0, save the employee (insert), otherwise update
//        currentSession.saveOrUpdate(theEmployee);
//    }
//
//    @Override
//    @Transactional
//    public void deleteById(int employeeId) {
//        // Get the current Hibernate session
//        Session currentSession = entityManager.unwrap(Session.class);
//
//        // Get the employee object using the employeeId
//        Employee employee = currentSession.get(Employee.class, employeeId);
//
//        // Delete the employee if it exists
//        if (employee != null) {
//            currentSession.delete(employee);
//        }
//    }
//}
