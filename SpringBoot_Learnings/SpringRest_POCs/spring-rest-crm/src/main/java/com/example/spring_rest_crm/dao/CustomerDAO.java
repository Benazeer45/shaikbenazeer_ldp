package com.example.spring_rest_crm.dao;


import com.example.spring_rest_crm.entity.Customer;

import java.util.List;


public interface CustomerDAO{
    public List<Customer> findAll();
    public void save(Customer theCustomer);
    public Customer findById(int theId);
    public void deleteById(int theId);
}