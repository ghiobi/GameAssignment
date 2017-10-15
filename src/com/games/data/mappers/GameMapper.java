package com.games.data.mappers;

import com.games.models.Game;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class GameMapper implements Mapper<Game> {

	public ArrayList<Game> map(ResultSet result) {
		final ArrayList<Game> list = new ArrayList<Game>();
		
		if (result != null) {
			try {
				while (result.next()) {
					final Game game = new Game();

					game.setGameid(result.getInt("id"));
					game.setGame_description(result.getString("game_description"));
					
					list.add(game);
				}
			} catch (SQLException e) {
				System.out.println(e.getMessage());
			}
		}
		
		return list;
	}
	
	public Game mapOne(ResultSet result) {
		ArrayList<Game> list = map(result);
		
		if (list.isEmpty()) {
			return null;
		}
		
		return list.get(0);
	}
}
