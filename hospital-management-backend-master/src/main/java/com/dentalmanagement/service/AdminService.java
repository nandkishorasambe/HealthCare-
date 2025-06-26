package com.dentalmanagement.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dentalmanagement.dao.AdminDao;
import com.dentalmanagement.entity.Admin;

@Service
public class AdminService {
	
	@Autowired
	private AdminDao adminDao;
	
	public Admin createAdminService(Admin admin) {
		return adminDao.save(admin);
	}
	
	public Optional<Admin> getByIdService(int id) {
		 Optional<Admin> existingAdminId = adminDao.findById(id);
		 return existingAdminId;
	}

	public List<Admin> getAllAdmins() {
		return adminDao.findAll();
	}
	
	public Admin updateAdminService(Admin admin, Integer id) {
		return adminDao.findById(id).map(existingAdmin -> {
			existingAdmin.setFullname(admin.getFullname());
			existingAdmin.setEmail(admin.getEmail());
			existingAdmin.setPhone(admin.getPhone());
			existingAdmin.setIsActive(admin.getIsActive());
			existingAdmin.setRole(admin.getRole());
			existingAdmin.setUsername(admin.getUsername());
			existingAdmin.setPassword(admin.getPassword());
			return adminDao.save(existingAdmin);
		}).orElseThrow(() -> new RuntimeException("Admin not found with id: " + id));
	}
		
}
