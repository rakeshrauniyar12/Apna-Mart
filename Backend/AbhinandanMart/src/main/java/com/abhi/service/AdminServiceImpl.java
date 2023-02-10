package com.abhi.service;

import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.SecretKeySpec;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.abhi.Dto.AdminDto;
import com.abhi.Dto.UserDto;
import com.abhi.globalException.AdminException;
import com.abhi.globalException.UserException;
import com.abhi.model.Admin;
import com.abhi.model.GenerateEncryptionPassword;
import com.abhi.model.GeneratePlainPassword;
import com.abhi.repository.AdminRepo;
@Service
public class AdminServiceImpl implements AdminService{

	@Autowired
	private AdminRepo aRepo;
	private GenerateEncryptionPassword gep;
	private GeneratePlainPassword gpp;
	@Override
	public Admin saveAdminDetails(Admin admin) throws InvalidKeyException, InvalidAlgorithmParameterException, NoSuchAlgorithmException, NoSuchPaddingException, IllegalBlockSizeException, BadPaddingException{
		 String key = "F21E2A7FB6C68037FAEAA55222E320F7";
	       String password=admin.getAdminPassword();

	        byte[] bytekey = gep.hexStringToByteArray(key);
	        SecretKeySpec sks = new SecretKeySpec(bytekey, GenerateEncryptionPassword.AES);
	        Cipher cipher = Cipher.getInstance(GenerateEncryptionPassword.AES);
	        cipher.init(Cipher.ENCRYPT_MODE, sks, cipher.getParameters());
	        byte[] encrypted = cipher.doFinal(password.getBytes());
	        String encryptedpwd = gep.byteArrayToHexString(encrypted);
	      if(admin!=null) {
	    	  admin.setAdminPassword(encryptedpwd);
	        return aRepo.save(admin);
	      }else {
	       throw new NoSuchAlgorithmException("No such algorithm exit");
	      }
	}
	@Override
	public Admin loginAdmin(String email,String pass) throws AdminException ,InvalidKeyException, NoSuchAlgorithmException, NoSuchPaddingException, IllegalBlockSizeException, BadPaddingException {
		            Admin adm=  aRepo.findByAdminEmail(email);
		            if(adm!=null) {
	                	 String tempkey = "F21E2A7FB6C68037FAEAA55222E320F7";
	                     String password = "";
	                 password=adm.getAdminPassword();
    byte[] bytekey = gpp.hexStringToByteArray(tempkey);
	                     SecretKeySpec sks = new SecretKeySpec(bytekey, GeneratePlainPassword.AES);
	                     Cipher cipher = Cipher.getInstance(GeneratePlainPassword.AES);
	                     cipher.init(Cipher.DECRYPT_MODE, sks);
	                     byte[] decrypted = cipher.doFinal(gpp.hexStringToByteArray(password));
	                     String OriginalPassword = new String(decrypted);
	                   if(OriginalPassword.equals(pass)) {
	                      return adm;
	                   } else {
	                	   throw new AdminException("Password is wrong");
	                   }
	                }else {
	                	throw new AdminException("wrong credential");
	                }
	}

}
