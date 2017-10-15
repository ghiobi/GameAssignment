package com.games.data.mappers;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public interface Mapper<T> {
	
	public ArrayList<T> map(ResultSet set) throws SQLException;
	
}
