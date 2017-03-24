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

import fr.pizzeria.admin.metier.PizzaService;
import fr.pizzeria.model.CategoriePizza;
import fr.pizzeria.model.Pizza;

@WebServlet("/pizzas/edit")
public class EditerPizzaController extends HttpServlet {
	@Inject
	private PizzaService pizzaService;
	private String code;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		List<Pizza> pizzas = pizzaService.findAll();

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
		String categorie = request.getParameter("radios").toUpperCase();
		System.out.println(codeN + nom + prix + categorie);

		pizzaService.update(this.code,
				new Pizza(codeN, nom, Double.parseDouble(prix), CategoriePizza.valueOf(categorie)));

		response.sendRedirect(request.getContextPath() + "/pizzas/list");
	}

}
