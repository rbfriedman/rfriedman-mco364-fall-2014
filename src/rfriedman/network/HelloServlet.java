package rfriedman.network;

import java.awt.Color;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import rfriedman.paint.Canvas;

public class HelloServlet extends HttpServlet {
	private String greeting = "Hello World";

	public HelloServlet() {
	}

	public HelloServlet(String greeting) {
		this.greeting = greeting;
	}

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		response.setStatus(HttpServletResponse.SC_OK);
		response.getWriter().println("<h1>" + greeting + "</h1>");
		response.getWriter().println(
				"session=" + request.getSession(true).getId());
		Object user =request.getSession().getAttribute("user");
		request.getCookies();
		String c = request.getParameter("myCanvas");
		response.getWriter().println(c + user.toString());
		request.setAttribute("myCanvas", new Canvas(800, 900));
		
		response.getWriter().println(
				((Canvas) request.getAttribute("myCanvas")).getPaintColor());
	}

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String username = request.getParameter("username");

		request.getSession().setAttribute("user", "rena");
		response.sendRedirect("home");

		request.setAttribute("error", "Unknown user, please try again");

	}
}
