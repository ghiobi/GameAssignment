package com.games.models;

import java.sql.Date;
import java.util.ArrayList;

/**
 * Object containing the Game model
 *
 */
public class Game {

	private int gameid;
	private String gamename;
	private String gameDescription;
	private String console;
	private int numPlayers;
	private boolean coop;
	private ArrayList<String> genre;
	private Date releaseDate;
	private String developer;
	private String publisher;
	private String frontBoxArt;
	private String backBoxArt;
	private String logo;
	private String developerLogo;
	private int price;
	private int discount;
	
	public int getGameId() {
		return gameid;
	}
	public void setGameId(int gameid) {
		this.gameid = gameid;
	}
	public String getGameName() {
		return gamename;
	}
	public void setGameName(String gamename) {
		this.gamename = gamename;
	}
	public String getGameDescription() {
		return gameDescription;
	}
	public void setGameDescription(String game_description) {
		this.gameDescription = game_description;
	}
	public String getConsole() {
		return console;
	}
	public void setConsole(String console) {
		this.console = console;
	}
	public int getNumPlayers() {
		return numPlayers;
	}
	public void setNumPlayers(int num_players) {
		this.numPlayers = num_players;
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
	public Date getReleaseDate() {
		return releaseDate;
	}
	public void setReleaseDate(Date release_date) {
		this.releaseDate = release_date;
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
	public String getFrontBoxArt() {
		return frontBoxArt;
	}
	public void setFrontBoxArt(String front_box_art) {
		this.frontBoxArt = front_box_art;
	}
	public String getBackBoxArt() {
		return backBoxArt;
	}
	public void setBackBoxArt(String back_box_art) {
		this.backBoxArt = back_box_art;
	}
	public String getLogo() {
		return logo;
	}
	public void setLogo(String logo) {
		this.logo = logo;
	}
	public String getDeveloperLogo() {
		return developerLogo;
	}
	public void setDeveloperLogo(String developer_logo) {
		this.developerLogo = developer_logo;
	}
	public int getGameid() {
		return gameid;
	}
	public void setGameid(int gameid) {
		this.gameid = gameid;
	}
	public String getGamename() {
		return gamename;
	}
	public void setGamename(String gamename) {
		this.gamename = gamename;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public int getDiscount() {
		return discount;
	}
	public void setDiscount(int discount) {
		this.discount = discount;
	}
	
}
