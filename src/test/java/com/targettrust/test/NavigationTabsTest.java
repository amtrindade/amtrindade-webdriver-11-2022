package com.targettrust.test;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class NavigationTabsTest {
	private WebDriver driver;

	@Before
	public void setUp() throws Exception {
		System.setProperty("webdriver.chrome.driver", "/home/antonio/Dev/drivers/chromedriver"); 		
		driver = new ChromeDriver();
		driver.get("http://antoniotrindade.com.br/treinoautomacao");		
	}

	@After
	public void tearDown() throws Exception {
		driver.quit();
	}

	@Test
	public void testNavigationTabs() throws InterruptedException {		
		assertEquals("Treino Automação de Testes", driver.getTitle());
		
		WebElement linkCPF = driver.findElement(By.linkText("Gerador de CPF"));
		linkCPF.click();
		
		WebElement linkDrag = driver.findElement(By.partialLinkText("Drag and"));
		linkDrag.click();		
		
		ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
		
		driver.switchTo().window(tabs.get(2));				
		assertEquals("Gerador de CPF", driver.getTitle());
		
		driver.switchTo().window(tabs.get(1));
		assertEquals("Mootools Drag and Drop Example", driver.getTitle());
		
		driver.switchTo().window(tabs.get(0));
		assertEquals("Treino Automação de Testes", driver.getTitle());		
	
	}
}
