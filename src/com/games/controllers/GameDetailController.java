package com.games.controllers;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.games.models.Game;
import com.games.services.GameService;

/**
 * Servlet implementation class GameDetailController
 */
@WebServlet("/game")
public class GameDetailController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GameDetailController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		
		int id = 1;
		try {
			id =  Integer.parseInt(request.getParameter("id"));
		} catch (NumberFormatException e) {
			response.getWriter().append(e.getMessage());
			return;
		}
		
		Game game = GameService.getInstance().getGameById(id);
		
		if (game != null) {
			request.setAttribute("game", game);
			request.getServletContext().getRequestDispatcher("/game_detail.jsp").forward(request, response);;
		} else {
			System.out.println("Game with id not found: " + id);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
