package com.abhi.service;

import java.util.List;

import com.abhi.globalException.ProductException;
import com.abhi.model.Product;

public interface ProductService {
   public Product saveProduct(Product product);
   public Product deleteProductById(Integer id) throws ProductException;
   public Product updateProduct(Product product) throws ProductException;
   public Product getProductById(Integer id) throws ProductException;
   public List<Product> getAllProduct() throws ProductException;
   public List<Product> getAllProductByCategory(String category) throws ProductException;
   public List<Product> getAllProductByRatingInAscendingOrder(String asc) throws ProductException;
   public List<Product> getAllProductByRatingIndescendingOrder(String desc) throws ProductException;
   public List<Product> getAllProductByRating(String all) throws ProductException;
   public List<Product> getAllProductByPriceInAscendingOrder(String asc) throws ProductException;
   public List<Product> getAllProductByPriceInDescendingOrder(String desc) throws ProductException;
   public List<Product> getAllProductByPrice(String all) throws ProductException;
   public List<Product> getAllProductByQuantity(Integer start,Integer end) throws ProductException;
   
}
