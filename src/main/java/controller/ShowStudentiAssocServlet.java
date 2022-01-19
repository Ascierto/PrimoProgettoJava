package controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Docente;
import model.Studente;
import service.DocenteStudenteService;
import service.StudenteService;

/**
 * Servlet implementation class ShowStudentiAssocServlet
 */
@WebServlet("/ShowStudentiAssocServlet")
public class ShowStudentiAssocServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ShowStudentiAssocServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		
		HttpSession session = request.getSession();
		
		if(session.getAttribute("loggedDocente") == null) {
			
			request.setAttribute("error", "Accesso non consentito");
        	request.getRequestDispatcher("/loginDocente.jsp").forward(request, response);
        	System.out.println("Tentativo di attacco");
		}
		
		Docente loggedDocente = (Docente) session.getAttribute("loggedDocente");
			
		
		try {
			ArrayList<Studente> studentiAssoc = DocenteStudenteService.showStudentiDocente(loggedDocente.getId_docente());			
			request.setAttribute("studentiAssoc", studentiAssoc);
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
	
		
		
		request.getRequestDispatcher("/showStudentiAssoc.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
