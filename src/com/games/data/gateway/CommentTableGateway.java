package com.games.data.gateway;

import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.ArrayList;

import com.games.data.mappers.CommentMapper;
import com.games.models.Comment;
import com.games.models.Game;
import com.games.models.User;

public class CommentTableGateway extends TableDataGateway {

	private static CommentTableGateway instance = null;
	private CommentMapper commentMapper;
	
	private CommentTableGateway() {
		commentMapper = new CommentMapper();
	}
	
	public ArrayList<Comment> getCommentByGameId(int id) {
		String sql = "SELECT * from comments WHERE game_id=" + id + ";";
		ResultSet result = executeQuery(sql);
		
		return commentMapper.map(result);
	}

	public Comment createComment(Game game, User user, Timestamp date, String comment) {
		String sql = "INSERT INTO comments (user_id, game_id, comment_date, comment_details) VALUES (" + user.getUserId() + ", " + game.getGameId() + ", "
				+ "'" + date.toString() + "', '" + comment + "')";
		
		Comment object = new Comment();
		
		object.setUserId(user.getUserId());
		object.setGameId(game.getGameId());
		object.setCommentDate(date);
		object.setCommentDetails(comment);
		object.setCommentId(executeUpdate(sql)); 
		
		return object;
	}
	
	public static CommentTableGateway getInstance() {
		if (instance == null) {
			instance = new CommentTableGateway();
		}
		return instance;
	}
}
