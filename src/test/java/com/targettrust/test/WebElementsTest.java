package com.targettrust.test;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;


public class WebElementsTest {
	
	private WebDriver driver;	

	@Before
	public void setUp() throws Exception {
		System.setProperty("webdriver.chrome.driver", "/home/antonio/Dev/drivers/chromedriver"); 		
		driver = new ChromeDriver();
		driver.get("http://antoniotrindade.com.br/treinoautomacao/elementsweb.html");
	}

	@After
	public void tearDown() throws Exception {
		driver.quit();
	}

	@Test
	public void testValidateTitle() {
		// Valida o título da página
		
		String title = driver.getTitle();	
		assertEquals("WebElements Test Page Lab", title);
	}
	
	@Test
	public void testWriteTextFieldName() throws InterruptedException {
		//Localiza elemento
		WebElement tfName = driver.findElement(By.name("txtbox1"));
	
		//Interage com elemento
		tfName.sendKeys("Antônio");	
		
		//opcional sleep
		Thread.sleep(3000);		
		
		String valueExpected = tfName.getAttribute("value"); 
		
		//Valida o resultado		
		assertEquals("O nome deveria ser igual", "Antônio", valueExpected);		
		//assertEquals("O nome deveria ser igual", "Antônio", tfName.getAttribute("value"));
	}
	
	@Test
	public void testValidateTextFieldEnable() throws InterruptedException {
		//Localizar os elementos
		WebElement tfEnable = driver.findElement(By.name("txtbox1"));
		WebElement tfDisable = driver.findElement(By.name("txtbox2"));
		
		//Interaçao com os elementos 
		//***NÃO PRECISA, SO A NÍVEL DE CURIOSIDADE
		if (tfEnable.isEnabled()) {
			tfEnable.sendKeys("habilitado");
		}
		
		if (tfDisable.isEnabled()) {
			tfDisable.sendKeys("Outro texto qualquer");
		}	
		
		Thread.sleep(3000);
		
		//Valida o resultado
		assertTrue(tfEnable.isEnabled());		
		assertFalse(tfDisable.isEnabled());					
	}
	
	@Test
	public void testRadioButton() throws InterruptedException {
		List<WebElement> listRadio = driver.findElements(By.name("radioGroup1"));
		
		assertEquals(4, listRadio.size());
		
		//listRadio.get(2).click();
		
		for (WebElement element : listRadio) {					
			if ("Radio 3".equals(element.getAttribute("value"))) {
				element.click();
			}
		}		
				
		assertTrue(listRadio.get(2).isSelected());		
		assertFalse(listRadio.get(0).isSelected());
		assertFalse(listRadio.get(1).isSelected());
		assertFalse(listRadio.get(3).isSelected());		
	}
	
	@Test
	public void testCheckBoxLooping() throws InterruptedException {
		List<WebElement> checkList = 
				driver.findElements(By.xpath("//div[@id='box']//input[@type='checkbox']"));
		
		assertEquals(4, checkList.size());
		
		//Forma com looping
		for (WebElement el : checkList) {
			//if com a condição OU
			if ((el.getAttribute("value").equals("Check 3")) || 
					(el.getAttribute("value").equals("Check 4"))) {
				el.click();
			}						
		}
	
		assertFalse(checkList.get(0).isSelected());
		assertFalse(checkList.get(1).isSelected());
		assertTrue(checkList.get(2).isSelected());
		assertTrue(checkList.get(3).isSelected());
	}
	
	@Test
	public void testCheckBoxSimple() throws InterruptedException {
		List<WebElement> checkList = driver.findElements(By.name("chkbox"));
		
		assertEquals(4, checkList.size());

		//Forma simples
		checkList.get(2).click();
		checkList.get(3).click();
		
		assertFalse(checkList.get(0).isSelected());
		assertFalse(checkList.get(1).isSelected());
		assertTrue(checkList.get(2).isSelected());
		assertTrue(checkList.get(3).isSelected());
	}
	
	@Test
	public void testDropDownListSingle() {
		WebElement dpSingle = driver.findElement(By.name("dropdownlist"));		
		Select selSingle = new Select(dpSingle);
		
		//selSingle.selectByIndex(6);
		//selSingle.selectByVisibleText("Item 7");
		selSingle.selectByValue("item1");
		
		selSingle.selectByValue("item7");
 		
		assertEquals("Item 7", selSingle.getFirstSelectedOption().getText());		
		assertEquals("item7", selSingle.getFirstSelectedOption().getAttribute("value"));
	}
	
	@Test
	public void testDropDownMultiSelect() throws InterruptedException {
		WebElement dpMulti = driver.findElement(By.name("multiselectdropdown"));
		Select selMulti = new Select(dpMulti);
		
		selMulti.selectByVisibleText("Item 5");		
		selMulti.selectByVisibleText("Item 8");
		selMulti.selectByVisibleText("Item 9");
					
		List<WebElement> listSelect = selMulti.getAllSelectedOptions();
		assertEquals(3, listSelect.size());
		
		assertEquals("Item 5", listSelect.get(0).getText());
		assertEquals("Item 8", listSelect.get(1).getText());
		assertEquals("Item 9", listSelect.get(2).getText());		
	}
}
