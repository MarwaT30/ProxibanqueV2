package com.trio.proxibanquev2.service;

import com.trio.proxibanquev2.Exception.DAOException;
import com.trio.proxibanquev2.Exception.ServiceException;
import com.trio.proxibanquev2.dao.CompteBancaireDAO;
import com.trio.proxibanquev2.domaine.CompteBancaire;

public class CompteService {

	CompteBancaireDAO compteDAO;

	public CompteService() {
		compteDAO = new CompteBancaireDAO();
	}

	public boolean virement(CompteBancaire compteDebite, CompteBancaire compteCredite, double montant)
			throws DAOException, ServiceException {
		compteDebite.enleverAuSolde(montant);
		compteCredite.ajouterAuSolde(montant);
		boolean test2=false;
		boolean test=false;
		test = compteDAO.modifierUnCompte(compteDebite);
		if (!test) {
			compteDebite.ajouterAuSolde(montant);
			compteCredite.enleverAuSolde(montant);
			test2 = false;
		} else {
			test2 = compteDAO.modifierUnCompte(compteCredite);
			if (!test2) {
				compteDebite.ajouterAuSolde(montant);
				compteCredite.enleverAuSolde(montant);
				test = compteDAO.modifierUnCompte(compteDebite);
				if (!test) {
					compteDebite.enleverAuSolde(montant);
					throw new ServiceException(
							"Probleme dans la modification DAO du virement, compte debiteur modifié sans possibilité de retour, compte crediteur non modifié");
				}
			}else{}
		}
		return (test & test2);

	}
}
