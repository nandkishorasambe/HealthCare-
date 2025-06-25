package com.dentalmanagement.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dentalmanagement.entity.Admin;
import com.dentalmanagement.service.AdminService;


@RestController
@RequestMapping("/admin")
public class AdminController {

	@Autowired
	private AdminService adminService;
	
	@PostMapping("/save")
	public Admin createAdmin(@RequestBody Admin admin) {
		return adminService.createAdminService(admin);
	}
	
	@GetMapping("/get/{id}")
	public  Optional<Admin> getById(@PathVariable int id) { 
		return adminService.getByIdService(id);
	}
	
	@GetMapping("/getAll")
	public List<Admin> getAllAdmins() {
		return adminService.getAllAdmins();
	}
	
	@PutMapping("/update/{id}")
	public Admin updateAdmin(@RequestBody Admin admin, @PathVariable int id) {
		return adminService.updateAdminService(admin, id);
	}
	
}
