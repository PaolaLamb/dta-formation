package fr.pizzeria.admin.web.filtre;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginFilter implements Filter {
	private FilterConfig config = null;
	private ServletContext context;

	@Override
	public void init(FilterConfig config) throws ServletException {
		this.config = config;
		config.getServletContext().log("Authentification initialisée");
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {

		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse res = (HttpServletResponse) response;

		if ("connected".equals(req.getSession().getAttribute("isConnected")) || "/login".equals(req.getServletPath())) {
			chain.doFilter(request, response);
		} else {
			res.sendRedirect(req.getContextPath() + "/login");
		}

	}

	@Override
	public void destroy() {

	}

}
