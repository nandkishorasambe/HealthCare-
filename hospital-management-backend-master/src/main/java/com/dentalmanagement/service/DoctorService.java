package com.dentalmanagement.service;

import java.util.Optional;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dentalmanagement.dao.DoctorDao;
import com.dentalmanagement.entity.DoctorDetails;

@Service
public class DoctorService {

	@Autowired
	public DoctorDao doctordao;

	@Autowired
	private EmailService emailService;

	public DoctorDetails registerDoctor(DoctorDetails doctor) {
		DoctorDetails registerDoctor = null;

		if (doctor != null) {
			String password = generatePassword(8);
			doctor.setPassword(password);

			registerDoctor = this.doctordao.save(doctor);
			emailService.sendRegistrationEmail(doctor.getEmailId(), password, doctor.getId());
		}
		return registerDoctor;
	}

	private String generatePassword(int length) {
		String chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
		StringBuilder password = new StringBuilder();
		Random random = new Random();
		for (int i = 0; i < length; i++) {
			password.append(chars.charAt(random.nextInt(chars.length())));
		}

		return password.toString();
	}

	public DoctorDetails findByEmailId(String emailId) {
		Optional<DoctorDetails> doctor = doctordao.findByemailId(emailId);

		if (doctor.isPresent()) {
			return doctor.get();
		} else {
			throw new RuntimeException("Doctor not found with email ID: " + emailId);
		}
	}

	public DoctorDetails findById(int id) {
		Optional<DoctorDetails> doctor1 = doctordao.findById(id);
		if (doctor1.isPresent()) {
			return doctor1.get();
		} else {
			throw new RuntimeException("Doctor not found with  ID: " + id);
		}
	}

}
