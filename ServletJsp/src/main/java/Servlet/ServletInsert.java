package Servlet;

import java.io.IOException;
import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;


import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import repository.*;
import service.*;

public class ServletInsert extends HttpServlet {
	private Services service = new Services();

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String country = req.getParameter("pais");
		String language = req.getParameter("Idioma");
		String nLanguage = req.getParameter("nuevoIdioma");
		
		if(nLanguage == ""){
			service.insertCountry(language, country);
		}
		else{
			service.insertNewLanguage(nLanguage, country);
		}

		redirect(resp);
	}
	
	private void redirect(HttpServletResponse resp) throws IOException {
		resp.sendRedirect("datos.jsp");
	}
}
