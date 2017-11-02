package com.games.controllers;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
		
		User user = getAuthService().authenticate(email, password);
		
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
