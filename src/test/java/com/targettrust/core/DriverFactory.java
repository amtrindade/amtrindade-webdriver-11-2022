package com.targettrust.core;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

public class DriverFactory {

	private static WebDriver driver = null;	
	
	// Chrome / Firefox / Chromeheadless / Firefoxheadless
	
	public static WebDriver getDriver() {
		
		if (driver == null) {
			
			String typeDriver = GlobalProperty.getProperty("webdriver.browser");
			String path = GlobalProperty.getProperty("webdriver.path");
			
			System.out.println(typeDriver);
			
			if (typeDriver.equals("Chrome")) {			
				System.setProperty("webdriver.chrome.driver", path + "chromedriver"); 		
				driver = new ChromeDriver();
			}
			else if (typeDriver.equals("Firefox")) {
				System.setProperty("webdriver.gecko.driver", path + "geckodriver");
				driver = new FirefoxDriver();				
			}
			else if (typeDriver.equals("Chromeheadless")) {
				System.setProperty("webdriver.chrome.driver", path + "chromedriver");
				
				ChromeOptions options = new ChromeOptions();
				options.addArguments("--headless");
				options.addArguments("--window-size=1200x960");
				
				driver = new ChromeDriver(options);
			}
			else if (typeDriver.equals("Firefoxheadless")) {
				System.setProperty("webdriver.gecko.driver", path + "geckodriver");
				
				FirefoxOptions options = new FirefoxOptions();
				options.addArguments("--headless");
				options.addArguments("--window-size=1200x960");
				
				driver = new FirefoxDriver(options);
			}
			else {
				System.out.println("Driver não foi definido");
			}
			
			driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
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
