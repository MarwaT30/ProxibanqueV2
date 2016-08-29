package com.trio.proxibanquev2.domaine;

import java.util.Date;

/**
 * Classe permettant de utilser des objets comptes bancaires .
 * <p>
 * Un compte bancaire dispose d'une clé d'identification de base de donnée, d'un
 * <p>
 * numero de compte, d'un solde et d'une date d'ouverture.
 * 
 * @author Vincent Blameble
 *
 */
public abstract class CompteBancaire {

	private int idCompte;
	private int numCompte;
	private double solde;
	private String dateOuverture;
	private int idClient;

	/**
	 * Constructeur d'objet compte bancaire à partir de son identifiant base de
	 * <p>
	 * donnée, de son numéro de compte,de son solde et de sa date d'ouverture.
	 * 
	 * @param idCompte
	 *            identifiant base de donnée
	 * @param numCompte
	 *            numéro de compte
	 * @param solde
	 *            solde du compte
	 * @param dateOuverture
	 *            date d'ouverture du compte
	 * @param idClient
	 *            identifiant du client associé au compte
	 *            
	 */
	public CompteBancaire(int idCompte, int numCompte, double solde, String dateOuverture, int idClient) {
		super();
		this.idCompte = idCompte;
		this.numCompte = numCompte;
		this.solde = solde;
		this.dateOuverture = dateOuverture;
		this.idClient = idClient;

	}

	/**
	 * Constructeur d'objet compte bancaire à partir de son numéro de compte,
	 * <p>
	 * de son solde, de sa date d'ouverture et de l'identifiant base de donnée
	 * <p>
	 * du client associé.l'identifiant est initialisée à: 0.
	 * 
	 * @param numCompte
	 *            numéro de compte
	 * @param solde
	 *            solde du compte
	 * @param dateOuverture
	 *            date d'ouverture du compte
	 * @param idClient
	 *            identifiant du client associé au compte
	 */
	public CompteBancaire(int numCompte, double solde, String dateOuverture, int idClient) {
		this(0, numCompte, solde, dateOuverture, idClient);
	}

	/**
	 * Constructeur d'objet compte bancaire vide. Les variables sont
	 * initialisées
	 * <p>
	 * à: 0 pour l'identifiant du compte, le numero de compte, le solde ainsi
	 * <p>
	 * que l'identifiant base de donnée du client associé . la date d'ouverture
	 * <p>
	 * est un null.
	 * 
	 */
	public CompteBancaire() {
		this(0, 0, 0, "", 0);
	}

	/**
	 * @return the idCompte
	 */
	public int getIdCompte() {
		return idCompte;
	}

	/**
	 * @param idCompte
	 *            the idCompte to set
	 */
	public void setIdCompte(int idCompte) {
		this.idCompte = idCompte;
	}

	/**
	 * @return the numCompte
	 */
	public int getNumCompte() {
		return numCompte;
	}

	/**
	 * @param numCompte
	 *            the numCompte to set
	 */
	public void setNumCompte(int numCompte) {
		this.numCompte = numCompte;
	}

	/**
	 * @return the solde
	 */
	public double getSolde() {
		return solde;
	}

	/**
	 * @param solde
	 *            the solde to set
	 */
	public void setSolde(double solde) {
		this.solde = solde;
	}

	/**
	 * @return the dateOuverture
	 */
	public String getDateOuverture() {
		return dateOuverture;
	}

	/**
	 * @param dateOuverture
	 *            the dateOuverture to set
	 */
	public void setDateOuverture(String dateOuverture) {
		this.dateOuverture = dateOuverture;
	}

	public void ajouterAuSolde(double montant) {
		this.solde = this.solde + montant;
	}

	public void enleverAuSolde(double montant) {
		this.solde = this.solde - montant;
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

}
