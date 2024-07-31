package com.subash.api.service;

import com.subash.api.model.Register;
import com.subash.api.model.Token;

public interface RegisterService {

	public void addRegister(Register register);
	public void addToken(Token token);
	
	 public boolean checkCredentials(String email, String password);
	 public boolean isTokenValid(String randomvalues);
	 public void deleteToken(String randomvalue);
	 
	 
}
