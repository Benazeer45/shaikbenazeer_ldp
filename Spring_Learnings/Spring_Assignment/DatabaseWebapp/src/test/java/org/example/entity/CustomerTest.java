package org.example.entity;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class CustomerTest {

    @Test
    public void testCustomerConstructor() {
        Customer customer = new Customer("John", "Doe", "john.doe@example.com");
        assertEquals("John", customer.getFirstName());
        assertEquals("Doe", customer.getLastName());
        assertEquals("john.doe@example.com", customer.getEmail());
    }

    @Test
    public void testSettersAndGetters() {
        Customer customer = new Customer();
        customer.setId(1);
        customer.setFirstName("Jane");
        customer.setLastName("Doe");
        customer.setEmail("jane.doe@example.com");

        assertEquals(1, customer.getId());
        assertEquals("Jane", customer.getFirstName());
        assertEquals("Doe", customer.getLastName());
        assertEquals("jane.doe@example.com", customer.getEmail());
    }

    @Test
    public void testToString() {
        Customer customer = new Customer("John", "Doe", "john.doe@example.com");
        String expectedString = "Customer{id=0, firstName='John', lastName='Doe', email='john.doe@example.com'}";

        // Assuming id is 0 since it's not set yet
        assertEquals(expectedString, customer.toString());
    }

}
