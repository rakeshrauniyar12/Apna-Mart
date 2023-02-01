package com.abhi.controller;

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
import com.abhi.service.AdminService;

@RestController
@CrossOrigin
@RequestMapping("/admin")
public class AdminController {
	
	
	@Autowired
	private AdminService aService;
	
	@PostMapping("/saveadmin")
	public ResponseEntity<Admin> saveAdminHandler(@RequestBody Admin admin){
		   Admin adm=   aService.saveAdminDetails(admin);
		      
		      return new ResponseEntity<Admin>(adm,HttpStatus.ACCEPTED);
	}
	@GetMapping("/loginadmin/{email}")
	public ResponseEntity<AdminDto> loginAdminHandler(@PathVariable("email") String email) throws AdminException{
		   Admin adm=   aService.loginAdmin(email);
		   AdminDto as= new AdminDto();
		   as.setEmail(adm.getAdminEmail());
		   as.setName(adm.getAdminName());
		   as.setMobileNo(adm.getMobileNo());
		   return new ResponseEntity<AdminDto>(as,HttpStatus.ACCEPTED);
	}
}