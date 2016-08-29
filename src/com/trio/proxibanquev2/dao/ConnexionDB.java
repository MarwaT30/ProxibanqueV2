package com.trio.proxibanquev2.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Classe permettant la connexion à la base de données proxibanquev2 sur mySQL.
 * 
 * @author Thomas T
 *
 */
public class ConnexionDB {
	static String url = "jdbc:mysql://localhost:3306/proxibanquev2?useSSL=false";
	static String login = "root";
	static String passwd = "";
	static Connection cn = null;
	static Statement st = null;

	/**
	 * Cette méthode permet la connexion à la base de données
	 * 
	 * @return st : statement
	 */
	public Statement creationConnexionBD() {

		try {
			// Etape 1 : Chargement du driver
			Class.forName("com.mysql.jdbc.Driver");
			// Etape 2 : récupération de la connexion
			cn = DriverManager.getConnection(url, login, passwd);
			// Etape 3 : Création d'un statement
			st = cn.createStatement();

		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return st;
	}

	/**
	 * Cette méthode permet de clore les variable de connexion et statement.
	 * 
	 */
	public void finConnexionBD() {

		{
			try {
				// Etape 5 : libérer ressources de la mémoire
				cn.close();
				st.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

}
