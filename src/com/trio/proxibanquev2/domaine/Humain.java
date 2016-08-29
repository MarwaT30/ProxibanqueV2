package com.trio.proxibanquev2.domaine;

/**
 * Classe permettant d'utiliser des personnes.
 * <p>
 * Un humain dispose d'un nom, d'un prenom, d'une adresse d'un telephone et
 * <p>
 * d'une adresse mail.
 * @author Vincent Blameble
 *
 */
public abstract class Humain {

	private String nom;
	private String prenom;
	private Adresse adresse;
	private String telephone;
	private String mail;

	/**
	 * Constructeur d'objet humain à partir de son nom, son prenom, son adresse,
	 * son numero de telephone
	 * <p>
	 * et son adresse mail.
	 * 
	 * @param nom
	 *            nom de famille
	 * @param prenom
	 *            prenom de l'individu
	 * @param adresse
	 *            son adresse complete
	 * @param telephone
	 *            numero de telephone
	 * @param mail
	 *            adresse mail
	 */
	public Humain(String nom, String prenom, Adresse adresse, String telephone, String mail) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.adresse = adresse;
		this.telephone = telephone;
		this.mail = mail;
	}

	/**
	 * Constructeur d'objet humain vide.
	 * <p>
	 * les variables om, prenom,telephone,mail sont initialisées comme un String
	 * "".
	 * <p>
	 * L'adresse est un objet adresse creer par le constructeur vide.

	 */
	public Humain() {
		this("", "", new Adresse(), "", "");
	}

	/**
	 * @return the nom
	 */
	public String getNom() {
		return nom;
	}

	/**
	 * @param nom
	 *            the nom to set
	 */
	public void setNom(String nom) {
		this.nom = nom;
	}

	/**
	 * @return the prenom
	 */
	public String getPrenom() {
		return prenom;
	}

	/**
	 * @param prenom
	 *            the prenom to set
	 */
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	/**
	 * @return the adresse
	 */
	public Adresse getAdresse() {
		return adresse;
	}

	/**
	 * @param adresse
	 *            the adresse to set
	 */
	public void setAdresse(Adresse adresse) {
		this.adresse = adresse;
	}

	/**
	 * @return the telephone
	 */
	public String getTelephone() {
		return telephone;
	}

	/**
	 * @param telephone
	 *            the telephone to set
	 */
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	/**
	 * @return the mail
	 */
	public String getMail() {
		return mail;
	}

	/**
	 * @param mail
	 *            the mail to set
	 */
	public void setMail(String mail) {
		this.mail = mail;
	}

}
