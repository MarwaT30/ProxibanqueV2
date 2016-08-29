package com.trio.proxibanquev2.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.trio.proxibanquev2.domaine.Conseiller;

public class ConseillerDAO {
	ConnexionDB connexion = new ConnexionDB();

	public Conseiller lireUnConseiller(String login, String password) {
		ResultSet rs = null;

		String sql = "SELECT * FROM conseiller where identifiant = '" + login + "' AND motDePasse = '" + password
				+ "'";

		Conseiller conseiller = new Conseiller();

		try {
			rs = connexion.creationConnexionBD().executeQuery(sql);
		} catch (SQLException e) {

			e.printStackTrace();
		}

		try {
			while (rs.next()) {

				int id = rs.getInt("idConseiller");
				String nom = rs.getString("nom");
				String prenom = rs.getString("prenom");
				login = rs.getString("login");
				password = rs.getString("password");
				String telephone = rs.getString("telephone");
				String mail = rs.getString("mail");
				int adresse = rs.getInt("adresse");

				conseiller.setIdConseiller(id);
				conseiller.setPrenom(prenom);
				conseiller.setNom(nom);
				conseiller.setLogin(login);
				conseiller.setPassword(password);
				conseiller.setTelephone(telephone);
				conseiller.setMail(mail);
				AdresseDAO adresseDao = new AdresseDAO();
				conseiller.setAdresse(adresseDao.lireUneAdresse(adresse));
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
		return conseiller;

	}
	public Conseiller lireUnConseillerById(int idConseiller) {
		ResultSet rs = null;

		String sql = "SELECT * FROM conseiller where idConseiller = " + idConseiller;

		Conseiller conseiller = new Conseiller();

		try {
			rs = connexion.creationConnexionBD().executeQuery(sql);
		} catch (SQLException e) {

			e.printStackTrace();
		}

		try {
			while (rs.next()) {

				String nom = rs.getString("nom");
				String prenom = rs.getString("prenom");
				String login = rs.getString("login");
				String password = rs.getString("password");
				String telephone = rs.getString("telephone");
				String mail = rs.getString("mail");
				int adresse = rs.getInt("adresse");

				conseiller.setIdConseiller(idConseiller);
				conseiller.setPrenom(prenom);
				conseiller.setNom(nom);
				conseiller.setLogin(login);
				conseiller.setPassword(password);
				conseiller.setTelephone(telephone);
				conseiller.setMail(mail);
				AdresseDAO adresseDao = new AdresseDAO();
				conseiller.setAdresse(adresseDao.lireUneAdresse(adresse));
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
		return conseiller;

	}

}
