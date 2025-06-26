package com.dentalmanagement.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dentalmanagement.entity.DoctorDetails;
import com.dentalmanagement.service.DoctorService;

@RestController
@RequestMapping("/doctordetails")
public class DoctorDetailsController {
	
	@Autowired
	 public DoctorService doctorservice;
	
	@PostMapping("/savedoctor")
	public ResponseEntity<String> saveDoctor(@RequestBody DoctorDetails doctorDetails) {
		doctorservice.registerDoctor(doctorDetails);
	    return ResponseEntity.ok("Doctor saved successfully");
	}
	
	@GetMapping("/email/{emailId}")
	public DoctorDetails findByEmailId(@PathVariable ("emailId")String emailId){
		return doctorservice.findByEmailId(emailId);	
	}

	@GetMapping("/id/{id}")
	public DoctorDetails findById(@PathVariable ("id")int id){
		return doctorservice.findById(id);
	}
	
}

		
		
		



