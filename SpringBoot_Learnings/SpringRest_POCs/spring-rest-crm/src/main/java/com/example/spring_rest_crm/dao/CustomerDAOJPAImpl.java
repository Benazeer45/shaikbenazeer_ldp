package com.example.spring_rest_crm.dao;


import com.example.spring_rest_crm.entity.Customer;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public class CustomerDAOJPAImpl implements CustomerDAO
{
    @Autowired
    private EntityManager entityManager;

    @Override
    @Transactional
    public List<Customer> findAll() {
        Query query=entityManager.createQuery("from Customer order by lastName");
        List<Customer> customers=query.getResultList();
        return customers;
    }

    @Override
    @Transactional
    public void save(Customer theCustomer) {
        entityManager.merge(theCustomer);
    }

    @Override
    @Transactional
    public Customer findById(int theId) {
        Customer customer=entityManager.find(Customer.class, theId);
        return customer;
    }

    @Override
    @Transactional
    public void deleteById(int theId) {
        Customer customer=entityManager.find(Customer.class, theId);
        entityManager.remove(customer);
    }
}