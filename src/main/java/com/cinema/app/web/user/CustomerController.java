package com.cinema.app.web.user;

import com.cinema.app.model.user.Customer;
import com.cinema.app.service.user.CustomerServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/customers")
@RequiredArgsConstructor
public class CustomerController {
    private final CustomerServiceImpl customerService;

    @GetMapping("/loyalty/{points}")
    public List<Customer> getCustomersWithLoyaltyPointsGreaterThan(@PathVariable Integer points) {
        return customerService.getCustomersWithLoyaltyPointsGreaterThan(points);
    }
}
