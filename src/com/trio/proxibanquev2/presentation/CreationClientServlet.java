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

import com.trio.proxibanquev2.domaine.Adresse;
import com.trio.proxibanquev2.domaine.Client;
import com.trio.proxibanquev2.domaine.CompteBancaire;
import com.trio.proxibanquev2.domaine.Conseiller;
import com.trio.proxibanquev2.service.AuthService;
import com.trio.proxibanquev2.service.ClientService;
import com.trio.proxibanquev2.service.ConseillerService;

/**
 * Servlet implementation class CreationClientServlet
 */
@WebServlet("/CreationClient")
public class CreationClientServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CreationClientServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		creationClient( request,  response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		creationClient( request,  response);
	}
	
	
	public void creationClient(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		ClientService clientServ =new ClientService();
		String nom=request.getParameter("nom");
		String prenom=request.getParameter("prenom");
		String mail=request.getParameter("mail");
		String telephone=request.getParameter("telephone");
		String numRue=request.getParameter("numRue");
		String typeDeRue=request.getParameter("typeDeRue");
		String nomDeRue=request.getParameter("nomDeRue");
		int codePostal=Integer.parseInt(request.getParameter("codePostal"));
		String ville=request.getParameter("ville");
		HttpSession maSession=request.getSession();
		Conseiller user=(Conseiller) maSession.getAttribute("User");
		
		Client clientCreer =new Client(nom, prenom, new Adresse(numRue, typeDeRue, nomDeRue, codePostal, ville), telephone, mail, new ArrayList<CompteBancaire>(), user);
		
		RequestDispatcher dispatcher;
		
		if(clientServ.ecrireUnClient(clientCreer)){
			clientCreer=clientServ.lireUnClient(clientCreer.getIdClient());
			user.getListClient().add(clientCreer);
			dispatcher= request.getRequestDispatcher("menu.jsp");
			//maSession.setAttribute("User", user);
		}else{
			dispatcher= request.getRequestDispatcher("erreur.jsp");	
		}
		
		
		dispatcher.forward(request, response);
		
		
	}

}
