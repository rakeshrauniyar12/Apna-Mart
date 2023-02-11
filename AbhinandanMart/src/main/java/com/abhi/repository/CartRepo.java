package com.abhi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.abhi.model.Cart;

public interface CartRepo extends JpaRepository<Cart, Integer>{

}
