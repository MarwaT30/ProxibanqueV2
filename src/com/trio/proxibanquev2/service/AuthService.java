package com.trio.proxibanquev2.service;

import com.trio.proxibanquev2.Exception.DAOException;
import com.trio.proxibanquev2.dao.ConseillerDAO;
import com.trio.proxibanquev2.domaine.CompteBancaire;
import com.trio.proxibanquev2.domaine.CompteCourant;
import com.trio.proxibanquev2.domaine.CompteEpargne;
import com.trio.proxibanquev2.domaine.Conseiller;

/**
 * Cette classe permet de vérifier si les informations de login et password
 * fournies par l'interface web sont les mêmes que celles stockées en base de
 * donnée
 * 
 * @author VincentB, BriceT, ThomasT
 *
 */
public class AuthService {

	private ConseillerDAO consDAO;

	/**
	 * Méthode permettant de vérifier si les informations de login et password
	 * fournies par l'interface web sont les mêmes que celles stockées en base
	 * de donnée
	 */
	public AuthService() {
		this.consDAO = new ConseillerDAO();
	}

	public boolean Authentification(String login, String password) {

		Conseiller consID = consDAO.lireUnConseiller(login, password);

		if ((login.equalsIgnoreCase(consID.getLogin())) && (password != null)
				&& (password.equalsIgnoreCase(consID.getPassword()))) {
			return true;
		} else {
			return false;
		}

	}

}
