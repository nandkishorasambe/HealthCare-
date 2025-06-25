package com.dentalmanagement.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dentalmanagement.entity.Admin;

public interface AdminDao extends JpaRepository<Admin, Integer> {

}
