package com.abhi.service;

import org.springframework.beans.factory.annotation.Autowired;

import com.abhi.globalException.ProductException;
import com.abhi.globalException.UserException;
import com.abhi.model.Cart;
import com.abhi.model.Product;
import com.abhi.model.User;
import com.abhi.repository.CartRepo;

public class CartServiceImpl implements CartService{
	@Autowired
	private CartRepo cRepo;

	@Override
	public Cart saveProduct(Product product) throws ProductException {
		     Cart c= new Cart();
		     c.getProduct().add(product);
		     cRepo.save(c);
		     return c;
	}

	@Override
	public User saveUser(User user) throws UserException {
		// TODO Auto-generated method stub
		return null;
	}

}
