package org.example.service;

import org.example.dao.CustomerDao;
import org.example.entity.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService {


    @Autowired
    private CustomerDao customerDao;

    @Override
    @Transactional
    public List<Customer> getCustomers() {
        return customerDao.getCustomers();
    }

    @Override
    @Transactional
    public void saveCustomer(Customer customer) {
        customerDao.saveCustomer(customer);
    }

    @Override
    @Transactional
    public Customer getCustomer(int theId) {
        return customerDao.getCustomer(theId);  // Fetch customer by ID
    }

    @Override
    @Transactional
    public void deleteCustomer(int theId) {
        customerDao.deleteCustomer(theId);  // Delete customer by ID
    }
    // Setter for unit testing purposes
    public void setCustomerDao(CustomerDao customerDao) {
        this.customerDao = customerDao;
    }


}
