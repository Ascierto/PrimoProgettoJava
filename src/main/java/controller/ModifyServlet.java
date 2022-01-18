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
import service.StudenteService;

/**
 * Servlet implementation class ModifyServlet
 */
@WebServlet("/ModifyServlet")
public class ModifyServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ModifyServlet() {
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
		

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String name = request.getParameter("name");
		String surname = request.getParameter("surname");
		String age = request.getParameter("age");
		String id_studente = request.getParameter("id_studente");
		
		if( name == null || name.equals("") ) {
			request.setAttribute("error", "Il campo nome è obbligatorio");
			request.getRequestDispatcher("/updateStudente.jsp").forward(request, response);
		}else if(surname == null || surname.equals("")) {
			request.setAttribute("error", "Il campo cognome è obbligatorio");
			request.getRequestDispatcher("/updateStudente.jsp").forward(request, response);
		}else if(age == null || age.equals("")) {
			request.setAttribute("error", "Il campo età è obbligatorio");
			request.getRequestDispatcher("/updateStudente.jsp").forward(request, response);
		}else {
			request.setAttribute("name", name);
			request.setAttribute("surname", surname);
			request.setAttribute("age", age);
			request.setAttribute("id_studente", id_studente);
			try {
				StudenteService.updateStudent(Integer.parseInt(id_studente), name, surname, Integer.parseInt(age));
				request.setAttribute("stato", "Modifica effettuata con successo");
				
			}catch(SQLException e) {
				e.printStackTrace();
			}
			
			
			try {
				ArrayList<Studente> studenti = StudenteService.selectAllStudents();
				request.setAttribute("studenti", studenti);
				
			}catch(SQLException e) {
				e.printStackTrace();
			}
			
				
			
			request.getRequestDispatcher("/studenti.jsp").forward(request, response);
		}

	}

}
