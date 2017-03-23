package fr.pizzeria.admin.web.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/login")
public class LoginController extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher("/WEB-INF/views/login.jsp");
		dispatcher.forward(request, response);

	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String userID = request.getParameter("userId");
		String password = request.getParameter("password");

		if ("admin".equals(userID) && "admin".equals(password)) {
			request.getSession().setAttribute("isConnected", "connected");
			response.sendRedirect(request.getContextPath() + "/pizzas/list");

		} else {
			request.setAttribute("erreur", "Mauvais identifiants");
			response.setStatus(400);
			RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher("/WEB-INF/views/login.jsp");
			dispatcher.forward(request, response);

		}
	}

}
