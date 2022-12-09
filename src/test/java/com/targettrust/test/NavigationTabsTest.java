package com.targettrust.test;

import static com.targettrust.core.DriverFactory.getDriver;
import static org.junit.Assert.assertEquals;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.targettrust.core.BaseTest;

public class NavigationTabsTest extends BaseTest{

	@Before
	public void setUp() throws Exception {		
		getDriver().get("http://antoniotrindade.com.br/treinoautomacao");		
	}
	
	@Test
	public void testNavigationTabs() throws InterruptedException {		
		assertEquals("Treino Automação de Testes", getDriver().getTitle());
		
		WebElement linkCPF = getDriver().findElement(By.linkText("Gerador de CPF"));
		linkCPF.click();
		
		WebElement linkDrag = getDriver().findElement(By.partialLinkText("Drag and"));
		linkDrag.click();		
		
		ArrayList<String> tabs = new ArrayList<String>(getDriver().getWindowHandles());
		
		getDriver().switchTo().window(tabs.get(2));				
		assertEquals("Gerador de CPF", getDriver().getTitle());
		
		getDriver().switchTo().window(tabs.get(1));
		assertEquals("Mootools Drag and Drop Example", getDriver().getTitle());
		
		getDriver().switchTo().window(tabs.get(0));
		assertEquals("Treino Automação de Testes", getDriver().getTitle());		
	
	}
}
