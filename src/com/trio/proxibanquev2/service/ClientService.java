package com.trio.proxibanquev2.service;

import com.trio.proxibanquev2.dao.ClientDAO;
import com.trio.proxibanquev2.domaine.Client;

/**
 * Cette classe permet de lire les informations stock�es en BD de la table
 * 'client', via la classe ClientDAO.
 * 
 * @author VincentB, BriceT, ThomasT
 *
 */
public class ClientService {

	ClientDAO clientDAO;

	public ClientService() {
		clientDAO = new ClientDAO();
	}

	/**
	 * Cette m�thode permet de modifier les informations d'un client en base de
	 * donn�e au moyen de la classe ClientDAO.
	 * 
	 * @param client
	 *            : un objet de type client
	 * @return un boulean qui permet de valider si le client a �t� modifier en
	 *         base
	 */
	public boolean modifierUnClient(Client client) {
		return clientDAO.modifierUnClient(client);
	}

	/**
	 * Cette m�thode permet de lire les informations d'un client en base de
	 * donn�e au moyen de la classe ClientDAO.
	 * 
	 * @param idClient
	 *            : l'id du client
	 * @return un objet de type client
	 */
	public Client lireUnClient(int idClient) {
		return clientDAO.lireUnClient(idClient);
	}

	/**
	 * Cette m�thode permet de cr�er les informations d'un client en base de
	 * donn�e au moyen de la classe ClientDAO.
	 * 
	 * @param client
	 *            : un objet de type client
	 * @return un boulean qui permet de valider si le client a �t� cr�er en base
	 */
	public boolean ecrireUnClient(Client client) {

		boolean effectif = clientDAO.ecrireUnClient(client);
		client.setIdClient(clientDAO.lireIdDuDernierClient());
		return effectif;

	}

}
