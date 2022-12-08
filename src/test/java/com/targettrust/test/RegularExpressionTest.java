package com.targettrust.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class RegularExpressionTest {
	
	private WebDriver driver;	

	@Before
	public void setUp() throws Exception {
		System.setProperty("webdriver.chrome.driver", "/home/antonio/Dev/drivers/chromedriver"); 		
		driver = new ChromeDriver();
		driver.get("https://www.geradordecpf.org/");
	}

	@After
	public void tearDown() throws Exception {
		driver.quit();
	}
	
	@Test
	public void testRegularExpressionWithDot() throws InterruptedException {
		WebElement cbDot = driver.findElement(By.id("cbPontos"));
		cbDot.click();
		
		WebElement btnGerarCPF = driver.findElement(By.id("btn-gerar-cpf"));
		btnGerarCPF.click();
		
		WebElement tfNumber = driver.findElement(By.id("numero"));
		
		String cpfNumber = tfNumber.getAttribute("value");
		
		System.out.println(cpfNumber);
		
		Thread.sleep(5000);
		
		assertTrue(cpfNumber.matches("^[0-9]{3}\\.[0-9]{3}\\.[0-9]{3}-[0-9]{2}$"));
		
	}
	
}
