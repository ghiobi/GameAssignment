package com.games.services;

import java.sql.Timestamp;

import javax.servlet.http.HttpServletRequest;

import com.games.data.gateway.UserTableGateway;
import com.games.exceptions.PasswordDoesNotMatchException;
import com.games.exceptions.AccountIsLockedException;
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
	
	public User getUserByEmail(String email) {
		return getUserGateway().getUserByEmail(email);
	}
	
	public User getUserByResetToken(String token) {
		return getUserGateway().getUserByResetToken(token);
	}
	
	/**
	 * Authenticates the user.
	 * @param email
	 * @param password
	 * @return
	 * @throws PasswordDoesNotMatchException 
	 */
	public User authenticate(String email, String password) throws PasswordDoesNotMatchException, AccountIsLockedException{
		User user = getUserGateway().getUserByEmail(email);
		
		if (user == null) {
			return null;
		}
		
		if (!user.getPassword().equals(password)) {
			if (user.getLastAttemptLogin() == null) {
				getUserGateway().setAttempt(user, 1);
			} else if (isAccountLocked(user)) {
				throw new AccountIsLockedException(user);
			} else if (user.getLastAttemptLogin().after(new Timestamp(System.currentTimeMillis() - 120000))) {
				getUserGateway().setAttempt(user, user.getAttemptLogin() + 1);
			} else {
				getUserGateway().setAttempt(user, 1);
			}
			throw new PasswordDoesNotMatchException(user);
		}
		
		recordLastLogin(user);
		return user;
	}
	
	public boolean isAccountLocked(User user) {
		return user.getAttemptLogin() >= 3 && user.getLastAttemptLogin().after(new Timestamp(System.currentTimeMillis() - 86400000));
	}
	
	public void recordLastLogin(User user) {
		getUserGateway().recordLastLogin(user);
	}
	
	public void setResetToken(User user, String token) {
		getUserGateway().setResetToken(user, token);
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
	
	public void updateUser(User user) {
		getUserGateway().updateUser(user);
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
