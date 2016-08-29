package com.trio.proxibanquev2.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class ConnexionDB {
	static String url = "jdbc:mysql://localhost:3306/proxibanquev2?useSSL=false";
	static String login = "root";
	static String passwd = "";
	static Connection cn = null;
	static Statement st = null;

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
	
	
	public void finConnexionBD(){
		
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
