package com.trio.proxibanquev2.domaine;

import java.util.Date;

/**
 * Classe permettant de creer des comptes epargne h�ritant de compte bancaire.
 * <p>
 * Un compte courant dispose donc d'une cl� d'identification de base de donn�e,
 * d'un
 * <p>
 * numero de compte, d'un solde et d'une date d'ouverture. A ceci s'ajoute le
 * taux de remuneration de l'epargne.
 * <p>
 * 
 * @author Vincent Blameble
 *
 */
public class CompteEpargne extends CompteBancaire {
	private double tauxRemun;

	/**
	 * Constructeur d'objet compte epargne � partir de son identifiant base de
	 * <p>
	 * donn�e, de son num�ro de compte,de son solde et de sa date d'ouverture
	 * <p>
	 * ainsi que de son taux de remuneration
	 * 
	 * @param idCompte
	 *            identifiant base de donn�e
	 * @param numCompte
	 *            num�ro de compte
	 * @param solde
	 *            solde du compte
	 * @param dateOuverture
	 *            date d'ouverture du compte
	 * @param tauxRemun
	 *            taux de remuneration de l'epargne
	 */
	public CompteEpargne(int idCompte, int numCompte, double solde, String dateOuverture,int idClient, double tauxRemun) {
		super(idCompte, numCompte, solde, dateOuverture, idClient);
		this.tauxRemun = tauxRemun;
	}

	/**
	 * Constructeur d'objet compte epargne � partir de son num�ro de compte,de
	 * <p>
	 * son solde et de sa date d'ouverture ainsi que de son taux de
	 * <p>
	 * remuneration.
	 * <p>
	 * Son identifiant base de donn�e est initialise a 0.
	 * 
	 * @param numCompte
	 *            num�ro de compte
	 * @param solde
	 *            solde du compte
	 * @param dateOuverture
	 *            date d'ouverture du compte
	 * @param tauxRemun
	 *            taux de remuneration de l'epargne
	 */
	public CompteEpargne(int numCompte, double solde, String dateOuverture, double tauxRemun,int idClient) {
		super(numCompte, solde, dateOuverture, idClient);
		this.tauxRemun = tauxRemun;
	}

	/**
	 * Constructeur d'objet compte epargne vide. Les variables sont initialis�es
	 * <p>
	 * �: 0 pour l'identifiant, le numero de compte, , le solde ainsi que
	 * <p>
	 * l'identifiant base de donn�e du client associ� et � 0.3 pour le taux
	 * <p>
	 * de remuneration. la date d'ouverture est un null.
	 * 
	 * 
	 */
	public CompteEpargne() {
		super();
		this.tauxRemun = 0.03;
	}

	/**
	 * @return the tauxRemun
	 */
	public double getTauxRemun() {
		return tauxRemun;
	}

	/**
	 * @param tauxRemun
	 *            the tauxRemun to set
	 */
	public void setTauxRemun(double tauxRemun) {
		this.tauxRemun = tauxRemun;
	}

}
