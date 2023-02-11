package com.abhi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.abhi.model.Admin;
import com.abhi.model.User;

public interface UserRepo extends JpaRepository<User, Integer>{
	public User findByUserEmail(String email);
}
