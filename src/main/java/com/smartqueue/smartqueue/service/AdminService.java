package com.smartqueue.smartqueue.service;
import org.springframework.stereotype.Service;
import com.smartqueue.smartqueue.entity.Admin;
import com.smartqueue.smartqueue.repository.AdminRepository;
@Service
public class AdminService {
    private final AdminRepository adminRepository;
    public AdminService(AdminRepository adminRepository) {
        this.adminRepository = adminRepository;
    }
    public Admin register(Admin admin) {
        return adminRepository.save(admin);
    }
    public Admin login(String email, String password) {
        Admin admin = adminRepository.findByEmail(email).orElse(null);
        if (admin != null && admin.getPassword().equals(password)) {
            return admin;
        }
        return null;
    }
}
