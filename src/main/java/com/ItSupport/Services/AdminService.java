package com.ItSupport.Services;

import com.ItSupport.Dao.AdminRepository;
import com.ItSupport.Models.heritage.Admin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AdminService {

    @Autowired
    private AdminRepository adminRepository;

    public List<Admin> getAllAdmins() {
        return adminRepository.findAll();
    }

    public Admin addAdmin(Admin admin) {
        return adminRepository.save(admin);
    }

    public Optional<Admin> getAdminById(Long id) {
        return adminRepository.findById(id);
    }

    public Admin updateAdmin(Long id, Admin updatedAdmin) {
        return adminRepository.findById(id)
                .map(admin -> {
                    admin.setUsername(updatedAdmin.getUsername());
                    admin.setUsername(updatedAdmin.getUsername());
                    return adminRepository.save(admin);
                })
                .orElseThrow(() -> new RuntimeException("Admin non trouvé avec ID : " + id));
    }

    public void deleteAdmin(Long id) {
        adminRepository.deleteById(id);
    }
}
