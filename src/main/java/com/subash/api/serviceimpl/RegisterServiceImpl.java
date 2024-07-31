package com.subash.api.serviceimpl;

import java.time.Instant;
import java.util.Date;

import org.springframework.stereotype.Service;

import com.subash.api.model.Register;
import com.subash.api.model.Token;
import com.subash.api.ownrepo.RegisterOwnRepo;
import com.subash.api.service.RegisterService;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureException;

@Service
public class RegisterServiceImpl implements RegisterService {
	private static final String SECRET_KEY = "SUBASH";

	public RegisterServiceImpl(RegisterOwnRepo ownrepo) {
		super();
		this.ownrepo = ownrepo;
	}

	RegisterOwnRepo ownrepo;

	@Override
	public void addRegister(Register register) {
		ownrepo.save(register);
	}

	@Override
	public boolean checkCredentials(String email, String password) {
		Register register = ownrepo.findByEmail(email);
		return register != null && register.getPassword().equals(password);
	}

	@Override
	public void addToken(Token token) {
		ownrepo.saveToken(token);
		
	}

	@Override
	 public boolean isTokenValid(String randomValue) {
        try {
            // Fetch the token from the repository
            String tokenString = ownrepo.findByRandomValue(randomValue);
            if (tokenString != null) {
                // Validate and parse the JWT token
                Claims claims = Jwts.parser()
                    .setSigningKey(SECRET_KEY)
                    .parseClaimsJws(tokenString)
                    .getBody();
                
                Instant now = Instant.now();
                Date expiryDate = claims.getExpiration();
                
                System.out.println("EXPIRY IN "+expiryDate);

                // Check if the token is expired
                return !now.isAfter(expiryDate.toInstant());
            }
        } catch (SignatureException e) {
            // Handle invalid signature
            e.printStackTrace();
        }
        
        return false;
    }

	@Override
	public void deleteToken(String randomvalue) {
		ownrepo.deleteTokenIfExpiried(randomvalue);
			
		
	}

}
