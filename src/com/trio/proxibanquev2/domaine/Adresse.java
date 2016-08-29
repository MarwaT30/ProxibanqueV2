package com.trio.proxibanquev2.domaine;

/**
 * Classe permettant de creer des objets Adresses.
 * <p>
 * Une adresse dispose d'une cl� d'identification dans la base de donn�es, d'un
 * <p>
 * num�ro de rue, d'un type de rue; d'un nom de rue, d'un code postal et d'un
 * <p>
 * nom de ville.
 * 
 * @author Vincent Blameble
 *
 */
public class Adresse {

	private int idAdresse;
	private String numRue;
	private String typeDeRue;
	private String nomDeRue;
	private int codePostal;
	private String ville;

	/**
	 * Constructeur d'objet adresse � partir de son identifiant Base de
	 * <p>
	 * donn�e,d'un num�ro de rue, d'un type de rue; d'un nom de rue, d'un code
	 * <p>
	 * postal et d'un nom de ville.
	 * @param idAdresse
	 *            cl� d'identification dans la base de donn�es
	 * @param numRue
	 *            num�ro de rue
	 * @param typeDeRue
	 *            type de rue
	 * @param nomDeRue
	 *            nom de rue
	 * @param codePostal
	 *            code postal
	 * @param ville
	 *            nom de ville
	 */
	public Adresse(int idAdresse, String numRue, String typeDeRue, String nomDeRue, int codePostal, String ville) {
		this.idAdresse = idAdresse;
		this.numRue = numRue;
		this.typeDeRue = typeDeRue;
		this.nomDeRue = nomDeRue;
		this.codePostal = codePostal;
		this.ville = ville;
	}

	/**
	 * Constructeur d'objet adresse � partir d'un num�ro de rue,
	 * <p>
	 * d'un type de rue; d'un nom de rue, d'un code postal et d'un nom de ville.
	 * <p>
	 * La cl� de base de donn�e idAdresse est initialis� a 0 par d�faut et sera
	 * <p>
	 * automatiquement g�n�r� dans la base de donn�e par l'auto-incrementation
	 * 
	 * @param idAdresse
	 *            cl� d'identification dans la base de donn�es
	 * @param numRue
	 *            num�ro de rue
	 * @param typeDeRue
	 *            type de rue
	 * @param nomDeRue
	 *            nom de rue
	 * @param codePostal
	 *            code postal
	 * @param ville
	 *            nom de ville
	 */
	public Adresse(String numRue, String typeDeRue, String nomDeRue, int codePostal, String ville) {
		this(0, numRue, typeDeRue, nomDeRue, codePostal, ville);
	}

	/**
	 * Constructeur d'objet adresse vide.
	 * <p>
	 * La cl� de base de donn�e idAdresse et le code postal sont initialis�s a 0
	 * <p>
	 * et tout les autre champs sont initialis� par un String ""
	 * 
	 * @param idAdresse
	 *            cl� d'identification dans la base de donn�es
	 * @param numRue
	 *            num�ro de rue
	 * @param typeDeRue
	 *            type de rue
	 * @param nomDeRue
	 *            nom de rue
	 * @param codePostal
	 *            code postal
	 * @param ville
	 *            nom de ville
	 */
	public Adresse() {
		this(0, "", "", "", 0, "");
	}

	/**
	 * @return the idAdresse
	 */
	public int getIdAdresse() {
		return idAdresse;
	}

	/**
	 * @param idAdresse
	 *            the idAdresse to set
	 */
	public void setIdAdresse(int idAdresse) {
		this.idAdresse = idAdresse;
	}

	/**
	 * @return the numRue
	 */
	public String getNumRue() {
		return numRue;
	}

	/**
	 * @param numRue
	 *            the numRue to set
	 */
	public void setNumRue(String numRue) {
		this.numRue = numRue;
	}

	/**
	 * @return the typeDeRue
	 */
	public String getTypeDeRue() {
		return typeDeRue;
	}

	/**
	 * @param typeDeRue
	 *            the typeDeRue to set
	 */
	public void setTypeDeRue(String typeDeRue) {
		this.typeDeRue = typeDeRue;
	}

	/**
	 * @return the nomDeRue
	 */
	public String getNomDeRue() {
		return nomDeRue;
	}

	/**
	 * @param nomDeRue
	 *            the nomDeRue to set
	 */
	public void setNomDeRue(String nomDeRue) {
		this.nomDeRue = nomDeRue;
	}

	/**
	 * @return the codePostal
	 */
	public int getCodePostal() {
		return codePostal;
	}

	/**
	 * @param codePostal
	 *            the codePostal to set
	 */
	public void setCodePostal(int codePostal) {
		this.codePostal = codePostal;
	}

	/**
	 * @return the ville
	 */
	public String getVille() {
		return ville;
	}

	/**
	 * @param ville
	 *            the ville to set
	 */
	public void setVille(String ville) {
		this.ville = ville;
	}

}
