package com.trio.proxibanquev2.serviceTest;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import org.junit.Before;
import org.junit.Test;

import com.trio.proxibanquev2.service.ConseillerService;

public class ConseillerServiceTest {
	ConseillerService conseillerService;

	@Before
	public void avantChaqueTest() {
		conseillerService = new ConseillerService();
	}

	/**
	 * Vérification que la méthode renvoie un objet non null, le conseiller
	 * existe en BD
	 */
	@Test
	public void testLireUnConseillerById1() {
		assertNotNull(conseillerService.lireUnConseillerById(2));
	}

	/**
	 * Vérification que la méthode renvoie un objet non null, le conseiller
	 * existe en BD
	 */
	@Test
	public void testLireUnConseillerById2() {
		assertNotNull(conseillerService.lireUnConseillerById(3));
	}

	/**
	 * Vérification que la méthode renvoie un objet non null, le conseiller
	 * n'existe pas en BD
	 */
	@Test
	public void testLireUnConseillerById3() {
		assertNotNull(conseillerService.lireUnConseillerById(10));
	}

	/**
	 * Vérification que la méthode renvoie un objet dont le password est null
	 * quand le conseiller n'existe pas en BD
	 */
	@Test
	public void testLireUnConseillerById4() {
		assertNull(conseillerService.lireUnConseillerById(10).getPassword());
	}

	/**
	 * Vérification que la méthode renvoie un objet non null, le conseiller
	 * existe en BD
	 */
	@Test
	public void testLireUnConseillerByLogin1() {
		String login = "superman";
		String password = "azerty";
		assertNotNull(conseillerService.lireUnConseillerByLogin(login, password));
	}

	/**
	 * Vérification que la méthode renvoie un objet non null, le conseiller
	 * n'existe pas en BD
	 */
	@Test
	public void testLireUnConseillerByLogin2() {
		String login = "";
		String password = "";
		assertNotNull(conseillerService.lireUnConseillerByLogin(login, password));
	}

	/**
	 * Vérification que la méthode renvoie un objet dont le password est null
	 * quand le conseiller n'existe pas en BD
	 */
	@Test
	public void testLireUnConseillerByLogin3() {
		String login = "";
		String password = "";
		assertNull(conseillerService.lireUnConseillerByLogin(login, password).getPassword());
	}

}
