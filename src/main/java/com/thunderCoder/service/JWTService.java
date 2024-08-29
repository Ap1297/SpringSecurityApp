package com.thunderCoder.service;

import java.security.Key;
import java.security.NoSuchAlgorithmException;
import java.sql.Date;
import java.util.Base64;
import java.util.HashMap;
import java.util.Map;

import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;

import org.springframework.stereotype.Service;

import com.thunderCoder.model.Users;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;

@Service
public class JWTService {

	private String secretKey ;
	
	public JWTService() {
		try {
			KeyGenerator keyGen=  KeyGenerator.getInstance("HmacSHA256");
			SecretKey key = keyGen.generateKey();
			secretKey = Base64.getEncoder().encodeToString(key.getEncoded());
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public String generateToken(Users user) {
		
		Map<String,Object> claims = new HashMap<>();
		
		return Jwts.builder()
				.claims()
				.add(claims)
				.subject(user.getUsername())
				.issuedAt(new Date(System.currentTimeMillis()))
				.expiration(new Date(System.currentTimeMillis() + 60 * 60))
				.and()
				.signWith(getKey())
				.compact();
				
	}

	private Key getKey() {
		byte[] keyBytes = Decoders.BASE64.decode(secretKey);
		return Keys.hmacShaKeyFor(keyBytes);
	}
}
