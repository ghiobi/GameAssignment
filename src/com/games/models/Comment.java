package com.games.models;

import java.sql.Timestamp;

/**
 * Object containing the comment model
 */
public class Comment {

	private int commentid;
	private int userid;
	private int gameid;
	private Timestamp commentDate;
	private String commentDetails;
	private int ratings;
	
	public int getCommentId() {
		return commentid;
	}
	public void setCommentId(int commentid) {
		this.commentid = commentid;
	}
	public int getUserId() {
		return userid;
	}
	public void setUserId(int userid) {
		this.userid = userid;
	}
	public int getGameId() {
		return gameid;
	}
	public void setGameId(int gameid) {
		this.gameid = gameid;
	}
	public Timestamp getCommentDate() {
		return commentDate;
	}
	public void setCommentDate(Timestamp date) {
		this.commentDate = date;
	}
	public String getCommentDetails() {
		return commentDetails;
	}
	public void setCommentDetails(String commentDetails) {
		this.commentDetails = commentDetails;
	}
	public int getRatings() {
		return ratings;
	}
	public void setRatings(int commentRatings) {
		this.ratings = commentRatings;
	}
	
}
