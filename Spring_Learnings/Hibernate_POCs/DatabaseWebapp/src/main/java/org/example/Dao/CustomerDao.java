package org.example.Dao;

import org.example.Entity.Customer;

import java.util.List;

public interface CustomerDao {
    List<Customer> getCustomers();

    void saveCustomer(Customer customer);

    Customer getCustomer(int theId);  // Method to get customer by ID

    void deleteCustomer(int theId);  // Method to delete customer
}
