package com.targettrust.page;

import static com.targettrust.core.DriverFactory.getDriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class LoginUmovPage {
	
	public LoginUmovPage openURL(String url) {
		getDriver().get(url);		
		return this;
	}
	
	public MainUmovPage login(String environment, String user, String password) {
		WebElement tfEnvironment = getDriver().findElement(By.id("workspace"));
		tfEnvironment.sendKeys(environment);
		
		WebElement tfUserName = getDriver().findElement(By.id("username"));
		tfUserName.sendKeys(user);
		
		WebElement tfPass = getDriver().findElement(By.id("password"));
		tfPass.sendKeys(password);
		
		WebElement btnSubmit = getDriver().findElement(By.id("submit_button"));
		btnSubmit.click();		
		
		return new MainUmovPage();
	}

}
