package com.cinema.app.service.user;

import com.cinema.app.model.user.Admin;

import java.util.Optional;

public interface AdminService {
    Optional<Admin> getAdminByCode(String adminCode);
}
