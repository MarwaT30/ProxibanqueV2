package com.trio.proxibanquev2.presentation;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.trio.proxibanquev2.domaine.Conseiller;
import com.trio.proxibanquev2.service.AuthService;
import com.trio.proxibanquev2.service.ConseillerService;

/**
 * Servlet implementation class AuthServlet
 */
@WebServlet("/Authentification")
public class AuthServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public AuthServlet() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Authentification(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Authentification(request,response);
	}
	
	private void Authentification(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		ConseillerService conseillerServ =new ConseillerService();
		AuthService AuthServ=new AuthService();
		String login=request.getParameter("login");
		String password=request.getParameter("password");
		RequestDispatcher dispatcher;
		if(AuthServ.Authentification(login, password)){
			dispatcher= request.getRequestDispatcher("menu.jsp");
			HttpSession maSession=request.getSession();
			Conseiller user=conseillerServ.lireUnConseillerByLogin(login, password);
			maSession.setAttribute("User", user);
			
		}else{
			dispatcher= request.getRequestDispatcher("erreurlogin.jsp");
		}
		
		
		
		dispatcher.forward(request, response);
		
		
		
		
		
		
	}

}
