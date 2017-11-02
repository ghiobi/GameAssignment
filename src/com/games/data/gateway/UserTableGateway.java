package com.games.data.gateway;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.games.data.DatabaseConnection;
import com.games.data.mappers.UserMapper;
import com.games.models.User;

public class UserTableGateway extends TableDataGateway {
	
	private static UserTableGateway instance = null;
	
	private UserMapper userMapper;
	
	private UserTableGateway() { 
		userMapper = new UserMapper();
	}
	
	public User getUserByEmail(String email) {
		
		final String sql = "SELECT * FROM users WHERE email='" + email + "';";

		ResultSet resultSet = executeQuery(sql);
		return userMapper.mapOne(resultSet);
	}
	
	public User getUserById(int id) {
		final String sql = "Select * from users WHERE userid=" + id + ";";
		
		ResultSet resultSet = executeQuery(sql);
		return userMapper.mapOne(resultSet);
	}
	
	public User insertUser(User user) {
		final String sql = "INSERT INTO users (firstname, lastname, email, password, address1, address2, city, state, country) "
				+ "VALUES ('" + user.getFirstName()  + "', '" +  user.getLastName() + "', '" + user.getEmail() + "', "
				+ "'" + user.getPassword() + "', '" + user.getAddress1() + "', '" + user.getAddress2() + "', "
				+ "'" + user.getCity() + "', '" + user.getState() + "', '" + user.getCountry() + "');";
	
		user.setUserId(executeUpdate(sql)); 
		return user;
	}

	public static UserTableGateway getInstance() {
		if (UserTableGateway.instance == null) {
			instance = new UserTableGateway();
		}
		return instance;
	}
	
}
