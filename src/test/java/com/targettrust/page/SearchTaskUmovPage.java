package com.targettrust.page;

import static com.targettrust.core.DriverFactory.getDriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class SearchTaskUmovPage {
	
	public SearchTaskUmovPage searchTask(String value) {
		WebElement btnClear = getDriver().findElement(By.id("scheduleList_doClear"));
		btnClear.click();
		
		WebElement tfSearch = getDriver().findElement(By.id("genericFilter"));
		tfSearch.clear();
		tfSearch.sendKeys(value);
		
		WebElement btnSearch = getDriver().findElement(By.id("scheduleList_doSearch"));
		btnSearch.click();
		
		return this;
	}
	
	public Boolean isExistTask(String value) {
		WebElement line = getDriver().findElement(By.xpath("//a[contains(text(),'"+ value +"')]"));
		//a[contains(text(),'Haus Burger Bar')]/../../td[@class='TableActions']//img[@alt='Editar']
		
		return line.isDisplayed(); 
	}
	
	
	

}
