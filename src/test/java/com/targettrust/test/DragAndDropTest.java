package com.targettrust.test;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class DragAndDropTest {

	private WebDriver driver;

	@Before
	public void setUp() throws Exception {
		System.setProperty("webdriver.chrome.driver", "/home/antonio/Dev/drivers/chromedriver"); 		
		driver = new ChromeDriver();
		driver.get("https://jqueryui.com/resources/demos/droppable/default.html");		
	}

	@After
	public void tearDown() throws Exception {
		driver.quit();
	}

	@Test
	public void testDragAndDrop() throws InterruptedException {
		
		WebElement origin = driver.findElement(By.id("draggable"));
		WebElement destiny = driver.findElement(By.id("droppable"));
		
		assertEquals("Drop here", destiny.getText());
		
		Thread.sleep(3000);
		
		//Ações de mouse e teclado
		new Actions(driver).dragAndDrop(origin, destiny).perform();
		
		Thread.sleep(3000);
		
		String message = destiny.getText();		
		assertEquals("Dropped!", message);
	}
}
