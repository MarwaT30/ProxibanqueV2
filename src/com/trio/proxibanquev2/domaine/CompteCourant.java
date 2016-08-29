package com.trio.proxibanquev2.domaine;

import java.util.Date;

/**
 * Classe permettant de creer des comptes courants héritant de compte bancaire .
 * <p>
 * Un compte courant dispose donc d'une clé d'identification de base de donnée,
 * d'un
 * <p>
 * numero de compte, d'un solde et d'une date d'ouverture. A ceci s'ajoute la
 * limite de découvert autorisée.
 * <p>
 * 
 * @author Vincent Blameble
 *
 */
public class CompteCourant extends CompteBancaire {

	private double decouvertAutorise;

	/**
	 * Constructeur d'objet compte courant à partir de son identifiant base de
	 * <p>
	 * donnée, de son numéro de compte,de son solde et de sa date d'ouverture
	 * <p>
	 * ainsi que de sa limite de découvert autorisée.
	 * 
	 * @param idCompte
	 *            identifiant base de donnée
	 * @param numCompte
	 *            numéro de compte
	 * @param solde
	 *            solde du compte
	 * @param dateOuverture
	 *            date d'ouverture du compte
	 * @param decouvertAutorise
	 */
	public CompteCourant(int idCompte, int numCompte, double solde, String dateOuverture, int idClient,
			double decouvertAutorise) {
		super(idCompte, numCompte, solde, dateOuverture, idClient);
		this.decouvertAutorise = decouvertAutorise;
	}

	/**
	 * Constructeur d'objet compte courant à partir de son numéro de compte,de
	 * <p>
	 * son solde et de sa date d'ouverture ainsi que de sa limite de découvert
	 * <p>
	 * autorisée.
	 * <p>
	 * Son identifiant base de donnée est initialise a 0.
	 * 
	 * @param numCompte
	 *            numéro de compte
	 * @param solde
	 *            solde du compte
	 * @param dateOuverture
	 *            date d'ouverture du compte
	 * @param decouvertAutorise
	 *            limite de découvert autorisée
	 */
	public CompteCourant(int numCompte, double solde, String dateOuverture, int idClient, double decouvertAutorise) {
		super(numCompte, solde, dateOuverture, idClient);
		this.decouvertAutorise = decouvertAutorise;
	}

	/**
	 * Constructeur d'objet compte courant vide. Les variables sont initialisées
	 * <p>
	 * à: 0 pour l'identifiant, le numero de compte, le solde ainsi
	 * <p>
	 * que l'identifiant base de donnée du client associé et à
	 * <p>
	 * 1000 pour le decouvert autorisé. La date d'ouverture est un null.
	 * 
	 */
	public CompteCourant() {
		super();
		this.decouvertAutorise = 1000;
	}

	/**
	 * @return the decouvertAutorise
	 */
	public double getDecouvertAutorise() {
		return decouvertAutorise;
	}

	/**
	 * @param decouvertAutorise
	 *            the decouvertAutorise to set
	 */
	public void setDecouvertAutorise(double decouvertAutorise) {
		this.decouvertAutorise = decouvertAutorise;
	}

}
