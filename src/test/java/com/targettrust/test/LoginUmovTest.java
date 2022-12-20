package com.targettrust.test;

import static org.junit.Assert.*;

import org.junit.Test;

import com.targettrust.core.BaseTest;
import com.targettrust.page.LoginUmovPage;
import com.targettrust.page.MainUmovPage;

public class LoginUmovTest extends BaseTest {
	
	private LoginUmovPage loginPage;
	private MainUmovPage mainPage;
	
	@Test
	public void testLogin() {
		loginPage = new LoginUmovPage();
		loginPage.openURL("https://center.umov.me/");
		mainPage = loginPage.login("trindade", "trocaraqui", "trocaraqui");
		
		assertEquals("Aluno 01 (aluno01)", mainPage.getNameUser());
	}
}
