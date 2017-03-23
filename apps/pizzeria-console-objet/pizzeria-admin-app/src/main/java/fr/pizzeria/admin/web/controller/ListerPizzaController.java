package fr.pizzeria.admin.web.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.pizzeria.admin.tool.PizzaTool;
import fr.pizzeria.dao.DaoPizza;
import fr.pizzeria.model.Pizza;

@WebServlet("/pizzas/list")
public class ListerPizzaController extends HttpServlet {
	private DaoPizza<Pizza, String> dao = PizzaTool.DAO_PIZZA;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		request.setAttribute("listPizzas", dao.findAll());

		RequestDispatcher dispatcher = this.getServletContext()
				.getRequestDispatcher("/WEB-INF/views/pizzas/listerPizzas.jsp");
		dispatcher.forward(request, response);

	}

}
