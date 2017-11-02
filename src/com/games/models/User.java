package com.games.models;

/**
 * Object containing the User model.
 *
 */
public class User {

	private int userid;
	private String firstname;
	private String lastname;
	private String email;
	private String password;
	private String address1;
	private String address2;
	private String city;
	private String state;
	private String zip;
	private String country;
	private String creditCardType;
	private String creditCardNumber;
	private String creditCardCvv;
	private String creditCardExpiry;
	
	public int getUserId() {
		return userid;
	}
	public void setUserId(int userid) {
		this.userid = userid;
	}
	public String getFirstName() {
		return firstname;
	}
	public void setFirstName(String firstname) {
		this.firstname = firstname;
	}
	public String getLastName() {
		return lastname;
	}
	public void setLastName(String lastname) {
		this.lastname = lastname;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getAddress1() {
		return address1;
	}
	public void setAddress1(String address1) {
		this.address1 = address1;
	}
	public String getAddress2() {
		return address2;
	}
	public void setAddress2(String address2) {
		this.address2 = address2;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getZip() {
		return zip;
	}
	public void setZip(String zip) {
		this.zip = zip;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getCreditCardType() {
		return creditCardType;
	}
	public void setCreditCardType(String credit_card_type) {
		this.creditCardType = credit_card_type;
	}
	public String getCreditCardNumber() {
		return creditCardNumber;
	}
	public void setCreditCardNumber(String credit_card_number) {
		this.creditCardNumber = credit_card_number;
	}
	public String getCreditCardCvv() {
		return creditCardCvv;
	}
	public void setCreditCardCvv(String credit_card_cvv) {
		this.creditCardCvv = credit_card_cvv;
	}
	public String getCreditCardExpiry() {
		return creditCardExpiry;
	}
	public void setCreditCardExpiry(String credit_card_expiry) {
		this.creditCardExpiry = credit_card_expiry;
	}
	
	
	
}
