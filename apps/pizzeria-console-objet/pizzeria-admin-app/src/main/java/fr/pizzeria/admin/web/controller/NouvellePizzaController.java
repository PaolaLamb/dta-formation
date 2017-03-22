package fr.pizzeria.admin.web.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.pizzeria.admin.tool.PizzaTool;
import fr.pizzeria.dao.DaoPizza;
import fr.pizzeria.exception.SaveException;
import fr.pizzeria.model.CategoriePizza;
import fr.pizzeria.model.Pizza;

public class NouvellePizzaController extends HttpServlet {
	private static final String NEW_PIZZA_VIEW = "/WEB-INF/views/pizzas/nouvellePizza.jsp";
	DaoPizza<Pizza, String> dao = PizzaTool.DAO_PIZZA;;

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
		String categorie = request.getParameter("categorie").toUpperCase();
		Pizza pizza = new Pizza(code, nom, Double.valueOf(prix), CategoriePizza.valueOf(categorie));
		try {
			dao.saveNew(pizza);
		} catch (SaveException e) {
			response.setStatus(400);
			request.setAttribute("errorMsg", e.getMessage());
			request.setAttribute("pizza", pizza);
			RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher(NEW_PIZZA_VIEW);
			dispatcher.forward(request, response);
		}

		response.sendRedirect(request.getContextPath() + "/pizzas/list");

	}

}
