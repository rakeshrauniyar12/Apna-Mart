package com.abhi.service;

import com.abhi.Dto.AdminDto;
import com.abhi.globalException.AdminException;
import com.abhi.model.Admin;

public interface AdminService {
    public Admin saveAdminDetails(Admin admin);
    public Admin loginAdmin(String email) throws AdminException;
}
