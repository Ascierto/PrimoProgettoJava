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
 * Servlet implementation class InserisciStudenteServlet
 */
@WebServlet("/InserisciStudenteServlet")
public class InserisciStudenteServlet extends HttpServlet {


	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		
		HttpSession session = request.getSession();
		
		if(session.getAttribute("loggedDocente") == null) {
			
			request.setAttribute("error", "Accesso non consentito");
        	request.getRequestDispatcher("/loginDocente.jsp").forward(request, response);
        	System.out.println("Tentativo di attacco");
		}
		
		request.getRequestDispatcher("/inserisciStudente.jsp").forward(request, response);

		

		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String name = request.getParameter("name");
		String surname = request.getParameter("surname");
		String age = request.getParameter("age");
		
		
			if(name != null && surname != null && age != null) {
				
				request.setAttribute("name", name);
				request.setAttribute("surname", surname);
				request.setAttribute("age", age);
				
				Studente stu1 = new Studente();
				
				stu1.setName(name);
				stu1.setSurname(surname);
				stu1.setAge(Integer.parseInt(age));
				
				try {
					StudenteService.insertStudent(stu1.getName(), stu1.getSurname(), stu1.getAge());
					
				}catch(SQLException e) {
					e.printStackTrace();
				}
				
				request.setAttribute("stato","Inserimento avvenuto con successo");
				try {
					ArrayList<Studente> studenti = StudenteService.selectAllStudents();
					request.setAttribute("studenti", studenti);
					
				}catch(SQLException e) {
					e.printStackTrace();
				}
						
				
				
				request.getRequestDispatcher("/studenti.jsp").forward(request, response);
				
			}else {
				request.setAttribute("error","Ops c'è stato un problema");
				request.getRequestURI();
				request.getRequestDispatcher("/inserisciStudente.jsp").forward(request, response);
				System.out.println("Valori null nei parametri");
			}
			
	}

}
