package com.cinema.app;

import com.cinema.app.model.user.Admin;
import com.cinema.app.model.user.Customer;
import com.cinema.app.model.user.User;
import com.cinema.app.repository.user.AdminRepository;
import com.cinema.app.repository.user.CustomerRepository;
import com.cinema.app.repository.user.UserRepository;
import com.cinema.app.service.user.UserServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import java.util.Optional;

public class UserServiceImplTest {

    @Mock
    private UserRepository userRepository;

    @Mock
    private AdminRepository adminRepository;

    @Mock
    private CustomerRepository customerRepository;

    @InjectMocks
    private UserServiceImpl userService;

    private User user;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        user = new Admin();
        user.setId(1L);
        user.setUsername("testuser");
        user.setEmail("test@example.com");
        user.setPassword("password123");
    }

    @Test
    public void testCreateUser() {
        when(userRepository.save(any(User.class))).thenReturn(user);

        User createdUser = userService.createUser(user);

        assertNotNull(createdUser);
        assertEquals(user.getId(), createdUser.getId());
        assertEquals(user.getUsername(), createdUser.getUsername());
    }

    @Test
    public void testGetUserById() {
        when(userRepository.findById(1L)).thenReturn(Optional.of(user));

        Optional<User> foundUser = userService.getUserById(1L);

        assertTrue(foundUser.isPresent());
        assertEquals(user.getId(), foundUser.get().getId());
    }

    @Test
    public void testUpdateUser() {
        User updatedUserDetails = new Admin();
        updatedUserDetails.setUsername("newusername");
        updatedUserDetails.setEmail("newemail@example.com");
        updatedUserDetails.setPassword("newpassword123");

        when(userRepository.findById(1L)).thenReturn(Optional.of(user));
        when(userRepository.save(any(User.class))).thenReturn(updatedUserDetails);

        User updatedUser = userService.updateUser(1L, updatedUserDetails);

        assertEquals(updatedUserDetails.getUsername(), updatedUser.getUsername());
        assertEquals(updatedUserDetails.getEmail(), updatedUser.getEmail());
    }

    @Test
    public void testDeleteUser() {
        when(userRepository.findById(1L)).thenReturn(Optional.of(user));

        userService.deleteUser(1L);

        verify(userRepository, times(1)).delete(user);
    }

    @Test
    public void testMakeUserAdmin() {
        Admin admin = new Admin();
        admin.setId(user.getId());
        admin.setUsername(user.getUsername());
        admin.setEmail(user.getEmail());
        admin.setPassword(user.getPassword());
        admin.setAdminCode("adminCode123");

        when(userRepository.findById(1L)).thenReturn(Optional.of(user));
        when(adminRepository.save(any(Admin.class))).thenReturn(admin);

        User result = userService.makeUserAdmin(1L, "adminCode123");

        assertTrue(result instanceof Admin);
        assertEquals(admin.getAdminCode(), ((Admin) result).getAdminCode());
    }

    @Test
    public void testMakeUserCustomer() {
        Customer customer = new Customer();
        customer.setId(user.getId());
        customer.setUsername(user.getUsername());
        customer.setEmail(user.getEmail());
        customer.setPassword(user.getPassword());
        customer.setLoyaltyPoints(100);

        when(userRepository.findById(1L)).thenReturn(Optional.of(user));
        when(customerRepository.save(any(Customer.class))).thenReturn(customer);

        User result = userService.makeUserCustomer(1L, 100);

        assertTrue(result instanceof Customer);
        assertEquals(customer.getLoyaltyPoints(), ((Customer) result).getLoyaltyPoints());
    }

    @Test
    public void testGetUserByEmail() {
        when(userRepository.findByEmail("test@example.com")).thenReturn((List.of(user)));

        Optional<User> foundUser = userService.getUserByEmail("test@example.com");

        assertTrue(foundUser.isPresent());
        assertEquals(user.getEmail(), foundUser.get().getEmail());
    }
}

