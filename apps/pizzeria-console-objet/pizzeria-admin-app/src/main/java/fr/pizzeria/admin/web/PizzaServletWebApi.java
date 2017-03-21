package fr.pizzeria.admin.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.pizzeria.dao.DaoPizza;
import fr.pizzeria.dao.PizzaDaoImplArray;
import fr.pizzeria.model.CategoriePizza;
import fr.pizzeria.model.Pizza;

/**
 * Servlet implementation class PizzaServletWebApi
 */
public class PizzaServletWebApi extends HttpServlet {
	private static final long serialVersionUID = 1L;
	DaoPizza<Pizza, String> dao;

	/**
	 * Default constructor.
	 */
	public PizzaServletWebApi() {
		this.dao = new PizzaDaoImplArray();

	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.getWriter().append(dao.findAll().toString());
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);

		String code = request.getParameter("code");
		String nom = request.getParameter("nom");
		String prix = request.getParameter("prix");
		String categorie = request.getParameter("categorie").toUpperCase();
		dao.saveNew(new Pizza(code, nom, Double.valueOf(prix), CategoriePizza.valueOf(categorie)));

		response.setStatus(201);
	}

}
