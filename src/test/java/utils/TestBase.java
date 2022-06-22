package utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import java.util.Properties;

public class TestBase {
	
	public WebDriver driver;
	
	public WebDriver WebDriverManager() throws IOException {
		
		FileInputStream fis = new FileInputStream("C://Users//rita.trindade//eclipse-workspace//CucumberFramework//src//test//resources//global.properties");
		Properties prop = new Properties();
		prop.load(fis);
		String url = prop.getProperty("QAUrl");
		String browserFromProperties = prop.getProperty("browser");
		String browserFromMaven = System.getProperty("browser");
		
		String browser = browserFromMaven!= null ? browserFromMaven : browserFromProperties;
		
		if (driver == null) {
			if (browser.equalsIgnoreCase("edge")) {
				System.setProperty("webdriver.edge.driver","C://Users//rita.trindade//eclipse-workspace//CucumberFramework//src//test//resources//msedgedriver.exe");
				driver = new EdgeDriver(); // Launch Edge browser
				driver.get(url);
			}
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		}
		return driver;
	}

}
