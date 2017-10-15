package com.games.data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
	
	private static Connection instance = null;
	
	public static Connection getInstance() throws SQLException {
		
		if (DatabaseConnection.instance == null) {
			try {
				Class.forName("com.mysql.jdbc.Driver").newInstance();
			} catch (ClassNotFoundException|InstantiationException|IllegalAccessException e) {
				System.out.println("Could not find class: com.mysql.jdbc.Driver");
				System.exit(1);
			}
			DatabaseConnection.instance = DriverManager.getConnection("jsbc:mysql//dumbledore.encs.concordia.ca/user=laurendy_lam&password=s8bX359EiAz0HSDP");
		}
		
		return DatabaseConnection.instance;
	}
	
}
