package com.cinema.app.service.user;

import com.cinema.app.model.user.Admin;
import com.cinema.app.model.user.Customer;
import com.cinema.app.model.user.User;
import com.cinema.app.repository.user.AdminRepository;
import com.cinema.app.repository.user.CustomerRepository;
import com.cinema.app.repository.user.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final AdminRepository adminRepository;
    private final CustomerRepository customerRepository;

    @Override
    public User createUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public Optional<User> getUserById(Long userId) {
        return userRepository.findById(userId);
    }

    @Override
    public User updateUser(Long userId, User userDetails) {
        Optional<User> userOptional = userRepository.findById(userId);
        if (userOptional.isPresent()) {
            User existingUser = userOptional.get();
            existingUser.setUsername(userDetails.getUsername());
            existingUser.setEmail(userDetails.getEmail());
            existingUser.setPassword(userDetails.getPassword());
            return userRepository.save(existingUser);
        } else {
            throw new RuntimeException("User not found");
        }
    }

    @Override
    public void deleteUser(Long userId) {
        Optional<User> userOptional = userRepository.findById(userId);
        if (userOptional.isPresent()) {
            userRepository.delete(userOptional.get());
        } else {
            throw new RuntimeException("User not found");
        }
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public User makeUserAdmin(Long userId, String adminCode) {
        Optional<User> userOptional = userRepository.findById(userId);
        if (userOptional.isPresent()) {
            User user = userOptional.get();
            Admin admin = new Admin();
            admin.setId(user.getId());
            admin.setUsername(user.getUsername());
            admin.setEmail(user.getEmail());
            admin.setPassword(user.getPassword());
            admin.setAdminCode(adminCode);

            return adminRepository.save(admin);
        } else {
            throw new RuntimeException("User not found");
        }
    }

    @Override
    public User makeUserCustomer(Long userId, Integer loyaltyPoints) {
        Optional<User> userOptional = userRepository.findById(userId);
        if (userOptional.isPresent()) {
            User user = userOptional.get();
            Customer customer = new Customer();
            customer.setId(user.getId());
            customer.setUsername(user.getUsername());
            customer.setEmail(user.getEmail());
            customer.setPassword(user.getPassword());
            customer.setLoyaltyPoints(loyaltyPoints);

            return customerRepository.save(customer);
        } else {
            throw new RuntimeException("User not found");
        }
    }

    @Override
    public Optional<User> getUserByEmail(String email) {
        return Optional.ofNullable(userRepository.findByEmail(email).getFirst());
    }
}
