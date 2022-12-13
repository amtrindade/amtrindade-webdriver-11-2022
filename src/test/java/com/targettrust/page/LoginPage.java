package com.targettrust.page;

import static com.targettrust.core.DriverFactory.getDriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class LoginPage {
	
	public LoginPage openUrl() {
		getDriver().get("http://sahitest.com/demo/training/login.htm");		
		return this;
	}
	
	public LoginPage inputUser(String username) {
		WebElement tfUser = getDriver().findElement(By.name("user"));
		tfUser.sendKeys(username);
		return this;
	}
	
	public LoginPage inputPassword(String pass) {
		WebElement tfPass = getDriver().findElement(By.name("password"));
		tfPass.sendKeys(pass);
		return this;
	}
	
	public BooksPage submitLogin() {
		WebElement btnLogin = getDriver().findElement(By.xpath("//input[@value='Login']"));
		btnLogin.click();
		
		return new BooksPage();
	}
	
	public LoginPage submitLoginInvalid() {
		WebElement btnLogin = getDriver().findElement(By.xpath("//input[@value='Login']"));
		btnLogin.click();
		
		return this;
	}
	
	public String getMessageError() {
		WebElement divMsgError = getDriver().findElement(By.id("errorMessage"));	
		return divMsgError.getText();
	}	

}
