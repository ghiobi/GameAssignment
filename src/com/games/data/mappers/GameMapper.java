package com.games.data.mappers;

import com.games.models.Game;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * Maps a ResultSet to a Game Object
 */
public class GameMapper implements Mapper<Game> {

	public ArrayList<Game> map(ResultSet result) {
		final ArrayList<Game> list = new ArrayList<Game>();
		
		if (result != null) {
			try {
				while (result.next()) {
					final Game game = new Game();

					game.setGameId(result.getInt("id"));
					game.setGameName(result.getString("name"));
					game.setGameDescription(result.getString("game_description"));
					game.setConsole(result.getString("console"));
					game.setNumPlayers(result.getInt("num_player"));
					game.setCoop(result.getBoolean("coop"));
					game.setReleaseDate(result.getDate("release_date"));
					game.setDeveloper(result.getString("developer"));
					game.setPublisher(result.getString("publisher"));
					game.setFrontBoxArt(result.getString("front_box_art"));
					game.setBackBoxArt(result.getString("back_box_art"));
					game.setLogo(result.getString("logo"));
					game.setDeveloperLogo(result.getString("developer_logo"));
					game.setPrice(result.getInt("price"));
					game.setDiscount(result.getInt("discount"));
					
					String genre = result.getString("genre");
					if (genre != null) {
						game.setGenre(new ArrayList<String>(Arrays.asList(result.getString("genre").split("/\\s*,\\s*/"))));
					}
					
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
