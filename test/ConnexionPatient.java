package fr.doctolib.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import fr.doctolib.beans.Patient;
import fr.doctolib.forms.ConnexionForm;

/**
 * Servlet implementation class ConnexionPatient
 */
@WebServlet("/ConnexionPatient")
public class ConnexionPatient extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	public static final String ATT_USR = "patient";
	public static final String ATT_FORM = "form";

	public static final String ATT_SESSION_USER = "sessionPatient";
	public static final String VUE = "/WEB-INF/connexionPatient.jsp";

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// Affichage de la page de connexion
		this.getServletContext().getRequestDispatcher(VUE).forward(request,response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		ConnexionForm form = new ConnexionForm();

		Patient patient = form.connecterPatient(request);

		// Récupération de la session.

		HttpSession session = request.getSession();

		if(form.getErreurs().isEmpty()){
			session.setAttribute(ATT_SESSION_USER, patient);
		}else{
			session.setAttribute(ATT_SESSION_USER,null);
		}

		request.setAttribute(ATT_FORM,form);
		request.setAttribute(ATT_USR,patient);

		this.getServletContext().getRequestDispatcher(VUE).forward(request,response);
	}

}
