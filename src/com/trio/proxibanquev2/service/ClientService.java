package com.trio.proxibanquev2.service;

import com.trio.proxibanquev2.dao.ClientDAO;
import com.trio.proxibanquev2.domaine.Client;

/**
 * Cette classe permet de lire les informations stockées en BD de la table
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
	 * Cette méthode permet de modifier les informations d'un client en base de
	 * donnée au moyen de la classe ClientDAO.
	 * 
	 * @param client
	 *            : un objet de type client
	 * @return un boulean qui permet de valider si le client a été modifier en
	 *         base
	 */
	public boolean modifierUnClient(Client client) {
		return clientDAO.modifierUnClient(client);
	}

	/**
	 * Cette méthode permet de lire les informations d'un client en base de
	 * donnée au moyen de la classe ClientDAO.
	 * 
	 * @param idClient
	 *            : l'id du client
	 * @return un objet de type client
	 */
	public Client lireUnClient(int idClient) {
		return clientDAO.lireUnClient(idClient);
	}

	/**
	 * Cette méthode permet de créer les informations d'un client en base de
	 * donnée au moyen de la classe ClientDAO.
	 * 
	 * @param client
	 *            : un objet de type client
	 * @return un boulean qui permet de valider si le client a été créer en base
	 */
	public boolean ecrireUnClient(Client client) {

		boolean effectif = clientDAO.ecrireUnClient(client);
		client.setIdClient(clientDAO.lireIdDuDernierClient());
		return effectif;

	}

}
