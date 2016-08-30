package com.trio.proxibanquev2.presentation;

import java.util.List;

import com.trio.proxibanquev2.domaine.Client;
import com.trio.proxibanquev2.domaine.CompteBancaire;
import com.trio.proxibanquev2.domaine.CompteCourant;
import com.trio.proxibanquev2.domaine.CompteEpargne;

public class Utilejsp {

	public static String tableauClient(List<Client> listeClient) {
		String tableau;
		tableau = "";
		int numerodeligne = 1;
		for (Client client : listeClient) {

			tableau = tableau.concat("<tr><td>" + numerodeligne + "</td>");
			tableau = tableau.concat("<td>" + client.getNom() + "</td>");
			tableau = tableau.concat("<td>" + client.getPrenom() + "</td>");
			tableau = tableau.concat("<td>" + client.getAdresse().toString() + "</td>");
			tableau = tableau.concat("<td>" + client.getTelephone() + "</td>");
			tableau = tableau.concat("<td>" + client.getMail() + "</td>");
			tableau = tableau.concat("</tr>");
			numerodeligne++;
		}
		return tableau;
	}

	public static String ligneClient(Client client) {
		String tableau;
		tableau = "";
		tableau = tableau.concat("<tr><td>" + client.getIdClient() + "</td>");
		tableau = tableau.concat("<td>" + client.getNom() + "</td>");
		tableau = tableau.concat("<td>" + client.getPrenom() + "</td>");
		tableau = tableau.concat("<td>" + client.getAdresse().toString() + "</td>");
		tableau = tableau.concat("<td>" + client.getTelephone() + "</td>");
		tableau = tableau.concat("<td>" + client.getMail() + "</td>");
		tableau = tableau.concat("</tr>");
		return tableau;
	}

	public static String listeDeroulanteClientUser(List<Client> listeClient) {
		String liste;
		liste = "";
		for (Client client : listeClient) {
			liste = liste.concat("<li><a href='#'>" + client.getNom() + " " + client.getPrenom() + "</a></li>");
		}
		return liste;
	}

	public static String numeroCompteCourantClient(Client client) {
		String tableau;
		tableau = "";
		boolean existecourant = false;
		for (CompteBancaire compte : client.getListeCompte()) {
			if (compte instanceof CompteCourant) {
				tableau = tableau.concat(" " + compte.getNumCompte() + " ");
				existecourant = true;
			} else {
			}
		}

		if (!existecourant) {
			tableau = "Pas de compte courant";
		} else {
		}
		return tableau;
	}

	
	public static String numeroCompteEpargneClient(Client client) {
		String tableau;
		tableau = "";
		boolean existecourant = false;
		for (CompteBancaire compte : client.getListeCompte()) {
			if (compte instanceof CompteEpargne) {
				tableau = tableau.concat(" " + compte.getNumCompte() + " ");
				existecourant = true;
			} else {
			}
		}

		if (!existecourant) {
			tableau = "Pas de compte epargne";
		} else {
		}
		return tableau;
	}
	
	public static String dateOuvCourantClient(Client client) {
		String tableau;
		tableau = "";
		boolean existecourant = false;
		for (CompteBancaire compte : client.getListeCompte()) {
			if (compte instanceof CompteCourant) {
				tableau = tableau.concat(" " + compte.getDateOuverture() + " ");
				existecourant = true;
			} else {
			}
		}

		if (!existecourant) {
			tableau = "Pas de compte courant";
		} else {
		}
		return tableau;
	}

	
	public static String dateOuvEpargneClient(Client client) {
		String tableau;
		tableau = "";
		boolean existecourant = false;
		for (CompteBancaire compte : client.getListeCompte()) {
			if (compte instanceof CompteEpargne) {
				tableau = tableau.concat(" " + compte.getDateOuverture() + " ");
				existecourant = true;
			} else {
			}
		}

		if (!existecourant) {
			tableau = "Pas de compte epargne";
		} else {
		}
		return tableau;
	}

	
	public static String soldeCourantClient(Client client) {
		String tableau;
		tableau = "";
		boolean existecourant = false;
		for (CompteBancaire compte : client.getListeCompte()) {
			if (compte instanceof CompteCourant) {
				tableau = tableau.concat(" " + compte.getSolde() + " ");
				existecourant = true;
			} else {
			}
		}

		if (!existecourant) {
			tableau = "Pas de compte courant";
		} else {
		}
		return tableau;
	}

	
	public static String soldeEpargneClient(Client client) {
		String tableau;
		tableau = "";
		boolean existecourant = false;
		for (CompteBancaire compte : client.getListeCompte()) {
			if (compte instanceof CompteEpargne) {
				tableau = tableau.concat(" " + compte.getSolde() + " ");
				existecourant = true;
			} else {
			}
		}

		if (!existecourant) {
			tableau = "Pas de compte epargne";
		} else {
		}
		return tableau;
	}
	
	
	
	
	public static String tableauCompteClientDebiteur(Client client){
		String tableau;
		tableau = "";
		for (CompteBancaire compte : client.getListeCompte()) {

			tableau = tableau.concat("<tr><td>" + client.getNom() + "</td>");
			tableau = tableau.concat("<td>" + client.getPrenom() + "</td>");
			tableau = tableau.concat("<td>" + compte.getNumCompte() + "</td>");
			tableau = tableau.concat("<td>" + compte.getDateOuverture() + "</td>");
			tableau = tableau.concat("<td>" + compte.getSolde() + "</td>");
			if(compte instanceof CompteCourant){
				tableau = tableau.concat("<td>" + "courant" + "</td>");
			}else{
				tableau = tableau.concat("<td>" + "epargne" + "</td>");
			}
			
			tableau = tableau.concat("</tr>");
		}
		return tableau;
	}
	
	public static String tableauCompteBanque(List<CompteBancaire> listcompte){
		String tableau;
		tableau = "";
		int numerodeligne = 1;
		for (CompteBancaire compte : listcompte) {

			tableau = tableau.concat("<tr><td>" + numerodeligne + "</td>");
			tableau = tableau.concat("<td>" + compte.getIdClient() + "</td>");
			tableau = tableau.concat("<td>" + compte.getNumCompte() + "</td>");
			tableau = tableau.concat("<td>" + compte.getDateOuverture() + "</td>");
			tableau = tableau.concat("<td>" + compte.getSolde() + "</td>");
			if(compte instanceof CompteCourant){
				tableau = tableau.concat("<td>" + "courant" + "</td>");
			}else{
				tableau = tableau.concat("<td>" + "epargne" + "</td>");
			}
			
			tableau = tableau.concat("</tr>");
			numerodeligne++;
		}
		return tableau;
	}
	
}
