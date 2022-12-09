package com.targettrust.test;

import static com.targettrust.core.DriverFactory.getDriver;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.targettrust.core.BaseTest;

public class RegularExpressionTest extends BaseTest{
	
	@Before
	public void setUp() throws Exception {	
		getDriver().get("https://www.geradordecpf.org/");
	}

	@Test
	public void testRegularExpressionWithDot() throws InterruptedException {
		WebElement cbDot = getDriver().findElement(By.id("cbPontos"));
		cbDot.click();
		
		WebElement btnGerarCPF = getDriver().findElement(By.id("btn-gerar-cpf"));
		btnGerarCPF.click();
		
		WebElement tfNumber = getDriver().findElement(By.id("numero"));
		String cpfNumber = tfNumber.getAttribute("value");
		
		System.out.println(cpfNumber);				
		
		assertTrue(cpfNumber.matches("^[0-9]{3}\\.[0-9]{3}\\.[0-9]{3}-[0-9]{2}$"));		
	}
	
	@Test
	public void testRegularExpressionWithoutDot() {
		
		WebElement btnGerarCPF = getDriver().findElement(By.id("btn-gerar-cpf"));
		btnGerarCPF.click();
		
		WebElement tfNumber = getDriver().findElement(By.id("numero"));
		String cpfNumber = tfNumber.getAttribute("value");
		
		System.out.println(cpfNumber);				
		
		assertTrue(cpfNumber.matches("^[0-9]{11}$"));		
	}		
}
