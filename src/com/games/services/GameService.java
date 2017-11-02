package com.games.services;

import java.util.ArrayList;

import com.games.data.gateway.GameTableGateway;
import com.games.models.Game;

/**
 * Handles game business logic. A singleton instance;
 */
public class GameService {

	public static GameService instance = null;
	
	private GameService() { }
	
	/**
	 * Gets a game by id
	 * @param id the game id
	 * @return Game
	 */
	public Game getGameById(int id) {
		return getGameGetway().getGameById(id);
	}
	
	/**
	 * Gets all games in the database
	 * @return ArrayList<Game> 
	 */
	public ArrayList<Game> getAllGames() {
		return getGameGetway().getAllGames();
	}
	
	/**
	 * Gets all games that are on special
	 * @return ArrayList<Game> 
	 */
	public ArrayList<Game> getSpecials() {
		return getGameGetway().getSpecials();
	}
	
	/**
	 * Games all games that match the inputted paramaters.
	 * @param name the name of the game
	 * @param console the console 
	 * @param publisher the publisher
	 * @param genre the genre
	 * @return ArrayList<Game> 
	 */
	public ArrayList<Game> getGamesByNameConsolePublisherGenre(String name, String console, String publisher, String genre) {
		if (console.equals("ANY")) {
			console = null;
		}
		if (publisher.equals("ANY")) {
			publisher = null;
		}
		if (genre.equals("ANY")) {
			genre = null;
		}
		return getGameGetway().getGamesByNameConsolePublisherGenre(name, console, publisher, genre);
	}
	
	protected GameTableGateway getGameGetway() {
		return GameTableGateway.getInstance();
	}
	
	public static GameService getInstance() {
		if (instance == null) {
			instance = new GameService();
		}
		return instance;
	}
}
