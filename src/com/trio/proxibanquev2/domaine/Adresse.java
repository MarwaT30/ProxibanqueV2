package com.trio.proxibanquev2.domaine;

/**
 * Classe permettant de creer des objets Adresses.
 * <p>
 * Une adresse dispose d'une clé d'identification dans la base de données, d'un
 * <p>
 * numéro de rue, d'un type de rue; d'un nom de rue, d'un code postal et d'un
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
	 * Constructeur d'objet adresse à partir de son identifiant Base de
	 * <p>
	 * donnée,d'un numéro de rue, d'un type de rue; d'un nom de rue, d'un code
	 * <p>
	 * postal et d'un nom de ville.
	 * @param idAdresse
	 *            clé d'identification dans la base de données
	 * @param numRue
	 *            numéro de rue
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
	 * Constructeur d'objet adresse à partir d'un numéro de rue,
	 * <p>
	 * d'un type de rue; d'un nom de rue, d'un code postal et d'un nom de ville.
	 * <p>
	 * La clé de base de donnée idAdresse est initialisé a 0 par défaut et sera
	 * <p>
	 * automatiquement généré dans la base de donnée par l'auto-incrementation
	 * 
	 * @param idAdresse
	 *            clé d'identification dans la base de données
	 * @param numRue
	 *            numéro de rue
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
	 * La clé de base de donnée idAdresse et le code postal sont initialisés a 0
	 * <p>
	 * et tout les autre champs sont initialisé par un String ""
	 * 
	 * @param idAdresse
	 *            clé d'identification dans la base de données
	 * @param numRue
	 *            numéro de rue
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
