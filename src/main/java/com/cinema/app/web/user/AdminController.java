package com.cinema.app.web.user;

import com.cinema.app.model.user.Admin;
import com.cinema.app.service.user.AdminServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/admins")
@RequiredArgsConstructor
public class AdminController {
    private final AdminServiceImpl adminService;

    @GetMapping("/code/{adminCode}")
    public Optional<Admin> getAdminByCode(@PathVariable String adminCode) {
        return adminService.getAdminByCode(adminCode);
    }
}
