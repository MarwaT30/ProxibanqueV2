package com.trio.proxibanquev2.domaine;

import java.util.ArrayList;
import java.util.List;

/**
 * Classe permettant de creer des objets Clients qui hérite des objets Humains .
 * <p>
 * Un client dispose d'un nom, d'un prenom, d'une adresse d'un telephone et
 * <p>
 * d'une adresse mail en tant qu'humain.
 * <p>
 * A ceci s'ajoute un identifiant base de donnée, et une liste de compte
 * <p>
 * bancaire.
 * 
 * @author Vincent Blameble
 *
 */
public class Client extends Humain {

	private List<CompteBancaire> listeCompte;
	private Conseiller conseiller;
	private int idClient;

	/**
	 * Constructeur d'objet Clients à partir de son nom, son prenom, son
	 * <p>
	 * adresse, son numero de telephone,son adresse mail, sa liste de compte et
	 * <p>
	 * son identifiant en base de donnée.
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
	 * @param listeCompte
	 *            liste des compte bancaire du client
	 * @param idClient
	 *            identifiant du client dans la base de donnée
	 */
	public Client(String nom, String prenom, Adresse adresse, String telephone, String mail,
			List<CompteBancaire> listeCompte, Conseiller conseiller, int idClient) {
		super(nom, prenom, adresse, telephone, mail);
		this.conseiller = conseiller;
		this.listeCompte = listeCompte;
		this.idClient = idClient;
	}

	/**
	 * Constructeur d'objet Clients à partir de de son nom, son prenom, son
	 * <p>
	 * adresse, son numero de telephone,son adresse mail, sa liste de compte
	 * <p>
	 * les variables sont initialisées à: 0 pour l'identifiant en base de
	 * <p>
	 * donnée.
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
	 * @param listeCompte
	 *            liste des compte bancaire du client
	 */
	public Client(String nom, String prenom, Adresse adresse, String telephone, String mail, 
			List<CompteBancaire> listeCompte, Conseiller conseiller) {
		this(nom, prenom, adresse, telephone, mail, listeCompte, conseiller,0);
	}

	/**
	 * Constructeur d'objet Clients vides. les variables nom,
	 * <p>
	 * prenom,telephone,mail sont initialisées comme un String "".
	 * <p>
	 * L'adresse est un objet adresse creer par le constructeur vide. la liste
	 * <p>
	 * de compte est un new arrayList et l'id client est initialisé a 0
	 * 
	 */
	public Client() {
		super();
		this.listeCompte = new ArrayList<CompteBancaire>();
		this.conseiller=new Conseiller();
		this.idClient = 0;
		
	}

	/**
	 * @return the idClient
	 */
	public int getIdClient() {
		return idClient;
	}

	/**
	 * @param idClient
	 *            the idClient to set
	 */
	public void setIdClient(int idClient) {
		this.idClient = idClient;
	}

	/**
	 * @return the listeCompte
	 */
	public List<CompteBancaire> getListeCompte() {
		return listeCompte;
	}

	/**
	 * @param listeCompte
	 *            the listeCompte to set
	 */
	public void setListeCompte(List<CompteBancaire> listeCompte) {
		this.listeCompte = listeCompte;
	}

	/**
	 * @return the conseiller
	 */
	public Conseiller getConseiller() {
		return conseiller;
	}

	/**
	 * @param conseiller the conseiller to set
	 */
	public void setConseiller(Conseiller conseiller) {
		this.conseiller = conseiller;
	}

	
	
}
