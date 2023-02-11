package com.abhi.controller;

import java.io.FileNotFoundException;
import java.io.IOException;
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
import org.springframework.web.bind.annotation.RestController;

import com.abhi.Dto.UserDto;
import com.abhi.globalException.UserException;
import com.abhi.model.User;
import com.abhi.service.UserService;

import jakarta.validation.Valid;

@RestController
@CrossOrigin
public class UserController {
	
	@Autowired
	private UserService uService;
	@PostMapping("/registeruser")
	public ResponseEntity<User> registerUser(@Valid @RequestBody User user) throws InvalidKeyException, InvalidAlgorithmParameterException, NoSuchAlgorithmException, NoSuchPaddingException, IllegalBlockSizeException, BadPaddingException{
		  User use= uService.registerUser(user);
		  return new ResponseEntity<User>(use,HttpStatus.ACCEPTED);
	}
	@GetMapping("/loginuser/{email}/{password}")
	public ResponseEntity<UserDto> loginUser(@PathVariable("email") String email,@PathVariable("password") String password) throws UserException, InvalidKeyException, NoSuchAlgorithmException, NoSuchPaddingException, IllegalBlockSizeException, BadPaddingException, FileNotFoundException, IOException{
		  UserDto use= uService.loginUser(email,password);
		  return new ResponseEntity<UserDto>(use,HttpStatus.ACCEPTED);
	}
}
