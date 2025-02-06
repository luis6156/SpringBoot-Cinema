package com.cinema.app.web.user;

import com.cinema.app.model.user.User;
import com.cinema.app.service.user.UserServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {
    private final UserServiceImpl userService;

    @PostMapping
    public User createUser(@RequestBody User user) {
        return userService.createUser(user);
    }

    @GetMapping("/{userId}")
    public Optional<User> getUserById(@PathVariable Long userId) {
        return userService.getUserById(userId);
    }

    @GetMapping
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }

    @PutMapping("/{userId}")
    public User updateUser(@PathVariable Long userId, @RequestBody User userDetails) {
        return userService.updateUser(userId, userDetails);
    }

    @DeleteMapping("/{userId}")
    public void deleteUser(@PathVariable Long userId) {
        userService.deleteUser(userId);
    }

    @GetMapping("/email/{email}")
    public Optional<User> getUserByEmail(@PathVariable String email) {
        return userService.getUserByEmail(email);
    }

    @PostMapping("/{userId}/make-admin")
    public User makeUserAdmin(@PathVariable Long userId, @RequestParam String adminCode) {
        return userService.makeUserAdmin(userId, adminCode);
    }

    @PostMapping("/{userId}/make-customer")
    public User makeUserCustomer(@PathVariable Long userId, @RequestParam Integer loyaltyPoints) {
        return userService.makeUserCustomer(userId, loyaltyPoints);
    }
}
