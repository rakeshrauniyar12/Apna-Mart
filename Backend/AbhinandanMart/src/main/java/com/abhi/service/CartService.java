package com.abhi.service;

import java.util.List;

import com.abhi.globalException.ProductException;
import com.abhi.globalException.UserException;
import com.abhi.model.Product;
import com.abhi.model.User;


public interface CartService {
    public List<Product> saveProduct(Product product) throws ProductException;
    public User saveUser(User user) throws UserException;
}
