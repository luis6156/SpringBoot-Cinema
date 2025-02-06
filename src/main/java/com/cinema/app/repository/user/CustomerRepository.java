package com.cinema.app.repository.user;

import com.cinema.app.model.user.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {
    List<Customer> findByLoyaltyPointsGreaterThan(Integer loyaltyPointsIsGreaterThan);
}
