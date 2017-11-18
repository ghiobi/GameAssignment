package com.games.controllers;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.games.exceptions.AccountIsLockedException;
import com.games.exceptions.PasswordDoesNotMatchException;
import com.games.models.User;
import com.games.services.AuthService;

/**
 * Servlet implementation class LoginController for loggin the user
 */
@WebServlet("/login")
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginController() {
        super();
    }
    
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		
		User user = null;
		try {
			user = getAuthService().authenticate(email, password);
		} catch (PasswordDoesNotMatchException e) {
			request.getSession().setAttribute("flashDanger", "You have " + (4 - e.getUser().getAttemptLogin()) + " attempts left!");
			response.sendRedirect("/Games/login.jsp");
			return;
		} catch (AccountIsLockedException e) {
			request.getSession().setAttribute("flashDanger", "Your account has been locked for 24h!");
			response.sendRedirect("/Games/login.jsp");
			return;
		}
		
		if (user == null) {
			request.getSession().setAttribute("flashDanger", "Wrong credentials, please try again.");
			response.sendRedirect("/Games/login.jsp");
			return;
		}
		
		request.getSession().setAttribute("user", user);
		response.sendRedirect("/Games/index.jsp");
	}
	
	protected AuthService getAuthService() {
		return AuthService.getInstance();
	}
	
	
}
