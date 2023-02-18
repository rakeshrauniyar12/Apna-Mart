package com.abhi.service;

import java.util.List;

import com.abhi.globalException.ProductException;
import com.abhi.globalException.UserException;
import com.abhi.model.Cart;
import com.abhi.model.Product;


public interface CartService {
	
    public Cart saveProduct(Integer userId,Product product) throws ProductException,UserException;
    public List<Product> getAllProductFromCart(Integer id) throws UserException,ProductException;
public Product deleteProductFromCart(Integer userId,Integer productId) throws UserException,ProductException; 
 public Product updateQuantityOfProduct(Integer userId,Integer productId,Integer quantity) throws UserException,ProductException;
}
