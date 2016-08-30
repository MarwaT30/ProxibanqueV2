package com.trio.proxibanquev2.serviceTest;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import com.trio.proxibanquev2.service.AuthService;

public class AuthServiceTest {
	AuthService authService;

	@Before
	public void avantChaqueTest(){
	 authService = new AuthService();
	}
	


	@Test
	public void testAuthentification1() {
		String login = "superman";
		String password = "azerty";
		boolean condition = authService.Authentification(login, password);
		assertTrue(condition);
	}
	@Test
	public void testAuthentification2() {
		String login = "supe";
		String password = "azerty";
		boolean condition = authService.Authentification(login, password);
		assertFalse(condition);
	}
	@Test
	public void testAuthentification3() {
		String login = "superman";
		String password = "azey";
		boolean condition = authService.Authentification(login, password);
		assertFalse(condition);
	}
	@Test
	public void testAuthentification4() {
		String login = "";
		String password = "";
		boolean condition = authService.Authentification(login, password);
		assertFalse(condition);
	}

}
