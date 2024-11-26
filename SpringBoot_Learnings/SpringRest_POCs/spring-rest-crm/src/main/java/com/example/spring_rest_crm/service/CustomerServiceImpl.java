package com.example.spring_rest_crm.service;

import com.example.spring_rest_crm.dao.CustomerDAO;
import com.example.spring_rest_crm.entity.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerDAO customerDAO; // This is your JPA repository

    @Override
    public List<Customer> getCustomers() {
        return customerDAO.findAll();  // Using the JPA method findAll()
    }

    @Override
    public void saveCustomer(Customer theCustomer) {
        customerDAO.save(theCustomer);  // Using the JPA save() method
    }

    @Override
    public Customer getCustomer(int theId) {
        return customerDAO.findById(theId);  // Using the JPA findById() method
    }

    @Override
    public void deleteCustomer(int theId) {
        customerDAO.deleteById(theId);  // Using the JPA deleteById() method
    }
}




