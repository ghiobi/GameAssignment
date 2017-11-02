package com.games.data.mappers;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.games.models.User;

/**
 * Maps a ResultSet to a user Object.
 * @author i861632
 *
 */
public class UserMapper implements Mapper<User> {
	
	public ArrayList<User> map(ResultSet result) {

		final ArrayList<User> list = new ArrayList<User>();

		if (result != null) {
			try {
				while(result.next()) {
					final User user = new User();

					user.setUserId(result.getInt("userid"));
					user.setFirstName(result.getString("firstname"));
					user.setLastName(result.getString("lastname"));
					user.setEmail(result.getString("email"));
					user.setPassword(result.getString("password"));
					user.setAddress1(result.getString("address1"));
					user.setAddress2(result.getString("address2"));
					user.setCity(result.getString("city"));
					user.setState(result.getString("state"));

					list.add(user);
				}
			} catch (SQLException e) {
				System.out.println(e.getMessage());
			}
		}

		return list;
	}
	
	public User mapOne(ResultSet result) {
		ArrayList<User> list = map(result);
		if (list.isEmpty()) {
			return null;
		}
		return list.get(0);
	}
	
}
