package com.trio.proxibanquev2.serviceTest;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

import com.trio.proxibanquev2.domaine.Adresse;
import com.trio.proxibanquev2.domaine.Client;
import com.trio.proxibanquev2.domaine.CompteBancaire;
import com.trio.proxibanquev2.domaine.Conseiller;
import com.trio.proxibanquev2.service.ClientService;

public class ClientServiceTest {
	ClientService clientService;

	@Before
	public void avantChaqueTest() {
		clientService = new ClientService();
	}

	/**
	 * Méthode de test qui permet de vérifier que la méthode modifier un client
	 * dans la DB renvoie bien un boulean true.
	 */
	@Test
	public void testModifierUnClient1() {

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
		boolean condition = clientService.modifierUnClient(client);
		assertTrue(condition);

	}

	/**
	 * Méthode de test qui permet de vérifier que la méthode modifier un client
	 * dans la DB renvoie bien un boulean false quand le client n'existe pas.
	 */
	@Test
	public void testModifierUnClient2() {

		String nom = "leponge";
		String prenom = "bob";
		Adresse adresse = new Adresse(5, "5", "rue", "paul", 69005, "Lyon");
		String telephone = "0612345678";
		String mail = "aa@dd.fr";
		ArrayList<CompteBancaire> listeCompte = new ArrayList<>();
		int idClient = 2;
		String login = "superman";
		String password = "azerty";
		ArrayList<Client> listClient = new ArrayList<>();

		Conseiller conseiller = new Conseiller(nom, prenom, adresse, telephone, mail, login, password, listClient, 2);

		Client client = new Client(nom, prenom, adresse, telephone, mail, listeCompte, conseiller, idClient);
		boolean condition = clientService.modifierUnClient(client);
		assertFalse(condition);

	}

	/**
	 * Méthode de test qui permet de vérifier que la méthode lire un client dans
	 * la DB renvoie bien un objet de type client non null.
	 */
	@Test
	public void testLireUnClient1() {
		int idClient = 2;
		assertNotNull(clientService.lireUnClient(idClient));
	}

	/**
	 * Méthode de test qui permet de vérifier que la méthode lire un client dans
	 * la DB renvoie bien un objet de type client non null, même quand le client
	 * n'existe pas.
	 */
	@Test
	public void testLireUnClient2() {
		int idClient = 200;
		assertNotNull(clientService.lireUnClient(idClient));
	}

	/**
	 * Méthode de test qui permet de vérifier que la méthode écrire un client
	 * dans la DB renvoie bien true.
	 */
	@Test
	public void testEcrireUnClient1() {
		String nom = "leponge";
		String prenom = "bob";
		Adresse adresse = new Adresse(50, "5", "rue", "paul", 69005, "Lyon");
		String telephone = "0612345678";
		String mail = "aa@dd.fr";
		ArrayList<CompteBancaire> listeCompte = new ArrayList<>();
		int idClient = 2;

		String nom1 = "man";
		String prenom1 = "super";
		Adresse adresse1 = new Adresse(50, "5", "rue", "paul", 69005, "Lyon");
		String telephone1 = "0612345678";
		String mail1 = "aa@dd.fr";
		ArrayList<Client> listClient = new ArrayList<>();
		int idConseiller = 2;
		String login = "superman";
		String password = "azerty";

		Conseiller conseiller = new Conseiller(nom1, prenom1, adresse1, telephone1, mail1, login, password, listClient,
				idConseiller);

		Client client = new Client(nom, prenom, adresse, telephone, mail, listeCompte, conseiller, idClient);
		boolean condition = clientService.ecrireUnClient(client);
		assertTrue(condition);

	}

	/**
	 * Méthode de test qui permet de vérifier que la méthode écrire un client
	 * dans la DB renvoie bien false, quand l'id du conseiller n'existe pas.
	 */
	@Test
	public void testEcrireUnClient2() {
		String nom = "leponge";
		String prenom = "bob";
		Adresse adresse = new Adresse(50, "5", "rue", "paul", 69005, "Lyon");
		String telephone = "0612345678";
		String mail = "aa@dd.fr";
		ArrayList<CompteBancaire> listeCompte = new ArrayList<>();
		int idClient = 2;

		String nom1 = "man";
		String prenom1 = "super";
		Adresse adresse1 = new Adresse(50, "5", "rue", "paul", 69005, "Lyon");
		String telephone1 = "0612345678";
		String mail1 = "aa@dd.fr";
		ArrayList<Client> listClient = new ArrayList<>();
		int idConseiller = 20;
		String login = "superman";
		String password = "azerty";

		Conseiller conseiller = new Conseiller(nom1, prenom1, adresse1, telephone1, mail1, login, password, listClient,
				idConseiller);

		Client client = new Client(nom, prenom, adresse, telephone, mail, listeCompte, conseiller, idClient);
		boolean condition = clientService.ecrireUnClient(client);
		assertFalse(condition);

	}

}
