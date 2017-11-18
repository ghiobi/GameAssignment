package com.games.controllers;

import java.io.IOException;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.games.models.User;
import com.games.services.AuthService;
import com.games.services.MailService;

/**
 * Servlet implementation class ResetPasswordController
 */
@WebServlet("/request_reset_password")
public class RequestResetPasswordController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RequestResetPasswordController() {
        super();
        // TODO Auto-generated constructor stub
    }
    
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String email = request.getParameter("email");
		
		User user = getAuthService().getUserByEmail(email);
		
		if (user != null) {
			String token = getRandomString(168);
			
			getAuthService().setResetToken(user, token);
			getMailService().send(user.getEmail(), "GameShop: Reset your account password!", 
					"<a href='http://localhost:8080/Games/request_reset_password?token=" + token + "' target='_blank'>Click here</a> to reset you password!");
		}
		
		request.getSession().setAttribute("flashSuccess", "An email has been sent to " + email + "!");
		response.sendRedirect("login.jsp");
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String token = request.getParameter("token");
		
		if (token == null) {
			sendFailedReset(request, response);
			return;
		}
		
		User user = getAuthService().getUserByResetToken(token);
		if (user == null) {
			sendFailedReset(request, response);
			return;
		}

		request.setAttribute("token", token);
		request.getServletContext().getRequestDispatcher("/WEB-INF/reset_password.jsp").include(request, response);
	}

	protected AuthService getAuthService() {
		return AuthService.getInstance();
	}
	
	protected MailService getMailService() {
		return MailService.getInstance();
	}
	
	protected void sendFailedReset(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException  {
		request.getSession().setAttribute("flashDanger", "Reseting password has expired!");
		response.sendRedirect("login.jsp");
	}
	
	protected String getRandomString(int length) {
        String SALTCHARS = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz1234567890";
        StringBuilder salt = new StringBuilder();
        Random rnd = new Random();
        while (salt.length() < length) { 
            int index = (int) (rnd.nextFloat() * SALTCHARS.length());
            salt.append(SALTCHARS.charAt(index));
        }
        return salt.toString();
    }
}
