package com.games.services;

import com.games.data.gateway.GameTableGateway;
import com.games.models.Game;

public class GameService {

	public static GameService instance = null;
	
	private GameService() { }
	
	public Game getGameById(int id) {
		return getGameGetway().getGameById(id);
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
