package com.abhi.controller;

import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.abhi.Dto.AdminDto;
import com.abhi.globalException.AdminException;
import com.abhi.model.Admin;
import com.abhi.model.AdminLogin;
import com.abhi.service.AdminService;

import jakarta.validation.Valid;

@RestController
@CrossOrigin(origins="*")
@RequestMapping("/admin")
public class AdminController {
	
	
	@Autowired
	private AdminService aService;
	@PostMapping("/saveadmindetails")
	public ResponseEntity<AdminDto> registerAdmin(@Valid @RequestBody Admin admin) throws InvalidKeyException, InvalidAlgorithmParameterException, NoSuchAlgorithmException, NoSuchPaddingException, IllegalBlockSizeException, BadPaddingException{
		    Admin adm= aService.saveAdminDetails(admin); 
		    AdminDto as= new AdminDto();
			   as.setEmail(adm.getAdminEmail());
			   as.setName(adm.getAdminName());
			   as.setMobileNo(adm.getMobileNo());
			   return new ResponseEntity<AdminDto>(as,HttpStatus.ACCEPTED);
	}
	@GetMapping("/loginadmin/{email}/{password}")
	public ResponseEntity<AdminDto> loginAdminHandler(@PathVariable("email") String email,@PathVariable String password) throws AdminException, InvalidKeyException, NoSuchAlgorithmException, NoSuchPaddingException, IllegalBlockSizeException, BadPaddingException{
		   Admin adm=   aService.loginAdmin(email,password);
		   AdminDto as= new AdminDto();
		   as.setEmail(adm.getAdminEmail());
		   as.setName(adm.getAdminName());
		   as.setMobileNo(adm.getMobileNo());
		   return new ResponseEntity<AdminDto>(as,HttpStatus.ACCEPTED);
	}
}
