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

import model.Studente;
import service.DocenteStudenteService;
import service.StudenteService;

/**
 * Servlet implementation class InsertStudenteToDocenteServlet
 */
@WebServlet("/InsertStudenteToDocenteServlet")
public class InsertStudenteToDocenteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InsertStudenteToDocenteServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		
		
		try {
			ArrayList<Studente> studenti = StudenteService.selectAllStudents();
			request.setAttribute("studenti", studenti);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		request.getRequestDispatcher("/insertStudenteToDocente.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		
		String id_studente = request.getParameter("id_studente");
		String id_docente = request.getParameter("id_docente");
		
		try {
			DocenteStudenteService.insertStudenteToDocente(Integer.parseInt(id_docente), Integer.parseInt(id_studente));
			
			request.setAttribute("stato", "Studente assegnato");
			
			ArrayList<Studente> studentiAssoc = DocenteStudenteService.showStudentiDocente(Integer.parseInt(id_docente));			
			request.setAttribute("studentiAssoc", studentiAssoc);
			
			request.getRequestDispatcher("/showStudentiAssoc.jsp").forward(request, response);
		} catch (NumberFormatException | SQLException e) {
			// TODO Auto-generated catch block
			
			request.setAttribute("error", "Ops c'è stato un problema");
			request.getRequestDispatcher("/insertStudenteToDocente.jsp").forward(request, response);
			e.printStackTrace();
		}
		
		//presi questi 2 parametri posso performare la insert nella pivot(che scrivo nel service)
		
		
	}

}
