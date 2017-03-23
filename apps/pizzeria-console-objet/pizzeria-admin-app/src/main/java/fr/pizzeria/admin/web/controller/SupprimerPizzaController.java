package fr.pizzeria.admin.web.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.pizzeria.admin.tool.PizzaTool;
import fr.pizzeria.dao.DaoPizza;
import fr.pizzeria.model.Pizza;

@WebServlet("/pizzas/delete")
public class SupprimerPizzaController extends HttpServlet {
	private DaoPizza<Pizza, String> dao = PizzaTool.DAO_PIZZA;;
	private String code;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		this.code = (String) request.getParameter("code");
		dao.delete(this.code);

		response.sendRedirect(request.getContextPath() + "/pizzas/list");
	}
}