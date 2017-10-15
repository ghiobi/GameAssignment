package com.games.data.gateway;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.games.data.DatabaseConnection;
import com.games.data.mappers.GameMapper;
import com.games.models.Game;

public class GameTableGateway {
	
	private static GameTableGateway instance = null;
	
	private GameMapper gameMapper;
	
	private GameTableGateway() {
		gameMapper = new GameMapper();
	}
	
	public Game getGameById(int id) {
		final String sql = "SELECT * FROM games WHERE id=" + id;
		
		ResultSet result = executeQuery(sql);
		return gameMapper.mapOne(result);
	}
	
	public ResultSet executeQuery(String sql) {
		try {
			return DatabaseConnection.getInstance().createStatement().executeQuery(sql);
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return null;
	}
	
	public static GameTableGateway getInstance() {
		if (instance == null) {
			instance = new GameTableGateway();
		}
		return instance;
	}

}
