package com.cinema.app.service.user;

import com.cinema.app.model.user.Admin;
import com.cinema.app.repository.user.AdminRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AdminServiceImpl implements AdminService {
    private final AdminRepository adminRepository;

    @Override
    public Optional<Admin> getAdminByCode(String adminCode) {
        return Optional.ofNullable(adminRepository.findByAdminCode(adminCode).getFirst());
    }
}
