package com.abhi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.abhi.globalException.ProductException;
import com.abhi.model.AdminLogin;
import com.abhi.model.Product;
import com.abhi.service.ProductService;

@RestController
@CrossOrigin
public class MyProductController {
	
	@Autowired
	private ProductService pService;
	private AdminLogin aLogin;
	  
	@PostMapping("/products")
      public ResponseEntity<Product> saveProductHandler(@RequestBody Product product){
    	    Product product1= pService.saveProduct(product);
    	    return new ResponseEntity<Product>(product1,HttpStatus.ACCEPTED);
    	}
	@DeleteMapping("/deleteproducts/{id}")
    public ResponseEntity<Product> deleteProductByIdHandler(@PathVariable("id") Integer id) throws ProductException{
  	       
		Product product1= pService.deleteProductById(id);
  	    return new ResponseEntity<Product>(product1,HttpStatus.ACCEPTED);
  	}
	@PutMapping("/updateproducts")
    public ResponseEntity<Product> updateProductHandler(@RequestBody Product product) throws ProductException{
  	    Product product1= pService.updateProduct(product);
  	    return new ResponseEntity<Product>(product1,HttpStatus.ACCEPTED);
  	}
	@GetMapping("/getproductbyid/{id}")
    public ResponseEntity<Product> getProductByIdHandler(@PathVariable("id") Integer id) throws ProductException{
  	    Product product1= pService.getProductById(id);
  	    return new ResponseEntity<Product>(product1,HttpStatus.OK);
  	}
	@GetMapping("/getallproduct")
    public ResponseEntity<List<Product>> getAllProductHandler() throws ProductException{
  	    List<Product> product1= pService.getAllProduct();
  	    return new ResponseEntity<List<Product>>(product1,HttpStatus.OK);
  	}
	@GetMapping("/getallproductbycategory/{category}")
    public ResponseEntity<List<Product>> getAllProductByCategoryHandler(@PathVariable("category") String category) throws ProductException{
  	    List<Product> product1= pService.getAllProductByCategory(category);
  	    return new ResponseEntity<List<Product>>(product1,HttpStatus.OK);
  	}
	
	@GetMapping("/getallproductbyratinginascendingorder/{asc}")
    public ResponseEntity<List<Product>> getAllProductByRatingInAscendingOrder(@PathVariable("asc") String asc) throws ProductException{
  	    List<Product> product1= pService.getAllProductByRatingInAscendingOrder(asc);
  	    return new ResponseEntity<List<Product>>(product1,HttpStatus.OK);
  	}
	@GetMapping("/getallproductbyratingindescendingorder/{desc}")
    public ResponseEntity<List<Product>> getAllProductByRatingInDescendingOrder(@PathVariable("desc") String desc) throws ProductException{
  	    List<Product> product1= pService.getAllProductByRatingIndescendingOrder(desc);
  	    return new ResponseEntity<List<Product>>(product1,HttpStatus.OK);
  	}
	@GetMapping("/getallproductbyrating/{all}")
    public ResponseEntity<List<Product>> getAllProductByRating(@PathVariable("all") String all) throws ProductException{
  	    List<Product> product1= pService.getAllProductByRating(all);
  	    return new ResponseEntity<List<Product>>(product1,HttpStatus.OK);
  	}
	@GetMapping("/getallproductbypriceinascendingorder/{asc}")
    public ResponseEntity<List<Product>> getAllProductByPriceInAscendingOrderHandler(@PathVariable("asc") String asc) throws ProductException{
  	    List<Product> product1= pService.getAllProductByPriceInAscendingOrder(asc);
  	    return new ResponseEntity<List<Product>>(product1,HttpStatus.OK);
  	}
	@GetMapping("/getallproductbypriceindescendingorder/{desc}")
    public ResponseEntity<List<Product>> getAllProductByPriceInDescendingOrder(@PathVariable("desc") String desc) throws ProductException{
  	    List<Product> product1= pService.getAllProductByPriceInDescendingOrder(desc);
  	    return new ResponseEntity<List<Product>>(product1,HttpStatus.OK);
  	}
	@GetMapping("/getallproductbyprice/{all}")
    public ResponseEntity<List<Product>> getAllProductByPrice(@PathVariable("all") String all) throws ProductException{
  	    List<Product> product1= pService.getAllProductByPrice(all);
  	    return new ResponseEntity<List<Product>>(product1,HttpStatus.OK);
  	}
	@GetMapping("/getallproductbyquantity/{start}/{end}")
    public ResponseEntity<List<Product>> getAllProductByQuantity(@PathVariable("start") Integer start,@PathVariable("end") Integer end) throws ProductException{
  	    List<Product> product1= pService.getAllProductByQuantity(start, end);
  	    return new ResponseEntity<List<Product>>(product1,HttpStatus.OK);
  	}
}
