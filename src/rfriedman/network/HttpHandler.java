package rfriedman.network;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.eclipse.jetty.server.Request;
import org.eclipse.jetty.server.handler.AbstractHandler;

import rfriedman.paint.Canvas;

public class HttpHandler extends AbstractHandler {

	@Override
	public void handle(String target, Request baseRequest,
			HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		boolean create = "true".equals(request.getParameter("create"));

		String user = request.getParameter("user");
		String pwd = request.getParameter("pwd");
		ServletContext context = request.getServletContext();
		HttpSession s=baseRequest.getSession();
		
		response.setContentType("text/html; charset=utf-8");
		response.setStatus(HttpServletResponse.SC_OK);
		response.getWriter().println("<h1>Hello World</h1>");
		request.setAttribute("myCanvas", new Canvas(800, 900));

		response.getWriter().println(
				((Canvas) request.getAttribute("myCanvas")).getPaintColor());

		baseRequest.setHandled(true);

	}

}
