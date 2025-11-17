package com.itn.TutorialApp.service;

import com.itn.TutorialApp.dao.AdminRepository;
import com.itn.TutorialApp.entity.Admin;
import com.itn.TutorialApp.entity.User;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

public class AdminServiceImpl implements AdminService{

    @Autowired
    private AdminRepository adminRepository;

    @Override
    @Transactional
    public void addAdmin(Admin admin) {
        adminRepository.save(admin);
    }

    @Override
    public List<Admin> getAllAdmins() {
        return adminRepository.findAll();
    }

    @Override
    public Optional<Admin> getAdminById(Long id) {
        return adminRepository.findById(id);
    }

    @Override
    @Transactional
    public void deleteAdminById(Long id) {
        adminRepository.deleteById(id);
    }

    @Override
    @Transactional
    public Admin updateAdmin(Admin admin, Long id) {
        Admin oldAdmin = adminRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Admin not found with id: " + id));


        BeanUtils.copyProperties(admin, oldAdmin, "id", "cPassword", "adminRole");

        return adminRepository.save(oldAdmin);
    }
}