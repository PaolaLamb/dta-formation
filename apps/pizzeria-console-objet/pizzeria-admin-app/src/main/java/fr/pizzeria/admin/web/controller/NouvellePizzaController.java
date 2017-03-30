package fr.pizzeria.admin.web.controller;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.inject.Inject;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.pizzeria.admin.metier.PizzaService;
import fr.pizzeria.exception.SaveException;
import fr.pizzeria.model.CategoriePizza;
import fr.pizzeria.model.Pizza;

@WebServlet("/pizzas/new")
public class NouvellePizzaController extends HttpServlet {
	private static final String NEW_PIZZA_VIEW = "/WEB-INF/views/pizzas/nouvellePizza.jsp";
	@Inject
	private PizzaService pizzaService;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher(NEW_PIZZA_VIEW);
		dispatcher.forward(request, response);

	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String code = request.getParameter("reference");
		String nom = request.getParameter("libelle");
		String prix = request.getParameter("prix");
		String categorie = request.getParameter("radios").toUpperCase();

		Pizza pizza = new Pizza(code, nom, Double.parseDouble(prix), CategoriePizza.valueOf(categorie));
		try {
			pizzaService.saveNew(pizza);
		} catch (SaveException e) {
			Logger.getAnonymousLogger().log(Level.SEVERE, "Problème lors de la sauvegarde de la nouvelle pizza");
			response.setStatus(400);
			request.setAttribute("errorMsg", e.getMessage());
			request.setAttribute("pizza", pizza);
			RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher(NEW_PIZZA_VIEW);
			dispatcher.forward(request, response);
		}

		response.sendRedirect(request.getContextPath() + "/pizzas/list");

	}

}
