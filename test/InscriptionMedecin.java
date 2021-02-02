package fr.doctolib.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.doctolib.beans.Medecin;
import fr.doctolib.forms.InscriptionFormMed;

/**
 * Servlet implementation class InscriptionMedecin
 */
@WebServlet("/InscriptionMedecin")
public class InscriptionMedecin extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	public static final String ATT_USER = "medecin";
	public static final String ATT_FORM = "form";

	public static final String VUE = "/WEB-INF/compteMedecin.jsp";
    /**
     * @see HttpServlet#HttpServlet()
     */
    

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/// Affichage de la page d'inscription du medecin
		this.getServletContext().getRequestDispatcher(VUE).forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// L'objet formulaire
		InscriptionFormMed form = new InscriptionFormMed();
		//Traitement et validation de la requete
		Medecin medecin = form.inscrireMedecin(request);
		// Stockage du formulaire
		request.setAttribute(ATT_FORM, form);
		request.setAttribute(ATT_USER, medecin);

		this.getServletContext().getRequestDispatcher(VUE).forward(request, response);
	}

}
