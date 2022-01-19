package controller;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Calcolatrice;

import java.io.IOException;

/**
 * Servlet implementation class CalcolatriceServlet
 */
public class CalcolatriceServlet extends HttpServlet {


	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
//		HttpSession session = request.getSession();
//		
//		if(session.getAttribute("loggedDocente") == null) {
//			
//			request.setAttribute("error", "Accesso non consentito");
//        	request.getRequestDispatcher("/loginDocente.jsp").forward(request, response);
//        	System.out.println("Tentativo di attacco");
//		}
		
		String a = request.getParameter("num1");
		request.setAttribute("num1", a);
		String b = request.getParameter("num2");
		request.setAttribute("num2", b);
		String segno = request.getParameter("operation");
		request.setAttribute("operation", segno);
		
		
		
		
		try {
			if(a.equals("") || b.equals("")) {
				throw new NumberFormatException();		
			}	
			
			Calcolatrice c = new Calcolatrice(Double.parseDouble(a),Double.parseDouble(b));
			request.setAttribute("risultato", c.operazione(segno));
			
		}catch(NumberFormatException e) {
			response.getWriter().append("Errore : ").append(e.getMessage());
			
			
		}catch(Exception e) {
			response.getWriter().append("Errore : ").append(e.getMessage());
		}
		
				  			  
		
		request.getRequestDispatcher("/calcolatrice.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
