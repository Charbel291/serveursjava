package fr.doctolib.servlets;

import java.io.IOException;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.doctolib.beans.Medecin;
import fr.doctolib.dao.DaoFactory;
import fr.doctolib.dao.MedecinDAO;

/**
 * Servlet implementation class FrontController
 */
@WebServlet("/FrontController")
public class FrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private MedecinDAO medecinDao;

	public void init() throws ServletException{
		DaoFactory daoFactory = DaoFactory.getInstance();
		this.medecinDao = daoFactory.getMedecinDao();
	}  

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setAttribute("medecins", medecinDao.lister());
		this.getServletContext().getRequestDispatcher("/WEB-INF/Template.jsp").forward(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	// TODO Auto-generated method stub
		Medecin medecin = new Medecin();
		medecin.setId(request.getParameter("id"));
		medecin.setNom(request.getParameter("nom"));

		medecinDao.ajouter(medecin);
		request.setAttribute("medecins",medecinDao.lister());

		this.getServletContext().getRequestDispatcher("/WEB-INF/Template.jsp").forward(request,response);
	

	}
}
