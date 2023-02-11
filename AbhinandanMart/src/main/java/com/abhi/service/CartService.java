package com.abhi.service;

import com.abhi.globalException.ProductException;
import com.abhi.globalException.UserException;
import com.abhi.model.Cart;
import com.abhi.model.Product;
import com.abhi.model.User;


public interface CartService {
	
    public Cart saveProduct(Product product) throws ProductException;
    
    public User saveUser(User user) throws UserException;
    
}