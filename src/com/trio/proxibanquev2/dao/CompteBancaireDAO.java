package com.trio.proxibanquev2.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;

import com.trio.proxibanquev2.Exception.DAOException;
import com.trio.proxibanquev2.domaine.Adresse;
import com.trio.proxibanquev2.domaine.Client;
import com.trio.proxibanquev2.domaine.CompteBancaire;
import com.trio.proxibanquev2.domaine.CompteCourant;
import com.trio.proxibanquev2.domaine.CompteEpargne;
import com.trio.proxibanquev2.domaine.Conseiller;

/**
 * ClasseCelle classe permet le dialoque entre le programme et la base de
 * donn�es, concernant le CRUD des comptes bancaires.
 * 
 * @author Thomas T
 *
 */
public class CompteBancaireDAO {
	ConnexionDB connexion = new ConnexionDB();

	/**
	 * Cette m�thode eprmet d'�crire un compte courant dans la base de donn�es
	 * 'proxibanquev2'. Cette m�thode prend en param�tre :
	 * 
	 * @param compte
	 *            : le compte � enregistrer
	 * @param idClient
	 *            : l'id du client � qui appartient le compte
	 * @returnun boulean de mani�re � v�rifier l'�criture de l'adresse dans la
	 *           BD.
	 */
	public boolean ecrireUnCompte(CompteCourant compte, int idClient) {
		int result = 0;

		int numCompte = compte.getNumCompte();
		double solde = compte.getSolde();
		String dateOuverture = compte.getDateOuverture();
		double decouvertAutorise = compte.getDecouvertAutorise();
		String typeCompte = "compte courant";

		String sql = "INSERT INTO CompteBancaire (numCompte, dateOuverture, solde, typeCompte, decouvertAutorise, idClient) VALUES ("
				+ numCompte + ", " + solde + ", '" + dateOuverture + "', " + decouvertAutorise + ", '" + typeCompte
				+ "'" + idClient + ")";

		try {
			result = connexion.creationConnexionBD().executeUpdate(sql);
		} catch (SQLException e) {

			e.printStackTrace();
		} finally

		{
			connexion.finConnexionBD();
		}
		if (result == 0)

		{
			return false;
		} else
			return true;

	}

	/**
	 * Cette m�thode eprmet d'�crire un compte �pargne dans la base de donn�es
	 * 'proxibanquev2'. Cette m�thode prend en param�tre :
	 * 
	 * @param compte
	 *            : le compte � enregistrer
	 * @param idClient
	 *            : l'id du client � qui appartient le compte
	 * @returnun boulean de mani�re � v�rifier l'�criture de l'adresse dans la
	 *           BD.
	 */
	public boolean ecrireUnCompte(CompteEpargne compte, int idClient) {
		int result = 0;

		int numCompte = compte.getNumCompte();
		double solde = compte.getSolde();
		String dateOuverture = compte.getDateOuverture();
		double tauxRemun = compte.getTauxRemun();
		String typeCompte = "compte epargne";

		String sql = "INSERT INTO CompteBancaire (numCompte, dateOuverture, solde, typeCompte, tauxRemuneration, idClient) VALUES ("
				+ numCompte + ", " + solde + ", '" + dateOuverture + "', " + tauxRemun + ", '" + typeCompte + "'"
				+ idClient + ")";

		try {
			result = connexion.creationConnexionBD().executeUpdate(sql);
		} catch (SQLException e) {

			e.printStackTrace();
		} finally

		{
			connexion.finConnexionBD();
		}
		if (result == 0)

		{
			return false;
		} else
			return true;

	}

