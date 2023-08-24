package sales.view;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import sales.model.NumberBean;

public class DisplayDataServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		NumberBean value = (NumberBean)request.getAttribute("number");
		
		response.setContentType("text/html;charset=UTF-8");
		
		PrintWriter out = response.getWriter();
		
		if(value.getSales() < 0){
			out.print("<html>");
			out.print("	<head><title>Sales Computation</title></head>");
			out.print("	<body>");
			out.print(" <h1>The value of sales amount should NOT BE negative!</h1>");
			out.print("		<form action='homepage.html'>");
			out.print("			<p><input type='submit' value='<< GO BACK >>'/></p>");
			out.print("		</form>");
			out.print("	</body>");
			out.print("</html>");
			
			out.close();
		}
		else{
			out.print("<html>");
			out.print("	<head><title>Sales Computation</title></head>");
			out.print("	<body>");
			out.print(" <p>Employee Name: " + value.getName() + "</p>");
			out.print(" <p>Sales Code: " + value.getCode() + "</p>");
			out.print(" <p>Sales Amount: Php" + value.getSales() + "</p>");
			out.print(" <p>Sales Gross Commission: Php" + value.getGross() + "</p>");
			out.print(" <p>Sales Commission: Php" + value.getComm() + "</p>");
			out.print("		<form action='homepage.html'>");
			out.print("			<p><input type='submit' value='<< GO BACK >>'/></p>");
			out.print("		</form>");
			out.print("	</body>");
			out.print("</html>");
			
			out.close(); 
		}
		
	}

}
