package com.subash.api.ownrepo;

import com.subash.api.model.Register;
import com.subash.api.model.Token;

public interface RegisterOwnRepo {

	public void save(Register register);

	public void saveToken(Token token);

	public Register findByEmail(String email);

	String findByRandomValue(String randomValue);
	public void deleteTokenIfExpiried(String randomvalue);

}
