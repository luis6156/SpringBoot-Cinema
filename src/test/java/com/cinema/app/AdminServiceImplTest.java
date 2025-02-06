package com.cinema.app;

import com.cinema.app.model.user.Admin;
import com.cinema.app.repository.user.AdminRepository;
import com.cinema.app.service.user.AdminServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.*;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import java.util.Optional;

public class AdminServiceImplTest {

    @Mock
    private AdminRepository adminRepository;

    @InjectMocks
    private AdminServiceImpl adminService;

    private Admin admin;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);

        admin = new Admin();
        admin.setAdminCode("ADMIN123");
    }

    @Test
    public void testGetAdminByCode() {
        String adminCode = "ADMIN123";
        when(adminRepository.findByAdminCode(adminCode)).thenReturn(List.of(new Admin[]{admin}));

        Optional<Admin> result = adminService.getAdminByCode(adminCode);

        assertTrue(result.isPresent());
        assertEquals(admin, result.get());
        verify(adminRepository, times(1)).findByAdminCode(adminCode);
    }
}
