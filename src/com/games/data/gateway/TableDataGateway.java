package com.games.data.gateway;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;

import com.games.data.DatabaseConnection;

public abstract class TableDataGateway {

	protected ResultSet executeQuery(String sql) {
		try {
			return DatabaseConnection.getInstance().createStatement().executeQuery(sql);
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return null;
	}
	
	protected int executeUpdate (String sql) {
		try {
			return DatabaseConnection.getInstance().createStatement().executeUpdate(sql);
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return 0;
	}
	
	protected Timestamp getCurrentTimeAndAddMillis(long millis) {
		return new Timestamp(System.currentTimeMillis() + millis);
	}
	
	protected Timestamp getCurrentTime() {
		return new Timestamp(System.currentTimeMillis());
	}
	
}
