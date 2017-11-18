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
 * Servlet implementation class RegisterController for user registration
 */
@WebServlet("/register")
public class RegisterController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegisterController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String firstname = request.getParameter("firstname");
		String lastname = request.getParameter("lastname");
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		String address1 = request.getParameter("address1");
		String address2 = request.getParameter("address2");
		String city = request.getParameter("city");
		String state = request.getParameter("state");
		String zip = request.getParameter("zip");
		String country = request.getParameter("country");
		
		String errors = "";
		if (firstname == null) {
			errors += "First Name ";
		}
		if (lastname == null) {
			errors += "Last Name ";
		}
		if (email == null) {
			errors += "Email ";
		}
		if (password == null) {
			errors += "Password ";
		}
		if (address1 == null) {
			errors += "Address 1 ";
		}
		if (city == null) {
			errors += "City ";
		}
		if (state == null) {
			errors += "State ";
		}
		if (zip == null) {
			errors += "Zip ";
		}
		if (country == null) {
			errors += "Country ";
		}
		
		if (!errors.isEmpty()) {
			request.getSession().setAttribute("flashDanger", "Please fill the required fields: " + errors);
			response.sendRedirect("register.jsp");
			return;
		}
		
		User user = new User();
		
		user.setFirstName(firstname);
		user.setLastName(lastname);
		user.setEmail(email);
		user.setPassword(password);
		user.setAddress1(address1);
		user.setAddress2(address2);
		user.setCity(city);
		user.setState(state);
		user.setZip(zip);
		user.setCountry(country);

		if (getAuthService().register(user) == null) {
			request.getSession().setAttribute("flashDanger","Email is already registered.");
			response.sendRedirect("register.jsp");
			return;
		}
		
		
		request.getSession().setAttribute("flashSuccess", "Thanks for registering " + user.getFirstName() + "!");
		response.sendRedirect("login.jsp");
	}
	
	protected AuthService getAuthService() {
		return AuthService.getInstance();
	}

}
