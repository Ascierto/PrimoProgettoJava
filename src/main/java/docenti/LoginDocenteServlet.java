package docenti;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Docente;
import service.DocenteService;

/**
 * Servlet implementation class LoginDocenteServlet
 */
@WebServlet("/LoginDocenteServlet")
public class LoginDocenteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginDocenteServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		request.getRequestDispatcher("/loginDocente.jsp").forward(request, response);;
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		
		String emailInput = request.getParameter("email");
		String passwordInput = request.getParameter("password");
        Docente loggedDocente = new Docente();
        
        try {
            loggedDocente = DocenteService.loginDocente(emailInput, passwordInput);
            String destPage = "/index.jsp";
             
            if (loggedDocente != null) {
      
            	
                HttpSession session = request.getSession();
                session.setAttribute("loggedDocente", loggedDocente);
                session.setMaxInactiveInterval(5*60); //5min
                request.setAttribute("stato", "Utente loggato");
                System.out.println("Loggato");
                
                
               
            } else {
            	request.setAttribute("error", "Email o password errati");
            	destPage = "/loginDocente.jsp";;
            	 System.out.println("Non Loggato");
            }
             
            request.getRequestDispatcher(destPage).forward(request, response);
            
        } catch (SQLException  ex) {
            throw new ServletException(ex);
        }
    }
}


