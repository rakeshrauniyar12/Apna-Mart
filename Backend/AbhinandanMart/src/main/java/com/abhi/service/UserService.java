package com.abhi.service;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;

import com.abhi.Dto.UserDto;
import com.abhi.globalException.UserException;
import com.abhi.model.User;

public interface UserService {
     public User registerUser(User user) throws InvalidKeyException, InvalidAlgorithmParameterException,NoSuchAlgorithmException, NoSuchPaddingException,IllegalBlockSizeException, BadPaddingException;
     public UserDto loginUser(String email,String password) throws UserException,NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeyException, IllegalBlockSizeException, BadPaddingException, FileNotFoundException, IOException;
}
