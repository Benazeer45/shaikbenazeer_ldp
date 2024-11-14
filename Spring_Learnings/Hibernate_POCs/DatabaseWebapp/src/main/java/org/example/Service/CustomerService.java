package org.example.Service;

import org.example.Entity.Customer;

import java.util.List;

public interface CustomerService {
    List<Customer> getCustomers();

    void saveCustomer(Customer customer);

    Customer getCustomer(int theId);  // New method to get customer by ID

    void deleteCustomer(int theId);  // New method to delete customer
}
