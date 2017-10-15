package com.games.data;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.games.data.mappers.UserMapper;
import com.games.models.User;

public class UserTableGateway {
	
	private static UserTableGateway instance = null;
	
	private static UserMapper userMapper;
	
	private UserTableGateway() { 
		userMapper = new UserMapper();
	}
	
	public User getUserByEmail(String email) {
		
		final String sql = "SELECT * FROM users WHERE email='" + email + "'";
		
		try {
			ResultSet resultSet = getDatabaseConnection().createStatement().executeQuery(sql);
			return this.userMapper.map(resultSet).get(0);
		} catch(SQLException e) { 
			System.out.println(SQLException.class + ": thrown!");
		} catch(IndexOutOfBoundsException e) { 
			System.out.println(UserTableGateway.class + ":getUserByEmail() no user found!");
		} 
		return null;
	}
	
	protected Connection getDatabaseConnection () {
		try {
			return DatabaseConnection.getInstance();
		} catch (SQLException e) { }
		return null;
	}

	public static UserTableGateway getInstance() {
		if (UserTableGateway.instance == null) {
			instance = new UserTableGateway();
		}
		return instance;
	}
	
}
