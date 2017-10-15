package com.games.services;

public class UserService {

	public static UserService instance = null;
	
	private UserService() { }
	
	static UserService getInstance () {
		if (instance == null) {
			instance = new UserService();
		}
		return instance;
	}
}
