package com.example.spring_rest_crm.service;

import com.example.spring_rest_crm.dao.CustomerDAO;
import com.example.spring_rest_crm.entity.Customer;
import com.example.spring_rest_crm.rest.CustomerNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerDAO customerDAO;

    @Override
    public List<Customer> getCustomers() {
        return customerDAO.findAll();
    }

    @Override
    public void saveCustomer(Customer theCustomer) {
        customerDAO.save(theCustomer);
    }

    @Override
    public Customer getCustomer(int id) {
        Customer theCustomer = customerDAO.findById(id);
        if (theCustomer == null) {
            throw new CustomerNotFoundException("Customer id not found - " + id);
        }
        return theCustomer;
    }

    @Override
    public void deleteCustomer(int id) {
        Customer tempCustomer = customerDAO.findById(id);
        if (tempCustomer == null) {
            throw new CustomerNotFoundException("Customer id not found - " + id);
        }
        customerDAO.deleteById(id);
    }
}
