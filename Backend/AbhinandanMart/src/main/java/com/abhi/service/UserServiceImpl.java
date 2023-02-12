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

import com.abhi.Dto.UserDto;
import com.abhi.globalException.UserException;
import com.abhi.model.Cart;
import com.abhi.model.GenerateEncryptionPassword;
import com.abhi.model.GeneratePlainPassword;
import com.abhi.model.User;
import com.abhi.repository.UserRepo;

@Service
public class UserServiceImpl implements UserService{

	
	@Autowired
	private UserRepo uRepo;
	private GenerateEncryptionPassword gep;
	private GeneratePlainPassword gpp;
	@Override
	public User registerUser(User user) throws InvalidKeyException, InvalidAlgorithmParameterException, NoSuchAlgorithmException, NoSuchPaddingException, IllegalBlockSizeException, BadPaddingException {
		     String key = "F21E2A7FB6C68037FAEAA55222E320F7";
		       String password=user.getPassword();
           byte[] bytekey = gep.hexStringToByteArray(key);
		        SecretKeySpec sks = new SecretKeySpec(bytekey, GenerateEncryptionPassword.AES);
		        Cipher cipher = Cipher.getInstance(GenerateEncryptionPassword.AES);
		        cipher.init(Cipher.ENCRYPT_MODE, sks, cipher.getParameters());
		        byte[] encrypted = cipher.doFinal(password.getBytes());
		        String encryptedpwd = gep.byteArrayToHexString(encrypted);
		      if(user!=null) {
		    	  user.setCart(new Cart());
		    	  user.setPassword(encryptedpwd);
		        return uRepo.save(user);
		      }else {
		       throw new NoSuchAlgorithmException("No such algorithm exit");
		      }
	}

	@Override
	public UserDto loginUser(String email,String pass) throws UserException, InvalidKeyException, NoSuchAlgorithmException, NoSuchPaddingException, IllegalBlockSizeException, BadPaddingException {
		                User us=uRepo.findByUserEmail(email);
		                if(us!=null) {
		                	 String tempkey = "F21E2A7FB6C68037FAEAA55222E320F7";
		                     String password = "";
		                 password=us.getPassword();
         byte[] bytekey = gpp.hexStringToByteArray(tempkey);
		                     SecretKeySpec sks = new SecretKeySpec(bytekey, GeneratePlainPassword.AES);
		                     Cipher cipher = Cipher.getInstance(GeneratePlainPassword.AES);
		                     cipher.init(Cipher.DECRYPT_MODE, sks);
		                     byte[] decrypted = cipher.doFinal(gpp.hexStringToByteArray(password));
		                     String OriginalPassword = new String(decrypted);
		                   if(OriginalPassword.equals(pass)) {
		               UserDto udt= new UserDto();
		               udt.setUserId(us.getUserId());
		               udt.setFirstName(us.getFirstName());
		               udt.setLastName(us.getLastName());
		               udt.setUserEmail(us.getUserEmail());
		               udt.setUserMobile(us.getUserMobile());
		               return udt;
		                   } else {
		                	   throw new UserException("Password is wrong");
		                   }
		                }else {
		                	throw new UserException("wrong credential");
		                }
	}

}
