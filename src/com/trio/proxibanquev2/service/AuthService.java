package com.trio.proxibanquev2.service;

import com.trio.proxibanquev2.dao.ConseillerDAO;
import com.trio.proxibanquev2.domaine.Conseiller;

public class AuthService {

	private ConseillerDAO consDAO;
	
	public AuthService(){
		this.consDAO=new ConseillerDAO();
	}
	
	
	public boolean Authentification(String login, String password){
		
		Conseiller consID= consDAO.lireUnConseiller(login, password);
		
		if((login.equalsIgnoreCase(consID.getLogin())) && (password.equalsIgnoreCase(consID.getPassword()))) {
			return true;
		}else{
			return false;
		}
		
	}
	
	
	
}
