package com.trio.proxibanquev2.presentation;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.trio.proxibanquev2.domaine.CompteBancaire;
import com.trio.proxibanquev2.domaine.Conseiller;
import com.trio.proxibanquev2.service.AuthService;
import com.trio.proxibanquev2.service.CompteService;
import com.trio.proxibanquev2.service.ConseillerService;

/**
 * Servlet implementation class ChoixClientServlet
 */
@WebServlet("/ChoixClient")
public class ChoixClientServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ChoixClientServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		choixClient(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		choixClient(request, response);
	}

	private void choixClient(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		CompteService compteServ=new CompteService(); 
		
		HttpSession maSession = request.getSession();
		Conseiller user = (Conseiller) maSession.getAttribute("User");
		int ligneClient=0;
		boolean entreisint = true;
		RequestDispatcher dispatcher;
		try {
			ligneClient = Integer.parseInt(request.getParameter("login"));
		} catch (Exception e) {
			entreisint = false;
		}
		if (entreisint) {
			ligneClient = ligneClient - 1;
			int sizelist=user.getListClient().size();
			if ((ligneClient < 0) || (ligneClient > sizelist)) {
				dispatcher = request.getRequestDispatcher("erreurchoixclient.jsp");
				
			} else {
				user.getListClient().get(ligneClient).setListeCompte(compteServ.lireTousLesComptesBancaireDunClient(user.getListClient().get(ligneClient)));
				maSession.setAttribute("numClientObserve", ligneClient);
				ArrayList<CompteBancaire> listecomptebancaire=compteServ.lireTousLesComptesBancaire();
				maSession.setAttribute("listeCompteBanque", listecomptebancaire);
				dispatcher = request.getRequestDispatcher("pageclient.jsp");
			}

		} else {
			dispatcher = request.getRequestDispatcher("erreurchoixclient.jsp");
		}

		dispatcher.forward(request, response);

	}

}
