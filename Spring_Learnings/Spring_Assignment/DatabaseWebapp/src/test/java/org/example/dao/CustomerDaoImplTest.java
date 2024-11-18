package org.example.dao;

import org.example.entity.Customer;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class CustomerDaoImplTest {

    @InjectMocks
    private CustomerDaoImpl customerDao;

    @Mock
    private SessionFactory sessionFactory;

    @Mock
    private Session currentSession;

    @Mock
    private Query<Customer> query;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        when(sessionFactory.getCurrentSession()).thenReturn(currentSession);
    }

    @Test
    public void testGetCustomers() {
        List<Customer> mockCustomers = new ArrayList<>();
        mockCustomers.add(new Customer("John", "Doe", "john.doe@example.com"));
        when(currentSession.createQuery("from Customer", Customer.class)).thenReturn(query);
        when(query.getResultList()).thenReturn(mockCustomers);

        List<Customer> customers = customerDao.getCustomers();

        assertEquals(1, customers.size());
        assertEquals("John", customers.get(0).getFirstName());
        verify(currentSession).createQuery("from Customer", Customer.class);
        verify(query).getResultList();
    }

    @Test
    public void testSaveCustomer() {
        Customer customer = new Customer("Jane", "Doe", "jane.doe@example.com");

        customerDao.saveCustomer(customer);

        verify(currentSession).saveOrUpdate(customer);
    }

    @Test
    public void testGetCustomer() {
        int customerId = 1;
        Customer mockCustomer = new Customer("Alice", "Smith", "alice.smith@example.com");
        when(currentSession.get(Customer.class, customerId)).thenReturn(mockCustomer);

        Customer retrievedCustomer = customerDao.getCustomer(customerId);

        assertEquals(mockCustomer, retrievedCustomer);
        verify(currentSession).get(Customer.class, customerId);
    }

    @Test
    public void testDeleteCustomer() {
        int customerId = 2;

        // Mocking the query creation and behavior
        when(currentSession.createQuery("delete from Customer where id=:customerId")).thenReturn(query);

        // Call the method under test
        customerDao.deleteCustomer(customerId);

        // Verify that the query was created and executed correctly
        verify(currentSession).createQuery("delete from Customer where id=:customerId");
        verify(query).setParameter("customerId", customerId);
        verify(query).executeUpdate();
    }
}