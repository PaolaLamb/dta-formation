package fr.pizzeria.admin.web;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.pizzeria.dao.DaoPizza;
import fr.pizzeria.dao.PizzaDaoImplArray;
import fr.pizzeria.model.Pizza;

/**
 * Servlet implementation class ListerPizzaController
 */
public class ListerPizzaController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	DaoPizza<Pizza, String> dao;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ListerPizzaController() {
		this.dao = new PizzaDaoImplArray();

	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setAttribute("listPizzas", dao.findAll());

		RequestDispatcher dispatcher = this.getServletContext()
				.getRequestDispatcher("/WEB-INF/views/pizzas/listerPizzas.jsp");
		dispatcher.forward(request, response);

	}

}
