//package com.example.springdemo.springcruddemo.dao;
//
//import com.example.springdemo.springcruddemo.entity.Employee;
//import jakarta.persistence.EntityManager;
//import jakarta.persistence.Query;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Repository;
//
//import java.util.List;
//
//@Repository
//public class EmployeeDaoJpaImpl implements EmployeeDao {
//
//    private final EntityManager entityManager;
//
//    @Autowired
//    public EmployeeDaoJpaImpl(EntityManager entityManager) {
//        this.entityManager = entityManager;
//    }
//
//    @Override
//    public List<Employee> findAll() {
//        // Create a query to fetch all employees
//        Query theQuery = entityManager.createQuery("from Employee");
//
//        // Execute the query and get the result list
//        List<Employee> employees = theQuery.getResultList();
//
//        return employees;
//    }
//
//    @Override
//    public Employee findById(int employeeId) {
//        // Use entityManager.find() to get the employee by ID
//        Employee theEmployee = entityManager.find(Employee.class, employeeId);
//
//        // Return the found employee (or null if not found)
//        return theEmployee;
//    }
//
//    @Override
//    public void save(Employee theEmployee) {
//        // If the employee ID is 0, it means we are inserting a new employee
//        if (theEmployee.getId() == 0) {
//            // The merge() method handles both insert and update operations
//            entityManager.merge(theEmployee);
//        } else {
//            // Otherwise, we just update the existing employee
//            entityManager.merge(theEmployee);
//        }
//
//        // Ensure the ID is set (in case of new entity creation)
//        // JPA should automatically set the ID during a merge operation if it's a new record
//        // However, this ensures it is returned correctly if needed
//    }
//
//    @Override
//    public void deleteById(int employeeId) {
//        // Create a query to delete the employee by ID
//        Query theQuery = entityManager.createQuery("delete from Employee where id = :employeeId");
//
//        // Set the employee ID parameter
//        theQuery.setParameter("employeeId", employeeId);
//
//        // Execute the query to delete the employee
//        theQuery.executeUpdate();
//    }
//}
