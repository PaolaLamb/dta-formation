package fr.pizzeria.admin.web.controller;

import java.io.IOException;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.pizzeria.admin.metier.PizzaService;

@WebServlet("/pizzas/delete")
public class SupprimerPizzaController extends HttpServlet {
	@Inject
	private PizzaService pizzaService;
	private String code;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		this.code = (String) request.getParameter("code");
		pizzaService.delete(this.code);

		response.sendRedirect(request.getContextPath() + "/pizzas/list");
	}
}