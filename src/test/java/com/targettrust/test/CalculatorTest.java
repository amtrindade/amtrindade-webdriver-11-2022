package com.targettrust.test;

import static com.targettrust.core.DriverFactory.getDriver;
import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.targettrust.core.BaseTest;

public class CalculatorTest extends BaseTest{
	
	WebDriverWait wait;
	
	@Before
	public void setUp() {
		getDriver().get("http://antoniotrindade.com.br/treinoautomacao/desafiosoma.html");
		wait = new WebDriverWait(getDriver(), 5);
	}
	
	@Test
	public void testSum() throws InterruptedException {
		WebElement tfValueOne = getDriver().findElement(By.id("number1"));
		tfValueOne.sendKeys("8");
		
		WebElement tfValueTwo = getDriver().findElement(By.id("number2"));
		tfValueTwo.sendKeys("4");
		
		//Fazendo a espera explicita		
		wait.until(ExpectedConditions.textToBePresentInElementValue(tfValueTwo, "4"));
		
		WebElement btnSum = getDriver().findElement(By.id("somar"));
		btnSum.click();
		
		WebElement tfTotal = getDriver().findElement(By.id("total"));
		
		//Fazendo a espera explicita		
		wait.until(ExpectedConditions.textToBePresentInElementValue(tfTotal, "12"));
		
		String total = tfTotal.getAttribute("value");
		
		assertEquals("12", total);
	}

}
