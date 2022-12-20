package com.targettrust.test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import com.targettrust.core.BaseTest;
import com.targettrust.core.GlobalProperty;
import com.targettrust.page.LoginUmovPage;
import com.targettrust.page.MainUmovPage;
import com.targettrust.page.SearchTaskUmovPage;

public class TaskUmovTest extends BaseTest{
	
	private LoginUmovPage loginPage;
	private MainUmovPage mainPage;
	private SearchTaskUmovPage taskPage;
	
	@Before
	public void setUp() {
		loginPage = new LoginUmovPage();
		loginPage.openURL(GlobalProperty.getProperty("webdriver.url"));
		mainPage = loginPage.login(
				GlobalProperty.getProperty("webdriver.environment"), 
				GlobalProperty.getProperty("webdriver.user"),  
				"123456");	
		taskPage = mainPage.accessTask();
	}
	
	@Test
	public void testSearchTask() {	
		taskPage.searchTask("Aluno 01");		
		assertTrue(taskPage.isExistTask("Aluno 01"));
	}
	

}
