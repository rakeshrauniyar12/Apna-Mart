package com.abhi.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.abhi.Dto.UserDto;
import com.abhi.globalException.UserException;
import com.abhi.model.User;
import com.abhi.repository.UserRepo;

@Service
public class UserServiceImpl implements UserService{

	
	@Autowired
	private UserRepo uRepo;
	@Override
	public User registerUser(User user) {
		      return uRepo.save(user);
	}

	@Override
	public UserDto loginUser(String email) throws UserException {
		                User us=uRepo.findByUserEmail(email);
		                if(us!=null) {
		               UserDto udt= new UserDto();
		               udt.setFirstName(us.getFirstName());
		               udt.setLastName(us.getLastName());
		               udt.setUserEmail(us.getUserEmail());
		               udt.setUserMobile(us.getUserMobile());
		               return udt;
		                }else {
		                	throw new UserException("Wrong Credential");
		                }
	}

}