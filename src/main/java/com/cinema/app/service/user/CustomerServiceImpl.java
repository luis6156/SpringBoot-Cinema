package com.cinema.app.service.user;

import com.cinema.app.model.user.Customer;
import com.cinema.app.repository.user.CustomerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CustomerServiceImpl implements CustomerService {
    private final CustomerRepository customerRepository;

    @Override
    public List<Customer> getCustomersWithLoyaltyPointsGreaterThan(Integer points) {
        return customerRepository.findByLoyaltyPointsGreaterThan(points);
    }
}
