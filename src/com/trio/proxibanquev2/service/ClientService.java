package com.trio.proxibanquev2.service;

import com.trio.proxibanquev2.dao.ClientDAO;
import com.trio.proxibanquev2.domaine.Client;

public class ClientService {

	ClientDAO clientDAO;
	
	public ClientService(){
		clientDAO=new ClientDAO();
	}
	
	public boolean modifierUnClient(Client client) {
		return clientDAO.modifierUnClient(client);
	}
}
