package com.trio.proxibanquev2.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;

/**
 * Classe permettant la connexion � la base de donn�es proxibanquev2 sur mySQL.
 * 
 * @author Thomas T
 *
 */
public class ConnexionDB {
	ResourceBundle bundle = ResourceBundle.getBundle("com.trio.proxibanquev2.domaine.properties.config");
	String url = bundle.getString("sgbd.url");
	String login = bundle.getString("sgbd.login");
	String passwd = bundle.getString("sgbd.password");
	static Connection cn = null;
	static Statement st = null;

	/**
	 * Cette m�thode permet la connexion � la base de donn�es
	 * 
	 * @return st : statement
	 */
	public Statement creationConnexionBD() {

		try {
			// Etape 1 : Chargement du driver
			Class.forName(bundle.getString("sgbd.driver"));
			// Etape 2 : r�cup�ration de la connexion
			cn = DriverManager.getConnection(url, login, passwd);
			// Etape 3 : Cr�ation d'un statement
			st = cn.createStatement();

		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return st;
	}

	/**
	 * Cette m�thode permet de clore les variable de connexion et statement.
	 * 
	 */
	public void finConnexionBD() {

		{
			try {
				// Etape 5 : lib�rer ressources de la m�moire
				cn.close();
				st.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

}
