package fr.doctolib.servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.doctolib.beans.Patient;
import fr.doctolib.forms.InscriptionForm;

/**
 * Servlet implementation class InscriptionPatient
 */
@WebServlet("/InscriptionPatient")

public class InscriptionPatient extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public static final String ATT_USER = "patient";
	public static final String ATT_FORM = "form";

	public static final String VUE = "/WEB-INF/inscriptionPatient.jsp";
       
  

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// Affichage de la page d'inscription du patient
		this.getServletContext().getRequestDispatcher(VUE).forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// L'objet formulaire
		InscriptionForm form = new InscriptionForm();
		//Traitement et validation de la requête
		Patient patient = form.inscrirePatient(request);
		// Stockage du formulaire
		request.setAttribute(ATT_FORM, form);
		request.setAttribute(ATT_USER, patient);

		this.getServletContext().getRequestDispatcher(VUE).forward(request, response);
		
	}

}
