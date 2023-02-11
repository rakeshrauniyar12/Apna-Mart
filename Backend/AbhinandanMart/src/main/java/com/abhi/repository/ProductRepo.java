package com.abhi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.abhi.model.Product;

public interface ProductRepo extends JpaRepository<Product, Integer>{
       
	public List<Product> findByCategory(String category);
	
	
	@Query("select p from Product p where p.quantity>=?1 and p.quantity<=?2")
	public List<Product> findProductBasedOnQuantity(Integer start,Integer end);
	
	
}
