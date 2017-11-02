package com.games.services;

import javax.servlet.http.HttpServletRequest;

import com.games.data.gateway.UserTableGateway;
import com.games.models.User;

/**
 * Handle business login on authentication.
 */
public class AuthService {

	private static AuthService instance = null;
	
	private AuthService() { }
	
	/**
	 * Gets the user by id
	 * @param id
	 * @return
	 */
	public User getUserById(int id) {
		return getUserGateway().getUserById(id);
	}
	
	/**
	 * Authenticates the user.
	 * @param email
	 * @param password
	 * @return
	 */
	public User authenticate(String email, String password) {
		User user = getUserGateway().getUserByEmail(email);
		
		if (user == null || !user.getPassword().equals(password)) {
			return null;
		}
		
		return user;
	}
	
	/**
	 * Checks of the response is authenticated
	 * @param request the HttpServletRequest
	 * @return
	 */
	public User isAuthenticated(HttpServletRequest request) {
		User user = (User) request.getSession().getAttribute("user");
		if (user == null) {
			return null;
		}
		return user;
	}
	
	/**
	 * Returns the registered user, if the email is not unique it will return null.
	 * @param user - the user to register
	 * @return user - null if the registration fails
	 */
	public User register(User user) {
		if (getUserGateway().getUserByEmail(user.getEmail()) != null) {
			return null;
		}
		return getUserGateway().insertUser(user);
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
