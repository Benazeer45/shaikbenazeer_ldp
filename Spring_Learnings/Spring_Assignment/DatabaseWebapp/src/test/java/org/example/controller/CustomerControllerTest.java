package org.example.controller;

import org.example.entity.Customer;
import org.example.service.CustomerService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.ui.Model;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertNull;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class CustomerControllerTest {

    @InjectMocks
    private CustomerController customerController;

    @Mock
    private CustomerService customerService;

    @Mock
    private Model model;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testListCustomers() {
        List<Customer> customers = new ArrayList<>();
        customers.add(new Customer("John", "Doe", "john.doe@example.com"));

        when(customerService.getCustomers()).thenReturn(customers);

        String viewName = customerController.listCustomers(model);

        assertEquals("ListCustomers", viewName);
        verify(model).addAttribute("customers", customers);
    }

    @Test
    public void testSaveCustomer() {
        Customer customer = new Customer("John", "Doe", "john.doe@example.com");
        String viewName = customerController.saveCustomer(customer);
        assertEquals("redirect:/customer/list", viewName);
        verify(customerService).saveCustomer(customer);
    }

    @Test
    public void testShowFormForAdd() {
        String viewName = customerController.showFormForAdd(model);
        assertEquals("CustomerForm", viewName); // Verify the view name
        ArgumentCaptor<Customer> customerCaptor = ArgumentCaptor.forClass(Customer.class);
        verify(model).addAttribute(eq("customer"), customerCaptor.capture()); // Verify the model attribute

        Customer capturedCustomer = customerCaptor.getValue();
        assertEquals(0, capturedCustomer.getId());
        assertNull(capturedCustomer.getFirstName());
        assertNull(capturedCustomer.getLastName());
        assertNull(capturedCustomer.getEmail());
    }


    @Test
    public void testShowFormForUpdate() {
        int customerId = 1;
        Customer mockCustomer = new Customer("Alice", "Smith", "alice.smith@example.com");
        when(customerService.getCustomer(customerId)).thenReturn(mockCustomer);

        String viewName = customerController.showFormForUpdate(customerId, model);

        assertEquals("CustomerForm", viewName); // Verify the returned view name
        verify(customerService).getCustomer(customerId); // Verify the service was called
        verify(model).addAttribute("customer", mockCustomer); // Verify the model attribute
    }

    @Test
    public void testDeleteCustomer() {
        int customerId = 2;
        String viewName = customerController.deleteCustomer(customerId);
        assertEquals("redirect:/customer/list", viewName); // Verify the redirect
        verify(customerService).deleteCustomer(customerId); // Verify the service was called
    }

}