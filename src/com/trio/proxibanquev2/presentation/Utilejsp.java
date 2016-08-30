package com.trio.proxibanquev2.presentation;

import java.util.List;

import com.trio.proxibanquev2.domaine.Client;

public class Utilejsp {

	public static String tableauClient(List<Client> listeClient){
		String tableau;
		tableau="";
		for(Client client:listeClient){
			tableau=tableau.concat("<tr><td>"+client.getIdClient()+"</td>");
			tableau=tableau.concat("<td>"+client.getNom()+"</td>");
			tableau=tableau.concat("<td>"+client.getPrenom()+"</td>");
			tableau=tableau.concat("<td>"+client.getAdresse().toString()+"</td>");
			tableau=tableau.concat("<td>"+client.getTelephone()+"</td>");
			tableau=tableau.concat("<td>"+client.getMail()+"</td>");
			tableau=tableau.concat("</tr>");
		}
		return tableau;
	}
	
	public static String tableauClienttest(){
		String tableau;
		tableau="";
			tableau="<tr><td>"+7+"</td>";
			tableau=tableau.concat("<td>"+"dus"+"</td>");
			tableau=tableau.concat("<td>"+"jeanclaude"+"</td>");
			tableau=tableau.concat("<td>"+"36 rue des pied plat 69009 Lyon"+"</td>");
			tableau=tableau.concat("<td>"+"+33 6 43 10 47 18" +"</td>");
			tableau=tableau.concat("<td>"+"trouducmoche@hotmail.fr"+"</td>");
			tableau=tableau.concat("</tr>");
			tableau=tableau.concat("<tr><td>"+8+"</td>");
			tableau=tableau.concat("<td>"+"ben"+"</td>");
			tableau=tableau.concat("<td>"+"guy-george"+"</td>");
			tableau=tableau.concat("<td>"+"47bis avenue des cochon 69009 gresy sur isere"+"</td>");
			tableau=tableau.concat("<td>"+"+33 6 43 10 47 18" +"</td>");
			tableau=tableau.concat("<td>"+"trouduc@hotmail.fr"+"</td>");
			tableau=tableau.concat("</tr>");
		return tableau;
	}
}
