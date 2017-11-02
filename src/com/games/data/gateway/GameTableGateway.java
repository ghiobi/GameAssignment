package com.games.data.gateway;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.games.data.DatabaseConnection;
import com.games.data.mappers.GameMapper;
import com.games.models.Game;

public class GameTableGateway extends TableDataGateway {
	
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
	
	public ArrayList<Game> getAllGames() {
		final String sql = "SELECT * FROM games";
		
		ResultSet result = executeQuery(sql);
		return gameMapper.map(result);
	}
	
	public ArrayList<Game> getSpecials() {
		final String sql = "SELECT * FROM games WHERE discount IS NOT NULL AND discount <> 0";
		
		ResultSet result = executeQuery(sql);
		return gameMapper.map(result);
	}
	
	public ArrayList<Game> getGamesByNameConsolePublisherGenre(String title, String console, String publisher, String  genre) {
		String sql = "SELECT * FROM games WHERE name LIKE '%" + title  + "%' ";
		
		if (console != null) {
			sql += "AND console='" + console + "' ";
		}
		if (publisher != null) {
			sql += "AND publisher='" + publisher + "' ";
		}
		if (genre != null) {
			sql += "AND genre LIKE '%" + genre + "%' ";
		}
		
		ResultSet result = executeQuery(sql);
		return gameMapper.map(result);
	}
	
	public static GameTableGateway getInstance() {
		if (instance == null) {
			instance = new GameTableGateway();
		}
		return instance;
	}

}
