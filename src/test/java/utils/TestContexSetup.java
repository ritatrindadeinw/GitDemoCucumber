package utils;

import java.io.IOException;

import org.openqa.selenium.WebDriver;

import pageObjects.PageObjectsManager;

public class TestContexSetup {
	
	public WebDriver driver;
	public String landingPageProductName;
	public PageObjectsManager pageObjectsManager;
	public TestBase testBase;
	public GenericUtils genericUtils;
	
	public TestContexSetup() throws IOException {
		
		testBase = new TestBase();
		genericUtils = new GenericUtils(testBase.WebDriverManager());
		pageObjectsManager = new PageObjectsManager(testBase.WebDriverManager());
	}
	
	

}
