package com.abhi.service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.abhi.globalException.ProductException;
import com.abhi.model.Product;
import com.abhi.repository.ProductRepo;
@Service
public class ProductServiceImpl implements ProductService{

	@Autowired
	private ProductRepo pRepo;
	
	
	@Override
	public Product saveProduct(Product product) {
		       return pRepo.save(product);
	}

	@Override
	public Product deleteProductById(Integer id) throws ProductException {
		                 Optional<Product> opt=pRepo.findById(id);
		                 if(opt.isPresent()) {
		               pRepo.delete(opt.get());
		                 } else {
		                	 throw new ProductException("No Product Found With given:"+id);
		                 }
		                 return opt.get();
	}

	@Override
	public Product updateProduct(Product product) throws ProductException {
		       Optional<Product> opt=   pRepo.findById(product.getProductId());
		       if(opt.isPresent()) {
		    	return pRepo.save(product);
		       } else {
		    	   throw new ProductException("Not Updated");
		       }
		      
	}

	@Override
	public Product getProductById(Integer id) throws ProductException {
		  Optional<Product> opt=pRepo.findById(id);
          if(opt.isPresent()) {
             return opt.get();
          } else {
         	 throw new ProductException("No Product Found With given:"+id);
          }
	}

	@Override
	public List<Product> getAllProduct() throws ProductException {
		       List<Product> listProduct= pRepo.findAll();
		    if(listProduct.size()==0) {
		    	throw new ProductException("No Product available right now");
		    } else {
		    	return listProduct;
		    }
	}

	@Override
	public List<Product> getAllProductByCategory(String category) throws ProductException {
		          List<Product> listProduct= pRepo.findByCategory(category);
		          if(listProduct.size()==0) {
				    	throw new ProductException("No Product available right now");
				    } else {
				    	return listProduct;
				    }
	}

	@Override
	public List<Product> getAllProductByRatingInAscendingOrder(String asc) throws ProductException {
		        List<Product> listProduct= pRepo.findAll();
		     
		        if(listProduct.size()==0) {
			    	throw new ProductException("No Product found");
			    } else {
			      Collections.sort(listProduct,(Product p1,Product p2)->{
			    	 return p1.getRating().compareTo(p2.getRating());
			      });
			      return listProduct;
			    }
	}

	@Override
	public List<Product> getAllProductByRatingIndescendingOrder(String desc) throws ProductException {
		   List<Product> listProduct= pRepo.findAll();
	      
	        if(listProduct.size()==0) {
		    	throw new ProductException("No Product found");
		    } else {
		      Collections.sort(listProduct,(Product p1,Product p2)->{
		    	 return p2.getRating().compareTo(p1.getRating());
		      });
		      return listProduct;
		    }
	}

	@Override
	public List<Product> getAllProductByRating(String all) throws ProductException {
		   List<Product> listProduct= pRepo.findAll();
	       
	        if(listProduct.size()==0) {
		    	throw new ProductException("No Product found");
		    } else {
		      
		      return listProduct;
		    }
	}

	@Override
	public List<Product> getAllProductByPriceInAscendingOrder(String asc) throws ProductException {
		   List<Product> listProduct= pRepo.findAll();
	     
	        if(listProduct.size()==0) {
		    	throw new ProductException("No Product found");
		    } else {
		      Collections.sort(listProduct,(Product p1,Product p2)->{
		    	   if(p1.getPrice()>p2.getPrice()) {
		    		   return 1;
		    	   }
		    	   else if(p1.getPrice()<p2.getPrice()) {
		    		   return -1;
		    	   } else {
		    		   return 0;
		    	   }
		      });
		      return listProduct;
		    }
	}

	@Override
	public List<Product> getAllProductByPriceInDescendingOrder(String desc) throws ProductException {
		  List<Product> listProduct= pRepo.findAll();
	     
	        if(listProduct.size()==0) {
		    	throw new ProductException("No Product found");
		    } else {
		      Collections.sort(listProduct,(Product p1,Product p2)->{
		    	   if(p1.getPrice()<p2.getPrice()) {
		    		   return 1;
		    	   }
		    	   else if(p1.getPrice()>p2.getPrice()) {
		    		   return -1;
		    	   } else {
		    		   return 0;
		    	   }
		      });
		      return listProduct;
		    }
	}

	@Override
	public List<Product> getAllProductByPrice(String all) throws ProductException {
		  List<Product> listProduct= pRepo.findAll();
	       
	        if(listProduct.size()==0) {
		    	throw new ProductException("No Product found");
		    } else {
		    
		      return listProduct;
		    }
	}

	@Override
	public List<Product> getAllProductByQuantity(Integer start, Integer end) throws ProductException {
		   List<Product> listProduct=pRepo.findProductBasedOnQuantity(start, end);
		 
		   if(listProduct.size()==0) {
			   throw new ProductException("No product found between given quantity");
		   } else {
		   
		   return listProduct;
		   }
	}

}
