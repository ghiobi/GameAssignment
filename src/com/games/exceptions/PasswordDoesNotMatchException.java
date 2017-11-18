package com.games.exceptions;

import com.games.models.User;

public class PasswordDoesNotMatchException extends Exception {

	private User user;
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public PasswordDoesNotMatchException(User user) {
		this.user = user;
	}
	
	public User getUser() {
		return user;
	}
	
}
