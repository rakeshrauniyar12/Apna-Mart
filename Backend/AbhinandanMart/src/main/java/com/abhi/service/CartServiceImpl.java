package com.abhi.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.abhi.globalException.ProductException;
import com.abhi.globalException.UserException;
import com.abhi.model.Cart;
import com.abhi.model.Product;
import com.abhi.model.User;
import com.abhi.repository.CartRepo;
import com.abhi.repository.UserRepo;
@Service
public class CartServiceImpl implements CartService{
	@Autowired
	private CartRepo cRepo;
	@Autowired
    private UserRepo uRepo;
	@Override
	public Cart saveProduct(Integer userId, Product product) throws ProductException,UserException {
		   Optional<User> user= uRepo.findById(userId); 
		    if(user.isPresent()) {
		    	user.get().getCart().getProduct().add(product);
		    	return  cRepo.save(user.get().getCart());
		    } else {
		    	throw new UserException("Please login first");
		    }
	}

	

	@Override
	public List<Product> getAllProductFromCart(Integer id) throws UserException, ProductException {
		                  Optional<User> user=uRepo.findById(id);
		                  if(user!=null) {
		                	  List<Product> list=user.get().getCart().getProduct();
		                	  if(list.size()!=0) {
		                		  return list;
		                	  } else {
		                		  throw new ProductException("No Product is available in your cart");
		                	  }
		                  } else {
		                	  throw new UserException("No user found");
		                  }
	}



	@Override
	public Product deleteProductFromCart(Integer userId,Integer productId) throws UserException,ProductException {
		             Optional<User> user=uRepo.findById(userId);
		             Product product = null;
		             if(user!=null) {
		            	List<Product> list= user.get().getCart().getProduct();
		            	boolean flag=true;
		            	for(int r=0;r<list.size();r++) {
		            		if(list.get(r).getProductId()==productId) {
		            			flag=true;
		            		product=list.remove(r);
		            		cRepo.save(user.get().getCart());;
		            		} else {
		            			flag=false;
		            		}
		            	}
		            	if(flag) {
		            		
		            	} else {
		            		throw new ProductException("Product is not exist with given id");
		            	}
//		            	List<Product> ss=list.stream().filter(p-> p.getProductId()!=productId).collect(Collectors.toList());
//		            	return ss;
		             } else {
		            	 throw new UserException("No cart is available for this user");
		             }
		           return product;
	}



	@Override
	public Product updateQuantityOfProduct(Integer userId,Integer productId,Integer quantity) throws ProductException, UserException {
		  Optional<User> user=uRepo.findById(userId);
          Product product = null;
          if(user!=null) {
         	List<Product> list= user.get().getCart().getProduct();
         	boolean flag=true;
         	for(int r=0;r<list.size();r++) {
         		if(list.get(r).getProductId()==productId) {
         			flag=true;
         		    list.get(r).setQuantity(list.get(r).getQuantity()+quantity);
         		cRepo.save(user.get().getCart());;
         		product= list.get(r);
         		} else {
         			flag=false;
         		}
         	}
         	if(flag) {
         		
         	} else {
         		throw new ProductException("Product is not exist with given id");
         	}
//         	List<Product> ss=list.stream().filter(p-> p.getProductId()!=productId).collect(Collectors.toList());
//         	return ss;
          } else {
         	 throw new UserException("No cart is available for this user");
          }
        return product;     
	}

}
