package com.abhi.globalException;

public class LoginException extends Exception{
       public LoginException(String messege) {
    	   super(messege);
       }
       public LoginException() {};
}
