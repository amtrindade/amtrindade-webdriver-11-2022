package com.targettrust.core;

import org.junit.After;

public abstract class BaseTest {
	
	@After
	public void tearDown() throws Exception {
		DriverFactory.quitDriver();
	}
}
