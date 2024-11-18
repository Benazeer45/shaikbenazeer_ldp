package org.example.dao;

import org.example.entity.Customer;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CustomerDaoImpl implements CustomerDao {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List<Customer> getCustomers() {
        Session currentSession = sessionFactory.getCurrentSession();
        Query<Customer> customerQuery = currentSession.createQuery("from Customer", Customer.class);
        return customerQuery.getResultList();  // Return list of customers
    }

    @Override
    public void saveCustomer(Customer customer) {
        Session currentSession = sessionFactory.getCurrentSession();
        currentSession.saveOrUpdate(customer);  // Save or update customer
    }

    @Override
    public Customer getCustomer(int customerId) {
        Session currentSession = sessionFactory.getCurrentSession();
        return currentSession.get(Customer.class, customerId);  // Fetch customer by ID
    }

    @Override
    public void deleteCustomer(int customerId) {
        Session currentSession = sessionFactory.getCurrentSession();
        Query<?> deleteCustomerQuery = currentSession.createQuery("delete from Customer where id=:customerId");
        deleteCustomerQuery.setParameter("customerId", customerId);
        deleteCustomerQuery.executeUpdate();  // Delete customer by ID
    }

    // Setter for unit testing purposes
    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
}
