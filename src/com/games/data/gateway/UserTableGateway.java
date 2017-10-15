package com.games.data.gateway;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.games.data.DatabaseConnection;
import com.games.data.mappers.UserMapper;
import com.games.models.User;

public class UserTableGateway {
	
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
	
	protected ResultSet executeQuery (String sql) {
		try {
			return DatabaseConnection.getInstance().createStatement().executeQuery(sql);
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return null;
	}

	public static UserTableGateway getInstance() {
		if (UserTableGateway.instance == null) {
			instance = new UserTableGateway();
		}
		return instance;
	}
	
}
