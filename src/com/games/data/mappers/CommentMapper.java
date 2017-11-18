package com.games.data.mappers;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.games.models.Comment;

/**
 * Maps a result set to a Comment Object.
 */
public class CommentMapper  implements Mapper<Comment> {

	public ArrayList<Comment> map(ResultSet result) {
		final ArrayList<Comment> list = new ArrayList<Comment>();
		
		if (result != null) {
			try {
				while(result.next()) {
					Comment comment = new Comment();
					
					comment.setCommentId(result.getInt("id"));
					comment.setGameId(result.getInt("game_id"));
					comment.setUserId(result.getInt("user_id"));
					comment.setCommentDate(result.getTimestamp("comment_date"));
					comment.setCommentDetails(result.getString("comment_details"));
					comment.setRatings(result.getInt("ratings"));
					
					list.add(comment);
				}
			} catch (SQLException e) {
				System.out.println(e.getMessage());
			}
		}
		
		return list;
	}
	
	public Comment mapOne(ResultSet result) {
		ArrayList<Comment> list = map(result);
		
		if (list.isEmpty()) {
			return null;
		}
		
		return list.get(0);
	}
}
