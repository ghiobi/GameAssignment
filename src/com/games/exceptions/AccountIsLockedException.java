package com.games.exceptions;

import com.games.models.User;

public class AccountIsLockedException extends Exception {

	private User user;
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L; 

	public AccountIsLockedException(User user) {
		this.user = user;
	}
	
	public User getUser() {
		return user;
	}
	
}
