package com.trio.proxibanquev2.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.trio.proxibanquev2.domaine.Adresse;

/**
 * Celle classe permet le dialoque entre le programme et la base de données,
 * concernant le CRUD des adresses.
 * 
 * @author Thomas T
 *
 */
public class AdresseDAO {
	ConnexionDB connexion = new ConnexionDB();

	/**
	 * Cette méthode eprmet d'écrire une adresse dans la table du même nom de la
	 * base de données 'proxibanquev2'. Cette méthode prend en paramètre :
	 * 
	 * @param adresse
	 *            : une adresse
	 * @return un boulean de manière à vérifier l'écriture de l'adresse dans la
	 *         BD.
	 */
	public boolean ecrireUneAdresse(Adresse adresse) {
		int result = 0;
		String numRue = adresse.getNumRue();
		String typeDeRue = adresse.getTypeDeRue();
		String nomDeRue = adresse.getNomDeRue();
		int codePostal = adresse.getCodePostal();
		String ville = adresse.getVille();

		// TODO

		String sql = "INSERT INTO Adresse (numRue, typeDeRue, nomDeRue, codePostal, ville) VALUES ('" + numRue + "', '"
				+ typeDeRue + "', '" + nomDeRue + "', " + codePostal + ", '" + ville + "')";

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

	/**
	 * Cette méthode permet de lire l'id de la dernière adresse entrée (id max
	 * suite à l'auto-incrément).
	 * 
	 * @return idAdresse
	 */
	public int lireIdDeLaDerniereAdresse() {
		ResultSet rs = null;

		String sql = "SELECT MAX(idAdresse) FROM adresse";
		int idAdresse = 0;

		try {
			rs = connexion.creationConnexionBD().executeQuery(sql);
		} catch (SQLException e) {

			e.printStackTrace();
		}

		try {
			while (rs.next()) {
				idAdresse = rs.getInt("MAX(idAdresse)");
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
		return idAdresse;

	}

	/**
	 * Cette méthode permet de lire une adresse avec comme paramètre d'entrée :
	 * 
	 * @param adresse
	 *            : c'est l'idAdresse.
	 * @return un objet de type Adresse
	 */
	public Adresse lireUneAdresse(int adresse) {
		ResultSet rs = null;

		String sql = "SELECT * FROM adresse where idAdresse = " + adresse;

		Adresse adresse1 = new Adresse();

		try {
			rs = connexion.creationConnexionBD().executeQuery(sql);
		} catch (SQLException e) {

			e.printStackTrace();
		}

		try {
			while (rs.next()) {

				int idAdresse = rs.getInt("idAdresse");
				String numRue = rs.getString("numRue");
				String typeDeRue = rs.getString("typeDeRue");
				String nomDeRue = rs.getString("nomDeRue");
				int codePostal = rs.getInt("codePostal");
				String ville = rs.getString("ville");

				adresse1.setIdAdresse(idAdresse);
				adresse1.setNumRue(numRue);
				adresse1.setTypeDeRue(typeDeRue);
				adresse1.setNomDeRue(nomDeRue);
				adresse1.setCodePostal(codePostal);
				adresse1.setVille(ville);

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
		return adresse1;

	}

	/**
	 * Cette méthode permet de mettre à jour une adresse dans une BD. Elle prend
	 * comme paramètre :
	 * 
	 * @param adresse
	 *            : l'adresse mise à jour.
	 * @return un boulean pour vérifier l'écriture de l'adresse dans la BD.
	 */
	public boolean modifierUneAdresseById(Adresse adresse) {
		int result = 0;
		int idAdresse = adresse.getIdAdresse();
		String numRue = adresse.getNumRue();
		String typeDeRue = adresse.getTypeDeRue();
		String nomDeRue = adresse.getNomDeRue();
		int codePostal = adresse.getCodePostal();
		String ville = adresse.getVille();

		String sql = "UPDATE Adresse SET numRue = '" + numRue + "', typeDeRue = '" + typeDeRue + "', nomDeRue = '"
				+ nomDeRue + "', codePostal = " + codePostal + ", ville = '" + ville + "' WHERE idAdresse = "
				+ idAdresse;

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
	 * Cette méthode permet de supprimer une adresse dans une BD
	 * 
	 * @param adresse
	 *            : l'adresse à supprimer
	 * @return un boulean pour vérifier la suppression de l'adresse dans la BD.
	 */
	public boolean supprimerUneAdresseDansUneBase(Adresse adresse) {

		int result = 0;
		int idAdresse = adresse.getIdAdresse();
		String sql = "DELETE FROM Adresse WHERE idAdresse = " + idAdresse;

		try {
			result = connexion.creationConnexionBD().executeUpdate(sql);
		} catch (SQLException e) {

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
	 * Cette méthode permet d'obtenir une liste de toutes les adresses dans la
	 * base de données.
	 * 
	 * @return une liste d'adresses.
	 */
	public ArrayList<Adresse> lireToutesLesAdressesDansUneBase() {

		ResultSet rs = null;

		// création de la liste
		ArrayList<Adresse> listeDesAdresses = new ArrayList<Adresse>();

		try {

			String sql = "SELECT * FROM Adresse";

			rs = connexion.creationConnexionBD().executeQuery(sql);

			while (rs.next()) {
				int idAdresse = rs.getInt("idAdresse");
				String numRue = rs.getString("numRue");
				String typeDeRue = rs.getString("typeDeRue");
				String nomDeRue = rs.getString("nomDeRue");
				String ville = rs.getString("ville");
				int codePostal = rs.getInt("codePostal");

				Adresse adresse = new Adresse(idAdresse, numRue, typeDeRue, nomDeRue, codePostal, ville);
				listeDesAdresses.add(adresse);

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
		return listeDesAdresses;

	}

}
