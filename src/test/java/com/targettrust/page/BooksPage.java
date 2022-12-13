package com.targettrust.page;

import static com.targettrust.core.DriverFactory.getDriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class BooksPage {
	
	public Boolean isLoadPage() {
		WebElement h2Title = getDriver().findElement(By.xpath("//div[@id='available']/h2"));
		return h2Title.isDisplayed();		
	}

}
