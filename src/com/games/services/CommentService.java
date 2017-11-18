package com.games.services;

import java.sql.Timestamp;
import java.util.ArrayList;

import com.games.data.gateway.CommentTableGateway;
import com.games.models.Comment;
import com.games.models.Game;
import com.games.models.User;

/**
 * Handles business login of getting comments from games. A singleton instance.
 */
public class CommentService {

	private static CommentService instance = null;
	
	private CommentService() { }
	
	/**
	 * Returns a list of comments by game id.
	 * @param id the game id
	 * @return
	 */
	public ArrayList<Comment> getCommentsGameById(int id) {
		return getCommentTableGateway().getCommentByGameId(id);
	}
	
	/**
	 * Creates a comment with the inputted parameters
	 * @param game the name object
	 * @param user the user
	 * @param comment the comment string
	 * @return
	 */
	public Comment createComment(Game game, User user, String comment) {
		Timestamp date = new Timestamp(System.currentTimeMillis());
		
		return CommentTableGateway.getInstance().createComment(game, user, date, comment);
	}
	
	protected CommentTableGateway getCommentTableGateway() {
		return CommentTableGateway.getInstance();
	}
	
	public static CommentService getInstance() {
		if (instance == null) {
			instance = new CommentService();
		}
		return instance;
	}
	
}
