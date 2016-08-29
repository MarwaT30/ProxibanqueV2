package com.trio.proxibanquev2.domaine;

import java.util.ArrayList;
import java.util.List;

/**
 * Classe permettant de creer des Conseillers qui hérite des objets Humains.
 * <p>
 * Un Conseiller dispose donc d'un nom, d'un prenom, d'une adresse d'un
 * telephone,
 * <p>
 * d'une adresse mail. A ceci s'ajoute un login, un mot de passe, une liste de
 * <p>
 * client et un identifiant de base de donnée.
 * 
 * @author Vincent Blameble
 *
 */
public class Conseiller extends Humain {

	private String login;
	private String password;
	private List<Client> listClient;
	private int idConseiller;

	/**
	 * Constructeur d'objet conseiller à partir de son nom, son prenom, son
	 * <p>
	 * adresse, son numero de telephone,son adresse mail, sa liste de client et
	 * <p>
	 * son identifiant en base de donnée.les variables sont initialisées à:
	 * 
	 * @param nom
	 *            nom du client
	 * @param prenom
	 *            prenom du client
	 * @param adresse
	 *            adresse du client
	 * @param telephone
	 *            numero de telephone
	 * @param mail
	 *            adresse mail
	 * @param login
	 *            identifiant de connection du conseiller sur l'application
	 * @param password
	 *            mot de passe du conseiller sur l'application
	 * @param listClient
	 *            liste des clients assignés à ce conseiller
	 * @param idConseiller
	 *            identifiant dans la base de donnée
	 */
	public Conseiller(String nom, String prenom, Adresse adresse, String telephone, String mail, String login,
			String password, List<Client> listClient, int idConseiller) {
		super(nom, prenom, adresse, telephone, mail);
		this.login = login;
		this.password = password;
		this.listClient = listClient;
		this.idConseiller = idConseiller;
	}

	/**
	 * Constructeur d'objet conseiller à partir de son nom, son prenom, son
	 * <p>
	 * adresse, son numero de telephone,son adresse mail, et sa liste de client.
	 * <p>
	 * Son identifiant en base de donnée est initialisé à: 0.
	 * 
	 * @param nom
	 *            nom du client
	 * @param prenom
	 *            prenom du client
	 * @param adresse
	 *            adresse du client
	 * @param telephone
	 *            numero de telephone
	 * @param mail
	 *            adresse mail
	 * @param login
	 *            identifiant de connection du conseiller sur l'application
	 * @param password
	 *            mot de passe du conseiller sur l'application
	 * @param listClient
	 *            liste des clients assignés à ce conseiller
	 */
	public Conseiller(String nom, String prenom, Adresse adresse, String telephone, String mail, String login,
			String password, List<Client> listClient) {
		this(nom, prenom, adresse, telephone, mail, login, password, listClient, 0);
	}

	/**
	 * Constructeur d'objet conseiller vide. les variables nom,
	 * <p>
	 * prenom,telephone,mail sont initialisées comme un String "".
	 * <p>
	 * L'adresse est un objet adresse creer par le constructeur vide. la liste
	 * <p>
	 * de compte est un new arrayList() et l'id conseiller est initialisé a 0
	 * 
	 * @param nom
	 *            nom du client
	 * @param prenom
	 *            prenom du client
	 * @param adresse
	 *            adresse du client
	 * @param telephone
	 *            numero de telephone
	 * @param mail
	 *            adresse mail
	 * @param login
	 *            identifiant de connection du conseiller sur l'application
	 * @param password
	 *            mot de passe du conseiller sur l'application
	 * @param listClient
	 *            liste des clients assignés à ce conseiller
	 */
	
	public Conseiller() {
		super();
		this.login = "";
		this.password = "";
		this.listClient = new ArrayList<Client>();
		this.idConseiller = 0;
	}

	/**
	 * @return the idConseiller
	 */
	public int getIdConseiller() {
		return idConseiller;
	}

	/**
	 * @param idConseiller
	 *            the idConseiller to set
	 */
	public void setIdConseiller(int idConseiller) {
		this.idConseiller = idConseiller;
	}

	/**
	 * @return the login
	 */
	public String getLogin() {
		return login;
	}

	/**
	 * @param login
	 *            the login to set
	 */
	public void setLogin(String login) {
		this.login = login;
	}

	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @param password
	 *            the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * @return the listClient
	 */
	public List<Client> getListClient() {
		return listClient;
	}

	/**
	 * @param listClient
	 *            the listClient to set
	 */
	public void setListClient(List<Client> listClient) {
		this.listClient = listClient;
	}

}
