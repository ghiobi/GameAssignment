package com.games.data.gateway;

import java.sql.ResultSet;
import java.sql.Timestamp;

import com.games.data.mappers.UserMapper;
import com.games.models.User;

public class UserTableGateway extends TableDataGateway {
	
	private static UserTableGateway instance = null;
	
	private UserMapper userMapper;
	
	private UserTableGateway() { 
		userMapper = new UserMapper();
	}

	public User getUserById(int id) {
		final String sql = "Select * from users WHERE userid=" + id + ";";
		
		ResultSet resultSet = executeQuery(sql);
		return userMapper.mapOne(resultSet);
	}

	public User getUserByEmail(String email) {
		
		final String sql = "SELECT * FROM users WHERE email='" + email + "';";

		ResultSet resultSet = executeQuery(sql);
		return userMapper.mapOne(resultSet);
	}
	
	public User getUserByResetToken(String token) {
		final String sql = "SELECT * FROM users WHERE reset_token='" + token + "' AND "
				+ "reset_token_expiry > '" + getCurrentTimeAndAddMillis(-86400000).toString() + "';";

		ResultSet resultSet = executeQuery(sql);
		return userMapper.mapOne(resultSet);
	}
	
	public User insertUser(User user) {
		final String sql = "INSERT INTO users (firstname, lastname, email, password, address1, address2, city, state, country, credit_card_number, credit_card_type, credit_card_expiry, credit_card_cvv) "
				+ "VALUES ('" + user.getFirstName()  + "', '" +  user.getLastName() + "', '" + user.getEmail() + "', "
				+ "'" + user.getPassword() + "', '" + user.getAddress1() + "', '" + user.getAddress2() + "', "
				+ "'" + user.getCity() + "', '" + user.getState() + "', '" + user.getCountry() + "', '" + user.getCreditCardNumber() + "', "
				+ "'" +user.getCreditCardType()+ "', '" +user.getCreditCardExpiry()+ "', '" + user.getCreditCardCvv() + "');";
	
		user.setUserId(executeUpdate(sql)); 
		return user;
	}
	
	public void updateUser(User user) {
		final String sql = "UPDATE users SET firstname='" + user.getFirstName() +  "', lastname='" + user.getLastName() + "', email='" + user.getEmail() + "', "
				+ "password='" + user.getPassword() + "', address1='" + user.getAddress1() + "', address2='" + user.getAddress2() + "', "
				+ "city='" + user.getCity() + "', state='" + user.getState() + "', country='" + user.getCountry() + "', credit_card_number='" + user.getCreditCardNumber() + "', "
				+ "credit_card_type='" + user.getCreditCardType() + "', credit_card_expiry='" + user.getCreditCardExpiry() + "', "
				+ "credit_card_cvv='" + user.getCreditCardCvv() + "' WHERE userid=" + user.getUserId() + ";";

		executeUpdate(sql);
	}
	
	public void recordLastLogin(User user) {
		Timestamp date = getCurrentTime();
		final String sql = "UPDATE users SET last_login='" + date.toString()  + "', last_attempt_login=NULL, attempt_login=NULL, "
				+ "reset_token=NULL, reset_token_expiry=NULL WHERE userid=" + user.getUserId();
		
		executeUpdate(sql);
	}
	
	public void setAttempt(User user, int attempt) {
		Timestamp date = getCurrentTime();
		final String sql = "UPDATE users SET last_attempt_login='" + date.toString() + "', attempt_login=" + attempt + " WHERE userid=" + user.getUserId();
		
		user.setAttemptLogin(attempt);
		user.setLastAttemptLogin(date);
		executeUpdate(sql);
	}

	public void setResetToken(User user, String token) {
		final String sql = "UPDATE users SET reset_token_expiry='" +  getCurrentTimeAndAddMillis(86400000).toString()  + "', "
				+ "reset_token='" + token + "' WHERE userid=" + user.getUserId();
		
		executeUpdate(sql);
	}
	
	public static UserTableGateway getInstance() {
		if (UserTableGateway.instance == null) {
			instance = new UserTableGateway();
		}
		return instance;
	}
	
}
