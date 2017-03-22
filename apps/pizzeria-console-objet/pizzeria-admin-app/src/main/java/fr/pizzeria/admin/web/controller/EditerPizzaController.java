package fr.pizzeria.admin.web.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.pizzeria.admin.tool.PizzaTool;
import fr.pizzeria.dao.DaoPizza;
import fr.pizzeria.model.CategoriePizza;
import fr.pizzeria.model.Pizza;

/**
 * Servlet implementation class EditerPizzaController
 */
public class EditerPizzaController extends HttpServlet {
	DaoPizza<Pizza, String> dao;
	private String code;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public EditerPizzaController() {
		this.dao = PizzaTool.DAO_PIZZA;
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		List<Pizza> pizzas = dao.findAll();

		this.code = (String) request.getParameter("code");

		if (this.code != "null") {
			for (Pizza pizza : pizzas) {
				if (this.code.equals(pizza.getCode())) {
					request.setAttribute("pizza", pizza);
				}
			}
		}

		RequestDispatcher dispatcher = this.getServletContext()
				.getRequestDispatcher("/WEB-INF/views/pizzas/editerPizza.jsp");
		dispatcher.forward(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String codeN = request.getParameter("reference");
		String nom = request.getParameter("libelle");
		String prix = request.getParameter("prix");
		String categorie = request.getParameter("categorie").toUpperCase();
		dao.update(this.code, new Pizza(codeN, nom, Double.valueOf(prix), CategoriePizza.valueOf(categorie)));
		code = "";

		response.sendRedirect(request.getContextPath() + "/pizzas/list");
	}

}
