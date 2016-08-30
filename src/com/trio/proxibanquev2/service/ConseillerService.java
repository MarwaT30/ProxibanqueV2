package com.trio.proxibanquev2.service;

import com.trio.proxibanquev2.dao.ClientDAO;
import com.trio.proxibanquev2.dao.ConseillerDAO;
import com.trio.proxibanquev2.domaine.Conseiller;

/**
 * Cette classe permet de lire les informations stockées en BD de la table
 * 'conseiller', via la classe ConseillerDAO.
 * 
 * @author VincentB, BriceT, ThomasT
 *
 */
public class ConseillerService {

	private ConseillerDAO consDAO;
	private ClientDAO clientDAO;

	public ConseillerService() {
		this.consDAO = new ConseillerDAO();
		this.clientDAO = new ClientDAO();
	}

	/**
	 * Cette méthode permet de lire les informations d'un conseiller en base de
	 * donnée au moyen de la classe ConseillerDAO.
	 * 
	 * @param idConseiller
	 *            : l'id du conseiller
	 * @return : un objet de type conseiller.
	 */
	public Conseiller lireUnConseillerById(int idConseiller) {
		Conseiller conseiller = consDAO.lireUnConseillerById(idConseiller);
		conseiller.setListClient(clientDAO.lireTousLesClientsDunConseiller(conseiller));

		return conseiller;
	}

	/**
	 * Cette méthode permet de lire les informations d'un conseiller en base de
	 * donnée au moyen de la classe ConseillerDAO.
	 * 
	 * @param login
	 *            : le login du conseiller
	 * @param password
	 *            : le mot de passe du conseiller
	 * @return : un objet de type conseiller.
	 */
	public Conseiller lireUnConseillerByLogin(String login, String password) {
		Conseiller conseiller = consDAO.lireUnConseiller(login, password);
		conseiller.setListClient(clientDAO.lireTousLesClientsDunConseiller(conseiller));
		return conseiller;
	}

}
