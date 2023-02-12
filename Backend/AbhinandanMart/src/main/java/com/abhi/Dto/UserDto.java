package com.abhi.Dto;

import lombok.Data;

@Data
public class UserDto {
	private Integer userId;
	private String firstName;
	private String lastName;
	private String userEmail;
	private String userMobile;
}
