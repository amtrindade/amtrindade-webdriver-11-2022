package com.targettrust.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import com.targettrust.core.BaseTest;
import com.targettrust.page.BooksPage;
import com.targettrust.page.LoginPage;

public class LoginBooksTest extends BaseTest{
	
	LoginPage loginPage;
	BooksPage booksPage;
	
	@Test
	public void testLoginValid() {
		loginPage = new LoginPage();
		
		loginPage.openUrl();		
		loginPage.inputUser("test");
		loginPage.inputPassword("secret");
		
		booksPage = loginPage.submitLogin();
		
		assertTrue(booksPage.isLoadPage());		
	}
	
	@Test
	public void testLoginUserInvalid() {
		loginPage = new LoginPage();
		
		loginPage.openUrl();		
		loginPage.inputUser("invalid");
		loginPage.inputPassword("secret");

		loginPage.submitLoginInvalid();
		
		assertEquals("Invalid username or password", 
				loginPage.getMessageError());		
	}
	
	@Test
	public void testLoginPasswordInvalid() {
		loginPage = new LoginPage();
		
		loginPage.openUrl();		
		loginPage.inputUser("test");
		loginPage.inputPassword("invalid");

		loginPage.submitLoginInvalid();
		
		assertEquals("Invalid username or password", 
				loginPage.getMessageError());
	}
}
