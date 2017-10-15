package com.games.data.mappers;

import com.games.models.Game;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class GameMapper implements Mapper<Game> {

	public ArrayList<Game> map(ResultSet reset) throws SQLException
	{
		final ArrayList<Game> list = new ArrayList<Game>();

		while (reset.next()) {

		}

		return list;
	}
}
