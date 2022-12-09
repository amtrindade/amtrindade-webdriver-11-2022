package com.targettrust.core;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DriverFactory {

	private static WebDriver driver = null;
	
	public static WebDriver getDriver() {
		
		if (driver == null) {			
			System.setProperty("webdriver.chrome.driver", 
					"/home/antonio/Dev/drivers/chromedriver"); 		
			driver = new ChromeDriver();
		}
		
		return driver;
	}
	
	public static void quitDriver() {
		if (driver != null) {
			driver.quit();
			driver = null;
		}
	}	
}
