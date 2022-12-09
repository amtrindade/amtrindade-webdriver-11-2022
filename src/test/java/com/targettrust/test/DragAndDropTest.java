package com.targettrust.test;

import static com.targettrust.core.DriverFactory.getDriver;
import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import com.targettrust.core.BaseTest;

public class DragAndDropTest extends BaseTest{

	@Before
	public void setUp() throws Exception {		
		getDriver().get("https://jqueryui.com/resources/demos/droppable/default.html");			
	}	

	@Test
	public void testDragAndDrop() throws InterruptedException {
		
		WebElement origin = getDriver().findElement(By.id("draggable"));
		WebElement destiny = getDriver().findElement(By.id("droppable"));
		
		assertEquals("Drop here", destiny.getText());				
		
		//Ações de mouse e teclado
		new Actions(getDriver()).dragAndDrop(origin, destiny).perform();
		
		String message = destiny.getText();		
		assertEquals("Dropped!", message);
	}
}
