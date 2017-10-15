package com.games.models;

import java.util.ArrayList;

public class Game {

	private int gameid;
	private String game_description;
	private String console;
	private int num_players;
	private boolean coop;
	private ArrayList<String> genre;
	private String release_date;
	private String developer;
	private String publisher;
	private String front_box_art;
	private String back_box_art;
	private String logo;
	private String developer_logo;
	private String comments;
	
	public int getGameid() {
		return gameid;
	}
	public void setGameid(int gameid) {
		this.gameid = gameid;
	}
	public String getGame_description() {
		return game_description;
	}
	public void setGame_description(String game_description) {
		this.game_description = game_description;
	}
	public String getConsole() {
		return console;
	}
	public void setConsole(String console) {
		this.console = console;
	}
	public int getNum_players() {
		return num_players;
	}
	public void setNum_players(int num_players) {
		this.num_players = num_players;
	}
	public boolean isCoop() {
		return coop;
	}
	public void setCoop(boolean coop) {
		this.coop = coop;
	}
	public ArrayList<String> getGenre() {
		return genre;
	}
	public void setGenre(ArrayList<String> genre) {
		this.genre = genre;
	}
	public String getRelease_date() {
		return release_date;
	}
	public void setRelease_date(String release_date) {
		this.release_date = release_date;
	}
	public String getDeveloper() {
		return developer;
	}
	public void setDeveloper(String developer) {
		this.developer = developer;
	}
	public String getPublisher() {
		return publisher;
	}
	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}
	public String getFront_box_art() {
		return front_box_art;
	}
	public void setFront_box_art(String front_box_art) {
		this.front_box_art = front_box_art;
	}
	public String getBack_box_art() {
		return back_box_art;
	}
	public void setBack_box_art(String back_box_art) {
		this.back_box_art = back_box_art;
	}
	public String getLogo() {
		return logo;
	}
	public void setLogo(String logo) {
		this.logo = logo;
	}
	public String getDeveloper_logo() {
		return developer_logo;
	}
	public void setDeveloper_logo(String developer_logo) {
		this.developer_logo = developer_logo;
	}
	public String getComments() {
		return comments;
	}
	public void setComments(String comments) {
		this.comments = comments;
	}
	
}
