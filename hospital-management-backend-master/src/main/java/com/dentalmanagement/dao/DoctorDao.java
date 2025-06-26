package com.dentalmanagement.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dentalmanagement.entity.DoctorDetails;

public interface DoctorDao extends JpaRepository<DoctorDetails, Long> {
	
	Optional<DoctorDetails> findByemailId(String emailId);

	Optional<DoctorDetails> findById(int id);

}
