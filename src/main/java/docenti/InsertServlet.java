package docenti;

import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.SecureRandom;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Docente;
import service.DocenteService;
import service.StudenteService;

/**
 * Servlet implementation class InsertServlet
 */
@WebServlet("/InsertServlet")
public class InsertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InsertServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.getRequestDispatcher("/registerDocente.jsp").forward(request, response);		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String name = request.getParameter("name");
		String surname = request.getParameter("surname");
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		String passwordCheck = request.getParameter("passwordCheck");
		
		
		
		if(name != null && surname != null && email != null && password != null && passwordCheck != null) {
			
			request.setAttribute("name", name);
			request.setAttribute("surname", surname);
			request.setAttribute("email", email);
			request.setAttribute("password", password);
			request.setAttribute("passwordCheck", passwordCheck);
			

				
			boolean passOk = password.equals(passwordCheck);
			
			if(!passOk) {
				request.setAttribute("error","Le password non corrispondono");
				
				request.getRequestDispatcher("/registerDocente.jsp").forward(request, response);
				
			}else {
							
				Docente doc = new Docente(name,surname,email,password);
				
				
				try {
					DocenteService.insertDocente(name,surname,email,password);
					request.setAttribute("answer","Inserimento avvenuto con successo");
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				request.getRequestDispatcher("/loginDocente.jsp").forward(request, response);
			}
			
			
		}else {
			request.setAttribute("error","Ops c'è stato un problema");
			request.getRequestDispatcher("/registerDocente.jsp").forward(request, response);
			System.out.println("Valori null nei parametri");
		}
	}
	
	
}
