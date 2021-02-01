package fr.doctolib.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class DeconnexionMedecin
 */
@WebServlet("/DeconnexionMedecin")
public class DeconnexionMedecin extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	public static final String VUE = "/WEB-INF/connexionMedecin.jsp";
       
   
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// Destruction de la session en cours
				HttpSession session = request.getSession();
				session.invalidate();

				// Affichage de la page de connexion
				this.getServletContext().getRequestDispatcher(VUE).forward(request, response);
	}

}
