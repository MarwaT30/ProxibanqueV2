package com.trio.proxibanquev2.service;

import java.util.ArrayList;

import com.trio.proxibanquev2.Exception.DAOException;
import com.trio.proxibanquev2.Exception.ServiceException;
import com.trio.proxibanquev2.dao.CompteBancaireDAO;
import com.trio.proxibanquev2.domaine.Client;
import com.trio.proxibanquev2.domaine.CompteBancaire;

/**
 * Classe permettant d'interagir entre la base de données, via la classe
 * compteBancaireDAO, et la couche présentation, en ce qui concerne la gestion
 * des comptes.
 * 
 * @author VincentB, ThomasT
 *
 */
public class CompteService {

	CompteBancaireDAO compteDAO;

	public CompteService() {
		compteDAO = new CompteBancaireDAO();
	}

	/**
	 * Méthode permettant de prendre en charge un virement entre deux comptes.
	 * 
	 * @param compteDebite
	 *            : le compte à débiter
	 * @param compteCredite
	 *            : le compte à créditer
	 * @param montant
	 *            : le montant du virement
	 * @return : un bouleen qui permet de valider la transaction.
	 * @throws DAOException
	 * @throws ServiceException
	 */
	public boolean virement(CompteBancaire compteDebite, CompteBancaire compteCredite, double montant)
			throws DAOException, ServiceException {
		compteDebite.enleverAuSolde(montant);
		compteCredite.ajouterAuSolde(montant);
		boolean test2 = false;
		boolean test = false;
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
			} else {
			}
		}
		return (test & test2);

	}

	/**
	 * Méthode qui permet de lire tous les comptes bancaires d'un client, via la
	 * classe CompteBancaireDAO
	 * 
	 * @param client
	 *            : un objet de type client
	 * @return une liste de comptes bancaires
	 */
	public ArrayList<CompteBancaire> lireTousLesComptesBancaireDunClient(Client client) {
		return compteDAO.lireTousLesComptesBancaireDunClient(client);
	}

	/**
	 * Méthode qui permet de lire tous les comptes bancaires de la BD, via la
	 * classe CompteBancaireDAO
	 * 
	 * @return une liste de comptes bancaires
	 */
	public ArrayList<CompteBancaire> lireTousLesComptesBancaire() {
		return compteDAO.lireTousLesComptesBancaire();
	}

}
