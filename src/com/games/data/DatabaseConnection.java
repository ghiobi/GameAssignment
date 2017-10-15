package com.games.data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
	
	private static Connection instance = null;
	
	public static Connection getInstance() {
		
		if (instance == null) {
			try {
				
				Class.forName("com.mysql.jdbc.Driver");
				instance = DriverManager.getConnection("jdbc:mysql://localhost:3306/games", "root", "");
				
			} catch(ClassNotFoundException e) {
				System.out.println("The class cannot be found: " + e.getMessage());
			} catch (SQLException e) { 
				System.out.println(e.getMessage());
			} finally {
				if(instance == null) {
					System.out.println("Error loading driver!");
					System.exit(1);
				}
			}
		}
		
		return DatabaseConnection.instance;
	}
	
}
