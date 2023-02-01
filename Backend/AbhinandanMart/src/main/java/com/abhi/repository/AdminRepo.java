package com.abhi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.abhi.model.Admin;

public interface AdminRepo extends JpaRepository<Admin, Integer>{
	
	public Admin findByAdminEmail(String email);

}
