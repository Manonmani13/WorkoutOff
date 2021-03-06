package com.proretention.refapi.ui.shared;

import java.security.SecureRandom;
import java.util.Random;

import org.springframework.stereotype.Component;

@Component
public class Utils {

	private final Random RANDOM = new SecureRandom();
	private final String ALPHABET = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
	
	public String generateUserId(int length) {
		return genrateRandomString(length);
	}

	private String genrateRandomString(int length) {
		StringBuilder retVal = new StringBuilder(length);
		for(int i=0; i<length; i++) {
			retVal.append(ALPHABET.charAt(RANDOM.nextInt(ALPHABET.length())));
		}
			
		return new String(retVal);
	}
}
