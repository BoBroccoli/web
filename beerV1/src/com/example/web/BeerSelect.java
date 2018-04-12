package com.example.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.example.model.BeerExpert;
import com.example.model.Person;

public class BeerSelect extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = -5212877687087164982L;

	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//resp.setContentType("text/html");
		//PrintWriter pWriter = resp.getWriter();
		//pWriter.println("<html>" + "<body>Beer selection advice<br>");
		String c = req.getParameter("color");
		BeerExpert beerExpert = new BeerExpert();
		List<String> result = beerExpert.getBrands(c);
		/*
		 * for (String string : result) { pWriter.println("<br> try "+string); }
		 * pWriter.println("<br>Got beer color "+c+"</body></html>");
		 */
		req.setAttribute("styles", result);
		RequestDispatcher view = req.getRequestDispatcher("/result.jsp");
		Person person = new Person("Bo");
		req.setAttribute("person", person);
		view.forward(req, resp);
	}
}
