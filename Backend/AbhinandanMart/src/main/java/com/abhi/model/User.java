package com.abhi.model;


import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Entity
@Data
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer userId;
	
	@NotNull(message = "First name should not be null")
	@Size(min = 3,max = 15,message = "Name should be between 3 to 15 characters")
	private String firstName;
	
	@NotNull(message = "Last name should not be null")
	@Size(min = 3,max = 12,message = "Name should be between 3 to 12 characters")
	private String lastName;
	
	@NotNull(message = "Email should not be null")
	@Email(message = "Please enter correct format of email")
	@Column(unique = true)
	private String userEmail;
	
	@NotNull(message = "Password should not be null")
	@Size(min = 8,max = 40,message = "Password length should be between 8 to 20")
	private String password;
	
	@NotNull(message = "Mobile number should not be null")
	@Size(min = 10,max = 10,message = "Mobile number should be of 10 digits")
	private String userMobile;
	
	@NotNull(message = "City should not be null")
	private String city;
	
	@NotNull(message =  "state should not be null")
	private String state;
	
	@NotNull(message = "Pincode should be of 6 digits")
	@Size(min = 6,max = 6)
	private String pincode;
	
	
}
