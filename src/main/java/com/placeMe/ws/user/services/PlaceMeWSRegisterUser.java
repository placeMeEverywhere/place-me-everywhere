package com.placeMe.ws.user.services;

import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.util.UUID;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

import org.apache.commons.lang.RandomStringUtils;
import com.placeMe.util.PlaceMeUtil;

@WebService
public class PlaceMeWSRegisterUser {
	
	@WebMethod
	public String register(	@WebParam(name="email") String email,
							@WebParam(name="useEmailAsNickname") boolean emailAsNick,
							@WebParam(name="nickname") String nickname, 
							@WebParam(name="name") String name, 
							@WebParam(name="surname") String surname){
		String rdmPasswd = RandomStringUtils.randomAlphanumeric(8);
		try {
			String generatedID = UUID.randomUUID().toString();
	        String encr_rdmPasswd = new String(PlaceMeUtil.encrypt(rdmPasswd));
		} catch (InvalidKeyException e) {
			e.printStackTrace();
			return e.getMessage();
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
			return e.getMessage();
		} catch (InvalidKeySpecException e) {
			e.printStackTrace();
			return e.getMessage();
		} catch (NoSuchPaddingException e) {
			e.printStackTrace();
			return e.getMessage();
		} catch (InvalidAlgorithmParameterException e) {
			e.printStackTrace();
			return e.getMessage();
		} catch (IllegalBlockSizeException e) {
			e.printStackTrace();
			return e.getMessage();
		} catch (BadPaddingException e) {
			e.printStackTrace();
			return e.getMessage();
		}
		return "Welcome in Place ME! This is PWD: " + rdmPasswd;
	}
}
