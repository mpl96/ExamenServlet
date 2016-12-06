package Servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.*;

public class ServletDelete extends HttpServlet {

private Services service = new Services();
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String language = req.getParameter("dates");
		req.setAttribute("idioma",language);
		service.DeleteLanguage(language);
		redirect(resp);
	}

	private void redirect(HttpServletResponse resp) throws IOException {
		resp.sendRedirect("dates.jsp");
	}
	
}
