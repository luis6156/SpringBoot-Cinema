package com.cinema.app;

import com.cinema.app.model.user.Customer;
import com.cinema.app.repository.user.CustomerRepository;
import com.cinema.app.service.user.CustomerServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

public class CustomerServiceImplTest {

    @Mock
    private CustomerRepository customerRepository;

    @InjectMocks
    private CustomerServiceImpl customerService;

    private Customer customer1;
    private Customer customer2;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);

        customer1 = new Customer();
        customer1.setLoyaltyPoints(150);

        customer2 = new Customer();
        customer2.setLoyaltyPoints(50);
    }

    @Test
    public void testGetCustomersWithLoyaltyPointsGreaterThan() {
        int points = 100;
        when(customerRepository.findByLoyaltyPointsGreaterThan(points))
                .thenReturn(List.of(customer1));

        List<Customer> result = customerService.getCustomersWithLoyaltyPointsGreaterThan(points);

        assertEquals(1, result.size());
        assertEquals(customer1, result.getFirst());
        verify(customerRepository, times(1)).findByLoyaltyPointsGreaterThan(points);
    }

    @Test
    public void testGetCustomersWithLoyaltyPointsGreaterThan_NoCustomerFound() {
        int points = 200;
        when(customerRepository.findByLoyaltyPointsGreaterThan(points))
                .thenReturn(List.of());

        List<Customer> result = customerService.getCustomersWithLoyaltyPointsGreaterThan(points);

        assertTrue(result.isEmpty());
        verify(customerRepository, times(1)).findByLoyaltyPointsGreaterThan(points);
    }
}

