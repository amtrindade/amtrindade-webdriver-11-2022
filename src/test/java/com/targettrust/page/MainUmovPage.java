package com.targettrust.page;

import static com.targettrust.core.DriverFactory.getDriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class MainUmovPage {
	
	public String getNameUser() {
		WebElement divAvatar = getDriver().findElement(By.xpath("//div[@class='topbar-widget profile-widget']"));
		divAvatar.click();
		
		WebElement spanUser = getDriver().findElement(By.xpath("//span[@class='text-login']/.."));		
		String nameUser = spanUser.getText();
		System.out.println(nameUser);
		
		return nameUser;
	}
	
	public SearchTaskUmovPage accessTask() {
		WebElement menuTask = getDriver().findElement(By.linkText("Task"));
		menuTask.click();
		
		return new SearchTaskUmovPage();
	}

}
