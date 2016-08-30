package com.trio.proxibanquev2.presentation;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.trio.proxibanquev2.domaine.Adresse;
import com.trio.proxibanquev2.domaine.Client;
import com.trio.proxibanquev2.domaine.Conseiller;
import com.trio.proxibanquev2.service.AuthService;
import com.trio.proxibanquev2.service.ClientService;
import com.trio.proxibanquev2.service.ConseillerService;

/**
 * Servlet implementation class EditionClientServlet
 */
@WebServlet("/EditionClient")
public class EditionClientServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public EditionClientServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		edition(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		edition(request, response);
	}

	private void edition(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		ClientService clientServ =new ClientService();
		String nom=request.getParameter("nom");
		String prenom=request.getParameter("prenom");
		String mail=request.getParameter("mail");
		String numRue=request.getParameter("numRue");
		String typeDeRue=request.getParameter("typeDeRue");
		String nomDeRue=request.getParameter("nomDeRue");
		int codepostal=Integer.parseInt(request.getParameter("codepostal"));
		String ville=request.getParameter("ville");
		int ordreclientliste=Integer.parseInt(request.getParameter("clientNum"));
		
		
		HttpSession maSession=request.getSession();
		Conseiller user=(Conseiller) maSession.getAttribute("User");
		
		Client clientEdite =user.getListClient().get(ordreclientliste);
		clientEdite.setNom(nom);
		clientEdite.setPrenom(prenom);
		clientEdite.setMail(mail);
		clientEdite.setAdresse(new Adresse(clientEdite.getAdresse().getIdAdresse(),numRue,typeDeRue,nomDeRue,codepostal,ville));
		RequestDispatcher dispatcher;
		
		if(clientServ.modifierUnClient(clientEdite)){
			dispatcher= request.getRequestDispatcher("menu.jsp");
			//maSession.setAttribute("User", user);
		}else{
			dispatcher= request.getRequestDispatcher("erreur.jsp");	
		}
		

		dispatcher.forward(request, response);
		
		
		
		
		
	}
}
