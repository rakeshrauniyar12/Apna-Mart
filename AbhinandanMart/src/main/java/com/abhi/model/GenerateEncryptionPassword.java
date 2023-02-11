package com.abhi.model;
	import java.io.IOException;
	import java.io.StreamTokenizer;
	import java.security.InvalidAlgorithmParameterException;
	import java.security.InvalidKeyException;
	import java.security.NoSuchAlgorithmException;
	import java.util.Scanner;
	import javax.crypto.BadPaddingException;
	import javax.crypto.Cipher;
	import javax.crypto.IllegalBlockSizeException;
	import javax.crypto.NoSuchPaddingException;
	import javax.crypto.spec.SecretKeySpec;

	public class GenerateEncryptionPassword {

	    public static final String AES = "AES";

	    public static String byteArrayToHexString(byte[] b) {
	        StringBuffer sb = new StringBuffer(b.length * 2);
	        for (int i = 0; i < b.length; i++) {
	            int v = b[i] & 0xff;
	            if (v < 16) {
	                sb.append('0');
	            }
	            sb.append(Integer.toHexString(v));
	        }
	        return sb.toString().toUpperCase();
	    }
	  //  E718F25F1C5A78F0BC79C027AA42D27E
	    public static byte[] hexStringToByteArray(String s) {
	        byte[] b = new byte[s.length() / 2];
	        for (int i = 0; i < b.length; i++) {
	            int index = i * 2;
	            int v = Integer.parseInt(s.substring(index, index + 2), 16);
	            b[i] = (byte) v;
	        }
	        return b;
	    }

	  
	}

