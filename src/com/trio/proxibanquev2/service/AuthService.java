package com.trio.proxibanquev2.service;

import com.trio.proxibanquev2.Exception.DAOException;
import com.trio.proxibanquev2.dao.ConseillerDAO;
import com.trio.proxibanquev2.domaine.CompteBancaire;
import com.trio.proxibanquev2.domaine.CompteCourant;
import com.trio.proxibanquev2.domaine.CompteEpargne;
import com.trio.proxibanquev2.domaine.Conseiller;

public class AuthService {

	private ConseillerDAO consDAO;

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
