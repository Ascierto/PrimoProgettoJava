package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Studente;
import service.StudenteService;

/**
 * Servlet implementation class DeleteServlet
 */
@WebServlet("/DeleteServlet")
public class DeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteServlet() {
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
		
		String id_studente = request.getParameter("id_studente");
		
		try {
			StudenteService.deleteStudent(Integer.parseInt(id_studente));
			request.setAttribute("delete", "Cancelazione avvenuta con successo");
			
			ArrayList<Studente> studenti = StudenteService.selectAllStudents();
			request.setAttribute("studenti", studenti);
			
			request.getRequestDispatcher("/studenti.jsp").forward(request, response);
			
		}catch(Exception e) {
			request.setAttribute("delete", "Ops c'è stato un problema");
			request.getRequestDispatcher("/studenti.jsp").forward(request, response);
			e.printStackTrace();
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
