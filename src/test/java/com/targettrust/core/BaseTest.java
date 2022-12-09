package com.targettrust.core;

import static com.targettrust.core.DriverFactory.getDriver;

import org.apache.commons.io.FileUtils;
import org.junit.After;
import org.junit.Rule;
import org.junit.rules.TestName;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.io.File;

public abstract class BaseTest {
	
	@Rule
	public TestName testName = new TestName();
	
	@After
	public void tearDown() throws Exception {
		File scrShot = ((TakesScreenshot)getDriver()).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(scrShot,	new File("target"+ File.separator + testName.getMethodName()+ ".jpg"));
		
		DriverFactory.quitDriver();
	}
}
