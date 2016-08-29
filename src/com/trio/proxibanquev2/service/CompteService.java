package com.trio.proxibanquev2.service;

import com.trio.proxibanquev2.domaine.CompteBancaire;

public class CompteService {

	CompteBancaireDAO compteDAO;
	
	public CompteService(){
		compteDAO=new CompteBancaireDAO();
	}
	
	
	
	public boolean virement(CompteBancaire compteDebite, CompteBancaire compteCredite, double montant){
		compteCredite.ajouterAuSolde(montant);
		compteDebite.enleverAuSolde(montant);
		compteDAO.modifierUnCompteBancaire(compteDebite);
		compteDAO.modifierUnCompteBancaire(compteCredite);
	}
	
	
	
	
}
