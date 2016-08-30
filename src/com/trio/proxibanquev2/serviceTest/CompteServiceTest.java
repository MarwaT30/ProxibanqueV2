package com.trio.proxibanquev2.serviceTest;

import static org.junit.Assert.assertNotNull;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

import com.trio.proxibanquev2.domaine.Adresse;
import com.trio.proxibanquev2.domaine.Client;
import com.trio.proxibanquev2.domaine.CompteBancaire;
import com.trio.proxibanquev2.domaine.Conseiller;
import com.trio.proxibanquev2.service.CompteService;

public class CompteServiceTest {
	CompteService compteService;

	@Before
	public void avantChaqueTest() {
		compteService = new CompteService();
	}
	

	@Test
	public void testLireTousLesComptesBancaireDunClient() {
		String nom = "leponge";
		String prenom = "bob";
		Adresse adresse = new Adresse(5, "5", "rue", "paul", 69005, "Lyon");
		String telephone = "0612345678";
		String mail = "aa@dd.fr";
		ArrayList<CompteBancaire> listeCompte = new ArrayList<>();
		int idClient = 5;
		String login = "superman";
		String password = "azerty";
		ArrayList<Client> listClient = new ArrayList<>();

		Conseiller conseiller = new Conseiller(nom, prenom, adresse, telephone, mail, login, password, listClient, 2);
		Client client = new Client(nom, prenom, adresse, telephone, mail, listeCompte, conseiller, idClient);

		ArrayList<CompteBancaire> maListe = compteService.lireTousLesComptesBancaireDunClient(client);

		assertNotNull(maListe);
	}

	@Test
	public void testLireTousLesComptesBancaire() {
		ArrayList<CompteBancaire> maListe = compteService.lireTousLesComptesBancaire();
		assertNotNull(maListe);
	}

}
