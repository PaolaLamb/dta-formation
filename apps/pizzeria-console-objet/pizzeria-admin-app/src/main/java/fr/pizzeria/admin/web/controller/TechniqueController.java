package fr.pizzeria.admin.web.controller;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

import javax.inject.Inject;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.pizzeria.admin.event.EventPizza;
import fr.pizzeria.admin.event.EventType;
import fr.pizzeria.admin.metier.PizzaStatistiquesService;

@WebServlet("/technique")
public class TechniqueController extends HttpServlet {

	@Inject
	PizzaStatistiquesService pizzaStats;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		Integer compteur = (Integer) request.getSession().getServletContext().getAttribute("compteur");

		List<EventPizza> events = pizzaStats.getPizzaEvents();

		List<EventPizza> creations = events.stream().filter(event -> event.getEventType().equals(EventType.CREATION))
				.collect(Collectors.toList());
		List<EventPizza> modifs = events.stream().filter(event -> event.getEventType().equals(EventType.MODIFICATION))
				.collect(Collectors.toList());
		List<EventPizza> supprs = events.stream().filter(event -> event.getEventType().equals(EventType.SUPPRESSION))
				.collect(Collectors.toList());

		request.setAttribute("compteur", compteur);
		request.setAttribute("listCreation", creations);
		request.setAttribute("listModifs", modifs);
		request.setAttribute("listSupprs", supprs);

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
