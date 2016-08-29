package com.trio.proxibanquev2.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.trio.proxibanquev2.domaine.Adresse;
import com.trio.proxibanquev2.domaine.Client;
import com.trio.proxibanquev2.domaine.Conseiller;

public class ClientDAO {

	ConnexionDB connexion = new ConnexionDB();

	public boolean ecrireUnClient(Client client) {
		int result = 0;
		String prenom = client.getPrenom();
		String nom = client.getNom();
		String telephone = client.getTelephone();
		String mail = client.getMail();
		AdresseDAO adresseDao = new AdresseDAO();
		adresseDao.ecrireUneAdresse(client.getAdresse());
		int adresse = adresseDao.lireIdDeLaDerniereAdresse();
		int conseiller = client.getConseiller().getIdConseiller();

		String sql = "INSERT INTO Client (nom, prenom, adresse, telephone, mail, conseiller) VALUES ('"+ nom
				+ "', '" + prenom + "', " + adresse + ", '" + telephone + "', '" + mail + "', " + conseiller + ")";

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

	public Client lireUnClient(int idClient) {
		ResultSet rs = null;

		String sql = "SELECT * FROM client where idClient = " + idClient;

		Client client = new Client();

		try {
			rs = connexion.creationConnexionBD().executeQuery(sql);
		} catch (SQLException e) {

			e.printStackTrace();
		}

		try {
			while (rs.next()) {

				int id = rs.getInt("idClient");
				String nom = rs.getString("nom");
				String prenom = rs.getString("prenom");

				String telephone = rs.getString("telephone");
				String mail = rs.getString("mail");
				int adresse = rs.getInt("adresse");
				int idConseiller = rs.getInt("conseiller");

				client.setIdClient(id);
				client.setPrenom(prenom);
				client.setNom(nom);
				client.setTelephone(telephone);
				client.setMail(mail);
				AdresseDAO adresseDao = new AdresseDAO();
				client.setAdresse(adresseDao.lireUneAdresse(adresse));
				ConseillerDAO conseillerDao = new ConseillerDAO();
				client.setConseiller(conseillerDao.lireUnConseillerById(idConseiller));
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
		return client;

	}
	public boolean modifierUnClient(Client client) {
		int result = 0;
		int idClient = client.getIdClient();
		String prenom = client.getPrenom();
		String nom = client.getNom();
		String mail = client.getMail();
		Adresse adresse = client.getAdresse();
		
		AdresseDAO adresseDao = new AdresseDAO();



		String sql = "UPDATE Client SET nom = '" + nom + "', prenom = '" + prenom + "', mail = '" + mail + "' WHERE idClient = " + idClient;
				


		// Etape 4 : exécution d'une requete

		try {
			result = connexion.creationConnexionBD().executeUpdate(sql);
			adresseDao.modifierUneAdresseById(adresse);
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
	public boolean supprimerUnClientDansUneBase(Client client) {

		int result = 0;
		int idClient = client.getIdClient();
		String sql = "DELETE FROM Client WHERE idClient = " + idClient;
		AdresseDAO adresseDao = new AdresseDAO();
		Adresse adresse = client.getAdresse();

		try {
			result = connexion.creationConnexionBD().executeUpdate(sql);
			adresseDao.supprimerUneAdresseDansUneBase(adresse);
			
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
	

	public ArrayList<Client> lireTousLesClientsDunConseiller(Conseiller conseiller) {

		ResultSet rs = null;

		// création de la liste
		ArrayList<Client> listeDesClients = new ArrayList<Client>();

		try {
			int idConseiller = conseiller.getIdConseiller();

			String sql = "SELECT * FROM Client WHERE conseiller= " + idConseiller;

			rs = connexion.creationConnexionBD().executeQuery(sql);

			while (rs.next()) {
				int id = rs.getInt("idClient");
				String nom = rs.getString("nom");
				String prenom = rs.getString("prenom");

				String telephone = rs.getString("telephone");
				String mail = rs.getString("mail");
				int adresse = rs.getInt("adresse");

				Client client = new Client();
				client.setIdClient(id);
				client.setPrenom(prenom);
				client.setNom(nom);
				client.setTelephone(telephone);
				client.setMail(mail);
				AdresseDAO adresseDao = new AdresseDAO();
				client.setAdresse(adresseDao.lireUneAdresse(adresse));
				ConseillerDAO conseillerDao = new ConseillerDAO();
				client.setConseiller(conseiller);
				listeDesClients.add(client);

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
		return listeDesClients;

	}

	public ArrayList<Client> lireTousLesClientsDansUneBase() {

		ResultSet rs = null;

		// création de la liste
		ArrayList<Client> listeDesClients = new ArrayList<Client>();

		try {

			String sql = "SELECT * FROM Client";

			rs = connexion.creationConnexionBD().executeQuery(sql);

			while (rs.next()) {
				int id = rs.getInt("idClient");
				String nom = rs.getString("nom");
				String prenom = rs.getString("prenom");

				String telephone = rs.getString("telephone");
				String mail = rs.getString("mail");
				int adresse = rs.getInt("adresse");
				int idConseiller = rs.getInt("conseiller");

				Client client = new Client();
				client.setIdClient(id);
				client.setPrenom(prenom);
				client.setNom(nom);
				client.setTelephone(telephone);
				client.setMail(mail);
				AdresseDAO adresseDao = new AdresseDAO();
				client.setAdresse(adresseDao.lireUneAdresse(adresse));
				ConseillerDAO conseillerDao = new ConseillerDAO();
				client.setConseiller(conseillerDao.lireUnConseillerById(idConseiller));
				listeDesClients.add(client);

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
		return listeDesClients;

	}

}
