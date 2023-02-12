package com.abhi.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.abhi.globalException.ProductException;
import com.abhi.globalException.UserException;
import com.abhi.model.Cart;
import com.abhi.model.Product;
import com.abhi.model.User;
import com.abhi.repository.CartRepo;
import com.abhi.repository.UserRepo;

public class CartServiceImpl implements CartService{
	@Autowired
	private CartRepo cRepo;
    private UserRepo uRepo;
	@Override
	public Cart saveProduct(Integer userId, Product product) throws ProductException,UserException {
		   Optional<User> user= uRepo.findById(userId); 
		    if(user.isPresent()) {
		    	user.get().getCart().getProduct().add(product);
		    	return user.get().getCart();
		    } else {
		    	throw new UserException("Please login first");
		    }
	}

	  

}
