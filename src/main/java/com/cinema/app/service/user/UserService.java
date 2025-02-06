package com.cinema.app.service.user;

import com.cinema.app.model.user.User;

import java.util.List;
import java.util.Optional;

public interface UserService {
    Optional<User> getUserByEmail(String email);

    User createUser(User user);

    Optional<User> getUserById(Long userId);

    User updateUser(Long userId, User userDetails);

    void deleteUser(Long userId);

    List<User> getAllUsers();

    User makeUserAdmin(Long userId, String adminCode);

    User makeUserCustomer(Long userId, Integer loyaltyPoints);
}
