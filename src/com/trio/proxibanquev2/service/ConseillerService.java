package com.trio.proxibanquev2.service;

import com.trio.proxibanquev2.dao.ClientDAO;
import com.trio.proxibanquev2.dao.ConseillerDAO;
import com.trio.proxibanquev2.domaine.Conseiller;

public class ConseillerService {

	private ConseillerDAO consDAO;
	private ClientDAO clientDAO;
	
	
	
	public ConseillerService(){
		this.consDAO=new ConseillerDAO();
		this.clientDAO=new ClientDAO();
	}
	
	
	
	public Conseiller lireUnConseillerById(int idConseiller){
		 Conseiller conseiller=consDAO.lireUnConseillerById(idConseiller);
		 conseiller.setListClient(clientDAO.lireTousLesClientsDunConseiller(conseiller));
		 return conseiller;
	}
	
	
	public Conseiller lireUnConseillerById(String login, String password){
		 Conseiller conseiller=consDAO.lireUnConseiller( login, password);
		 conseiller.setListClient(clientDAO.lireTousLesClientsDunConseiller(conseiller));
		 return conseiller;
	}
	
	
	
	
	
	
	
	
}
