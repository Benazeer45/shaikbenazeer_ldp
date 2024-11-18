package org.example.service;

import org.example.dao.CustomerDao;
import org.example.entity.Customer;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class CustomerServiceImplTest {

    @InjectMocks
    private CustomerServiceImpl customerService;

    @Mock
    private CustomerDao customerDao;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testGetCustomers() {
        List<Customer> mockCustomers = new ArrayList<>();
        mockCustomers.add(new Customer("John", "Doe", "john.doe@example.com"));

        when(customerDao.getCustomers()).thenReturn(mockCustomers);

        List<Customer> customers = customerService.getCustomers();

        assertEquals(1, customers.size());
        assertEquals("John", customers.get(0).getFirstName());
        verify(customerDao).getCustomers();
    }

    @Test
    public void testSaveCustomer() {
        Customer customer = new Customer("Jane", "Doe", "jane.doe@example.com");

        customerService.saveCustomer(customer);

        verify(customerDao).saveCustomer(customer);
    }

    @Test
    public void testGetCustomer() {
        int customerId = 1;
        Customer mockCustomer = new Customer("Alice", "Smith", "alice.smith@example.com");

        when(customerDao.getCustomer(customerId)).thenReturn(mockCustomer);

        Customer retrievedCustomer = customerService.getCustomer(customerId);

        assertEquals(mockCustomer, retrievedCustomer);
        verify(customerDao).getCustomer(customerId);
    }

    @Test
    public void testDeleteCustomer() {
        int customerId = 2;

        customerService.deleteCustomer(customerId);

        verify(customerDao).deleteCustomer(customerId);
    }
}