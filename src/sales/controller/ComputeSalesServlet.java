package sales.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import sales.model.NumberBean;

public class ComputeSalesServlet extends HttpServlet {
	
	private ServletConfig config;
	
	private static final long serialVersionUID = 1L;

	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		this.config = config;
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name = request.getParameter("name");
   		String code = request.getParameter("code");
   		double sales = Double.parseDouble(request.getParameter("sales"));
   		
   		NumberBean value = new NumberBean(name, code, sales, config);
   		value.ComputeGross();
   		value.ComputeComm();
   		
   		request.setAttribute("number", value);
   		
   		RequestDispatcher dispatcher = request.getRequestDispatcher("display.html");
   		dispatcher.forward(request, response);
	}

}
