package com.games.data.mappers;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.games.models.User;

public class UserMapper implements Mapper<User> {

	public ArrayList<User> map(ResultSet result) throws SQLException {

		final ArrayList<User> list = new ArrayList<User>();

		while(result.next()) {
			final User user = new User();

			user.setUserid(result.getInt("userid"));
			user.setFirstname(result.getString("firstname"));
			user.setLastname(result.getString("lastname"));
			user.setEmail(result.getString("email"));
			user.setPassword(result.getString("password"));
			user.setAddress1(result.getString("address1"));
			user.setAddress2(result.getString("address2"));
			user.setCity(result.getString("city"));
			user.setState(result.getString("state"));

			list.add(user);
		}

		return list;
	}
	
}
