package com.cinema.app.service.user;

import com.cinema.app.model.user.Customer;

import java.util.List;

public interface CustomerService {
    List<Customer> getCustomersWithLoyaltyPointsGreaterThan(Integer points);
}
