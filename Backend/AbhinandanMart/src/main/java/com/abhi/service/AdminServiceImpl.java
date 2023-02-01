package com.abhi.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.abhi.Dto.AdminDto;
import com.abhi.globalException.AdminException;
import com.abhi.model.Admin;
import com.abhi.repository.AdminRepo;
@Service
public class AdminServiceImpl implements AdminService{

	@Autowired
	private AdminRepo aRepo;
	@Override
	public Admin saveAdminDetails(Admin admin) {
		        return aRepo.save(admin);
	}
	@Override
	public Admin loginAdmin(String email) throws AdminException {
		            Admin adm=  aRepo.findByAdminEmail(email);
		            if(adm!=null) {
		            	return adm;
		            } else {
		            	throw new AdminException("Wrong Credential");
		            }
	}

}
