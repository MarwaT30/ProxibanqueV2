package com.trio.proxibanquev2.domaine;

import java.util.Date;

/**
 * Classe permettant de creer des comptes courants h�ritant de compte bancaire .
 * <p>
 * Un compte courant dispose donc d'une cl� d'identification de base de donn�e,
 * d'un
 * <p>
 * numero de compte, d'un solde et d'une date d'ouverture. A ceci s'ajoute la
 * limite de d�couvert autoris�e.
 * <p>
 * 
 * @author Vincent Blameble
 *
 */
public class CompteCourant extends CompteBancaire {

	private double decouvertAutorise;

	/**
	 * Constructeur d'objet compte courant � partir de son identifiant base de
	 * <p>
	 * donn�e, de son num�ro de compte,de son solde et de sa date d'ouverture
	 * <p>
	 * ainsi que de sa limite de d�couvert autoris�e.
	 * 
	 * @param idCompte
	 *            identifiant base de donn�e
	 * @param numCompte
	 *            num�ro de compte
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
	 * Constructeur d'objet compte courant � partir de son num�ro de compte,de
	 * <p>
	 * son solde et de sa date d'ouverture ainsi que de sa limite de d�couvert
	 * <p>
	 * autoris�e.
	 * <p>
	 * Son identifiant base de donn�e est initialise a 0.
	 * 
	 * @param numCompte
	 *            num�ro de compte
	 * @param solde
	 *            solde du compte
	 * @param dateOuverture
	 *            date d'ouverture du compte
	 * @param decouvertAutorise
	 *            limite de d�couvert autoris�e
	 */
	public CompteCourant(int numCompte, double solde, String dateOuverture, int idClient, double decouvertAutorise) {
		super(numCompte, solde, dateOuverture, idClient);
		this.decouvertAutorise = decouvertAutorise;
	}

	/**
	 * Constructeur d'objet compte courant vide. Les variables sont initialis�es
	 * <p>
	 * �: 0 pour l'identifiant, le numero de compte, le solde ainsi
	 * <p>
	 * que l'identifiant base de donn�e du client associ� et �
	 * <p>
	 * 1000 pour le decouvert autoris�. La date d'ouverture est un null.
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
