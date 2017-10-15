package com.games.services;

import com.games.models.User;

public class AuthService {

	private static AuthService instance = null;
	
	private AuthService() { }
	
	public User register() {
		return null;
	}
	
	public User authenticate(String email, String password) {
		return null;
	}
	
	public static AuthService getInstance () {
		if (instance == null) {
			instance = new AuthService();
		}
		return instance;
	}
	
}
