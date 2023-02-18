package com.abhi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.service.annotation.DeleteExchange;

import com.abhi.globalException.ProductException;
import com.abhi.globalException.UserException;
import com.abhi.model.Cart;
import com.abhi.model.Product;
import com.abhi.service.CartService;

@RestController
@CrossOrigin(origins = "*")
public class MyCartController {
      @Autowired
	private CartService cService;
	
	@PostMapping("/saveproduct/{userId}")
	public ResponseEntity<Cart> saveProductInCart(@PathVariable("userId") Integer userId,@RequestBody Product product) throws ProductException, UserException{
		       Cart c= cService.saveProduct(userId, product);
		      return new ResponseEntity<Cart>(c,HttpStatus.ACCEPTED);
	}
	@GetMapping("/getallproduct/{id}")
	public ResponseEntity<List<Product>> getAllProductFromCartHandler(@PathVariable("id") Integer id) throws UserException, ProductException{
		  List<Product> list= cService.getAllProductFromCart(id);
		  return new ResponseEntity<List<Product>>(list,HttpStatus.OK);
	}
	@DeleteMapping("/deleteproduct/{userid}/{productid}")
	public ResponseEntity<List<Product>> deleteProductFromCart(@PathVariable("userid") Integer userid,@PathVariable("productid") Integer productid) throws UserException, ProductException{
		              List<Product> product= cService.deleteProductFromCart(userid, productid);
		            return new ResponseEntity<List<Product>>(product,HttpStatus.OK);
	}
	@PatchMapping("/updatequantity/{userid}/{productid}/{quantity}")
	public ResponseEntity<Product> updatequantity(@PathVariable("userid") Integer userid,@PathVariable("productid") Integer productid,@PathVariable("quantity") Integer quantity) throws  ProductException, UserException{
		            Product product=cService.updateQuantityOfProduct(userid, productid, quantity);
		            return new ResponseEntity<Product>(product,HttpStatus.OK);
	}
}
