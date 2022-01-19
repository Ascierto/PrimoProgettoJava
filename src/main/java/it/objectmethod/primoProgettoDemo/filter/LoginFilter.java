package it.objectmethod.primoProgettoDemo.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Docente;

/**
 * Servlet Filter implementation class LoginFilter
 */
@WebFilter({"/LoginFilter","/CalcolatriceServlet","/DeleteServlet","/HomeServlet","/InserisciStudenteServlet",
	"/InserisciStudenteToDocenteServlet","/ModifyServlet","/ShowStudentiAssocServlet","/StudentiServlet",
	"/UpdateServlet","/ProfileServlet"})
public class LoginFilter extends HttpFilter implements Filter {
       
	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		
		//faccio un downcast della richiesta e della risposta. 
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse res = (HttpServletResponse) response;
		
		//recupero la sessione del client che ha effettuato la richiesta 
		HttpSession session = req.getSession();
		
		//recuperaro l'oggetto docente loggato
		try {
			
			Docente loggedDocente = (Docente) session.getAttribute("loggedDocente");
			if (loggedDocente == null) { 
				
				//un utente generico ha tentato di accedere ai percorsi protetti
				request.setAttribute("error", "Filtro funzionante nn processo request");
				request.getRequestDispatcher("/loginDocente.jsp").forward(request, response);
			}else {
				
				// pass the request along the filter chain
				chain.doFilter(request, response);
			}
		}catch(IllegalStateException e) {
			e.printStackTrace();
		}
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
