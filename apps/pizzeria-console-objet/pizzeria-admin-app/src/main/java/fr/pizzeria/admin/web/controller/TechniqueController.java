package fr.pizzeria.admin.web.controller;

import java.io.IOException;
import java.util.List;

import javax.inject.Inject;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.pizzeria.admin.event.EventPizza;

@WebServlet("/technique")
public class TechniqueController extends HttpServlet {

	@Inject
	private List<EventPizza> creationEvent;
	@Inject
	private List<EventPizza> modifEvent;
	@Inject
	private List<EventPizza> supprEvent;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		Integer compteur = (Integer) request.getSession().getServletContext().getAttribute("compteur");

		request.setAttribute("compteur", compteur);
		request.setAttribute("listEventCreation", creationEvent);
		request.setAttribute("listEventModif", modifEvent);
		request.setAttribute("listEventSuppr", supprEvent);

		RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher("/WEB-INF/views/technique.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

}
