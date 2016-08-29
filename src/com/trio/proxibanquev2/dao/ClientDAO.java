package com.trio.proxibanquev2.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.trio.proxibanquev2.domaine.Adresse;
import com.trio.proxibanquev2.domaine.Client;
import com.trio.proxibanquev2.domaine.Conseiller;

/**
 * Celle classe permet le dialoque entre le programme et la base de donn�es,
 * concernant le CRUD des clients.
 * 
 * @author Thomas T
 *
 */
public class ClientDAO {

	ConnexionDB connexion = new ConnexionDB();

	/**
	 * Cette m�thode eprmet d'�crire un client dans la base de donn�es
	 * 'proxibanquev2'. Cette m�thode prend en param�tre :
	 * 
	 * @param client
	 *            : le client � enregister
	 * @returnun boulean de mani�re � v�rifier l'�criture du client dans la BD.
	 */
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

		String sql = "INSERT INTO Client (nom, prenom, adresse, telephone, mail, conseiller) VALUES ('" + nom + "', '"
				+ prenom + "', " + adresse + ", '" + telephone + "', '" + mail + "', " + conseiller + ")";

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
	 * Cette m�thode permet de lire un client avec comme param�tre d'entr�e :
	 * 
	 * @param idClient
	 *            : l'id du client
	 * @return un objet de type client
	 */
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
				CompteBancaireDAO compteBancaireDao = new CompteBancaireDAO();
				client.setListeCompte(compteBancaireDao.lireTousLesComptesBancaireDunClient(client));
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

	/**
	 * Cette m�thode permet de mettre � jour un client dans une BD. Elle prend
	 * comme param�tre :
	 * 
	 * @param client
	 *            : le client � modifier
	 * @return un boulean pour v�rifier l'�criture du client dans la BD.
	 */
	public boolean modifierUnClient(Client client) {
		int result = 0;
		int idClient = client.getIdClient();
		String prenom = client.getPrenom();
		String nom = client.getNom();
		String mail = client.getMail();
		Adresse adresse = client.getAdresse();

		AdresseDAO adresseDao = new AdresseDAO();

		String sql = "UPDATE Client SET nom = '" + nom + "', prenom = '" + prenom + "', mail = '" + mail
				+ "' WHERE idClient = " + idClient;

		// Etape 4 : ex�cution d'une requete

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

	/**
	 * Cette m�thode permet de supprimer un client dans une BD. Cette m�thode
	 * appelle les m�thodes correspondantes pour la suppression de l'adresse et
	 * des comptes de ce clients
	 * 
	 * @param client
	 *            : le client � supprimer
	 * @returnun boulean pour v�rifier la suppression du client de la BD.
	 */
	public boolean supprimerUnClientDansUneBase(Client client) {

		int result = 0;
		int idClient = client.getIdClient();
		String sql = "DELETE FROM Client WHERE idClient = " + idClient;
		CompteBancaireDAO compteBancaireDao = new CompteBancaireDAO();
		AdresseDAO adresseDao = new AdresseDAO();
		Adresse adresse = client.getAdresse();

		try {
			result = connexion.creationConnexionBD().executeUpdate(sql);
			adresseDao.supprimerUneAdresseDansUneBase(adresse);
			compteBancaireDao.supprimerLesComptesDunClientDansUneBase(client);

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
	 * Cette m�thode permet la cr�ation d'une liste de tous les clients d'un
	 * conseiller.
	 * 
	 * @param conseiller
	 *            : le conseiller dont on veut la liste
	 * @return une liste d'objet de type client
	 */
	public ArrayList<Client> lireTousLesClientsDunConseiller(Conseiller conseiller) {

		ResultSet rs = null;

		// cr�ation de la liste
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

	/**
	 * Cette m�thode permet d'obtenir une liste de tous les clients de la BD
	 * 
	 * @return une liste d'objets de type client
	 */
	public ArrayList<Client> lireTousLesClientsDansUneBase() {

		ResultSet rs = null;

		// cr�ation de la liste
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
