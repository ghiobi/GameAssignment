package com.games.services;

import com.games.data.gateway.UserTableGateway;
import com.games.models.User;

public class AuthService {

	private static AuthService instance = null;
	
	private AuthService() { }
	
	public User register() {
		return null;
	}
	
	public User getUserById(int id) {
		return getUserGateway().getUserById(id);
	}
	
	public User authenticate(String email, String password) {
		User user = getUserGateway().getUserByEmail(email);
		
		if (user == null || !user.getPassword().equals(password)) {
			return null;
		}
		
		return user;
	}
	
	protected UserTableGateway getUserGateway() {
		return UserTableGateway.getInstance();
	}
	
	public static AuthService getInstance () {
		if (instance == null) {
			instance = new AuthService();
		}
		return instance;
	}
	
}
