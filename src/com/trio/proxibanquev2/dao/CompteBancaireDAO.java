package com.trio.proxibanquev2.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;

import com.trio.proxibanquev2.domaine.Adresse;
import com.trio.proxibanquev2.domaine.Client;
import com.trio.proxibanquev2.domaine.CompteBancaire;
import com.trio.proxibanquev2.domaine.CompteCourant;
import com.trio.proxibanquev2.domaine.CompteEpargne;
import com.trio.proxibanquev2.domaine.Conseiller;

public class CompteBancaireDAO {
	ConnexionDB connexion = new ConnexionDB();

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

	public boolean modifierUnCompte(CompteCourant compte) {
		int result = 0;
		int idCompte = compte.getIdCompte();
		double solde = compte.getSolde();
		double decouvertAutorise = compte.getDecouvertAutorise();

		String sql = "UPDATE comptebancaire SET solde = " + solde + ", decouvertAutorise = " + decouvertAutorise
				+ " WHERE idCompte = " + idCompte;

		// Etape 4 : exécution d'une requete

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

	public boolean modifierUnCompte(CompteEpargne compte) {
		int result = 0;
		int idCompte = compte.getIdCompte();
		double solde = compte.getSolde();
		double tauxRemun = compte.getTauxRemun();

		String sql = "UPDATE comptebancaire SET solde = " + solde + ", tauxRemuneration = " + tauxRemun
				+ " WHERE idCompte = " + idCompte;

		// Etape 4 : exécution d'une requete

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

	public ArrayList<CompteBancaire> lireTousLesComptesBancaireDunClient(Client client) {

		ResultSet rs = null;

		// création de la liste
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
				if (typeCompte == "compte courant") {
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
