package com.abhi.service;

import com.abhi.Dto.UserDto;
import com.abhi.globalException.UserException;
import com.abhi.model.User;

public interface UserService {
     public User registerUser(User user);
     public UserDto loginUser(String email) throws UserException;
}
