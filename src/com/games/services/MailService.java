package com.games.services;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class MailService {
	
	private static MailService instance = null;
	
	private MailService () { }
	
	/**
	 * Sends a message
	 * @param to
	 * @param subject
	 * @param body
	 */
	public void send(String to, String subject, String body) {
		
		final String username = "lamlaurendy@gmail.com";
		final String password = "vel0cityis45";

		Properties props = new Properties();
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.host", "smtp.gmail.com");
		props.put("mail.smtp.port", "587");

		Session session = Session.getInstance(props,
		  new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(username, password);
			}
		  });

		try {

			Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress("lamlaurendy@gmail.com"));
			message.setRecipients(Message.RecipientType.TO,
				InternetAddress.parse(to));
			message.setSubject(subject);
			message.setContent(body, "text/html; charset=utf-8");

			Transport.send(message);

		} catch (MessagingException e) {
			throw new RuntimeException(e);
		}
	}
	
	public static MailService getInstance() {
		if (instance == null) {
			instance = new MailService();
		}
		return instance;
	}
}
