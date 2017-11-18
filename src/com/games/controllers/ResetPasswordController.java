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
 * Servlet implementation class ResetPasswordController
 */
@WebServlet("/reset_password")
public class ResetPasswordController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ResetPasswordController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String token = request.getParameter("token");
		String password = request.getParameter("password");
		
		if (password == null) {
			request.getSession().setAttribute("flashDanger", "Please enter a password!");
			response.sendRedirect(request.getHeader("Referer"));
			return;
		}
		
		User user = getAuthService().getUserByResetToken(token);
		if (user == null) {
			request.getRequestDispatcher("/WEB-INF/404.jsp").forward(request, response);
			return;
		}
		
		user.setPassword(password);
		getAuthService().updateUser(user);
		
		request.getSession().setAttribute("flashSuccess", "Your password has been resetted please sign in!");
		response.sendRedirect("login.jsp");
	}

	protected AuthService getAuthService() {
		return AuthService.getInstance();
	}
	
}
