package com.abhi.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.abhi.Dto.UserDto;
import com.abhi.globalException.UserException;
import com.abhi.model.User;
import com.abhi.service.UserService;

@RestController
@CrossOrigin
public class UserController {
	
	@Autowired
	private UserService uService;
	@PostMapping("/registeruser")
	public ResponseEntity<User> registerUser(@Valid @RequestBody User user){
		  User use= uService.registerUser(user);
		  return new ResponseEntity<User>(use,HttpStatus.ACCEPTED);
	}
	@GetMapping("/loginuser/{email}")
	public ResponseEntity<UserDto> loginUser(@PathVariable("email") String email) throws UserException{
		  UserDto use= uService.loginUser(email);
		  return new ResponseEntity<UserDto>(use,HttpStatus.ACCEPTED);
	}
}