	/**
	 * Cette m�thode permet de lire un compte courant avec comme param�tre
	 * d'entr�e :
	 * 
	 * @param idCompte
	 *            : l'id du compte
	 * @return un objet de type compte courant
	 */
	public CompteCourant lireUnCompteCourant(int idCompte) {
		ResultSet rs = null;

		String sql = "SELECT * FROM comptebancaire where idCompte = " + idCompte;

		CompteCourant compte = new CompteCourant();

		try {
			rs = connexion.creationConnexionBD().executeQuery(sql);
		} catch (SQLException e) {

			e.printStackTrace();
		}

		try {
			while (rs.next()) {

				int numCompte = rs.getInt("numCompte");
				String dateOuverture = rs.getString("dateOuverture");
				double solde = rs.getDouble("solde");
				String typeCompte = rs.getString("typeCompte");
				double decouvertAutorise = rs.getDouble("decouvertAutorise");
				int idClient = rs.getInt("idClient");

				compte.setDateOuverture(dateOuverture);
				compte.setDecouvertAutorise(decouvertAutorise);
				compte.setIdCompte(idCompte);
				compte.setNumCompte(numCompte);
				compte.setSolde(solde);
				compte.setIdClient(idClient);

			}

		} catch (SQLException e) {

			e.printStackTrace();
		} finally {
			connexion.finConnexionBD();
			try {
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return compte;

	}

	/**
	 * Cette m�thode permet de lire un compte �pargne avec comme param�tre
	 * d'entr�e :
	 * 
	 * @param idCompte
	 *            : l'id du compte
	 * @return un objet de type compte �pargne
	 */
	public CompteEpargne lireUnCompteEpargne(int idCompte) {
		ResultSet rs = null;

		String sql = "SELECT * FROM comptebancaire where idCompte = " + idCompte;

		CompteEpargne compte = new CompteEpargne();

		try {
			rs = connexion.creationConnexionBD().executeQuery(sql);
		} catch (SQLException e) {

			e.printStackTrace();
		}

		try {
			while (rs.next()) {

				int numCompte = rs.getInt("numCompte");
				String dateOuverture = rs.getString("dateOuverture");
				double solde = rs.getDouble("solde");
				String typeCompte = rs.getString("typeCompte");
				double tauxRemun = rs.getDouble("tauxRemuneration");
				int idClient = rs.getInt("idClient");

				compte.setDateOuverture(dateOuverture);
				compte.setTauxRemun(tauxRemun);
				compte.setIdCompte(idCompte);
				compte.setNumCompte(numCompte);
				compte.setSolde(solde);
				compte.setIdClient(idClient);

			}

		} catch (SQLException e) {

			e.printStackTrace();
		} finally {
			connexion.finConnexionBD();
			try {
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return compte;

	}
	
	public boolean modifierUnCompte(CompteBancaire compte) throws DAOException{
		if(compte instanceof CompteCourant){
			CompteCourant nouveauCompte = (CompteCourant) compte;
			return modifierUnCompte(nouveauCompte);
		}else if(compte instanceof CompteEpargne){
			CompteEpargne nouveauCompte = (CompteEpargne) compte;
			return modifierUnCompte(nouveauCompte);
			
		}else{
			throw new DAOException ("Type de compte non g�r� par la DAO !");
		}

		
	}

	/**
	 * Cette m�thode permet de mettre � jour un compte courant dans une BD. Elle
	 * prend comme param�tre :
	 * 
	 * @param compte
	 *            : le compte � modifier
	 * @return un boulean pour v�rifier l'�criture du compte courant dans la BD.
	 */
	public boolean modifierUnCompte(CompteCourant compte) {
		int result = 0;
		int idCompte = compte.getIdCompte();
		double solde = compte.getSolde();
		double decouvertAutorise = compte.getDecouvertAutorise();

		String sql = "UPDATE comptebancaire SET solde = " + solde + ", decouvertAutorise = " + decouvertAutorise
				+ " WHERE idCompte = " + idCompte;

		// Etape 4 : ex�cution d'une requete

		try {
			result = connexion.creationConnexionBD().executeUpdate(sql);
		} catch (SQLException e) {

			e.printStackTrace();
		} finally

		{
			connexion.finConnexionBD();
		}
		if (result == 0)

		{
			return false;
		} else
			return true;

	}

	/**
	 * Cette m�thode permet de mettre � jour un compte �pargne dans une BD. Elle
	 * prend comme param�tre :
	 * 
	 * @param compte
	 *            : le compte � modifier
	 * @return un boulean pour v�rifier l'�criture du compte �pargne dans la BD.
	 */
	public boolean modifierUnCompte(CompteEpargne compte) {
		int result = 0;
		int idCompte = compte.getIdCompte();
		double solde = compte.getSolde();
		double tauxRemun = compte.getTauxRemun();

		String sql = "UPDATE comptebancaire SET solde = " + solde + ", tauxRemuneration = " + tauxRemun
				+ " WHERE idCompte = " + idCompte;

		// Etape 4 : ex�cution d'une requete

		try {
			result = connexion.creationConnexionBD().executeUpdate(sql);
		} catch (SQLException e) {

			e.printStackTrace();
		} finally

		{
			connexion.finConnexionBD();
		}
		if (result == 0)

		{
			return false;
		} else
			return true;

	}

	/**
	 * Cette m�thode permet de supprimer un compte courant d'une BD. Elle prend
	 * comme param�tre :
	 * 
	 * @param compte
	 *            : le compte � supprimer
	 * @return un boulean qui permet de v�rifier la suppression du compte de la
	 *         BD.
	 */
	public boolean supprimerUnCompteDansUneBase(CompteCourant compte) {

		int result = 0;
		int idCompte = compte.getIdCompte();
		String sql = "DELETE FROM comptebancaire WHERE idCompte = " + idCompte;

		try {
			result = connexion.creationConnexionBD().executeUpdate(sql);

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			connexion.finConnexionBD();
		}

		if (result == 0) {
			return false;
		} else
			return true;

	}

	/**
	 * Cette m�thode permet de supprimer un compte �pargne d'une BD. Elle prend
	 * comme param�tre :
	 * 
	 * @param compte
	 *            : le compte � supprimer
	 * @return un boulean qui permet de v�rifier la suppression du compte de la
	 *         BD.
	 */
	public boolean supprimerUnCompteDansUneBase(CompteEpargne compte) {

		int result = 0;
		int idCompte = compte.getIdCompte();
		String sql = "DELETE FROM comptebancaire WHERE idCompte = " + idCompte;

		try {
			result = connexion.creationConnexionBD().executeUpdate(sql);

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			connexion.finConnexionBD();
		}

		if (result == 0) {
			return false;
		} else
			return true;

	}

	/**
	 * Cette m�thode permet de supprimer les comptes d'unn client de la BD. Elle
	 * prend comme param�tre :
	 * 
	 * @param client
	 *            : le client dont on veut supprimer les comptes : le compte �
	 *            supprimer
	 * @return un boulean qui permet de v�rifier la suppression des comptes de
	 *         la BD.
	 */
	public boolean supprimerLesComptesDunClientDansUneBase(Client client) {

		int result = 0;
		int idClient = client.getIdClient();
		String sql = "DELETE FROM comptebancaire WHERE idClient = " + idClient;

		try {
			result = connexion.creationConnexionBD().executeUpdate(sql);

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			connexion.finConnexionBD();
		}

		if (result == 0) {
			return false;
		} else
			return true;

	}

	/**
	 * Cette m�thod epermet de cr�er une liste de tous les comptes bancaires
	 * d'un client
	 * 
	 * @param client
	 *            : le client dont on veut la liste des comptes
	 * @return une liste d'objet de type compte bancaire.
	 */
	public ArrayList<CompteBancaire> lireTousLesComptesBancaireDunClient(Client client) {

		ResultSet rs = null;

		// cr�ation de la liste
		ArrayList<CompteBancaire> listeDesComptes = new ArrayList<CompteBancaire>();

		try {
			int idClient = client.getIdClient();

			String sql = "SELECT * FROM comptebancaire WHERE idClient= " + idClient;

			rs = connexion.creationConnexionBD().executeQuery(sql);

			while (rs.next()) {
				int idCompte = rs.getInt("idCompte");
				int numCompte = rs.getInt("numCompte");
				String dateOuverture = rs.getString("dateOuverture");
				double solde = rs.getDouble("solde");
				String typeCompte = rs.getString("typeCompte");
				double tauxRemun = rs.getDouble("TauxRemuneration");
				double decouvertAutorise = rs.getDouble("decouvertAutorise");
				if (typeCompte.equalsIgnoreCase("compte courant")) {
					CompteCourant compte = new CompteCourant(idCompte, numCompte, solde, dateOuverture, idClient,
							decouvertAutorise);
					listeDesComptes.add(compte);

				} else {
					CompteEpargne compte = new CompteEpargne(idCompte, numCompte, solde, dateOuverture, idClient,
							tauxRemun);
					listeDesComptes.add(compte);
				}

			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			connexion.finConnexionBD();
			try {

				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return listeDesComptes;

	}

}
