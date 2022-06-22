package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LandingPage {
	
	public WebDriver driver;
	private By search = By.xpath("//input[@placeholder='Search for Vegetables and Fruits']");
	private By productName = By.cssSelector("h4[class='product-name']");
	private By increment = By.cssSelector("body > div:nth-child(1) > div:nth-child(1) > div:nth-child(2) > div:nth-child(1) > div:nth-child(1) > div:nth-child(4) > a:nth-child(3)");
	private By addToCart = By.cssSelector("body > div:nth-child(1) > div:nth-child(1) > div:nth-child(2) > div:nth-child(1) > div:nth-child(1) > div:nth-child(5) > button:nth-child(1)");
	
	public LandingPage (WebDriver driver) {
		this.driver = driver;
	}
	
	public void searchItem(String name) {
		
		driver.findElement(search).sendKeys(name);
	}

	public void getSearchItem() {
		driver.findElement(search).getText();
	}
	
	public String getProductName() {
		return driver.findElement(productName).getText();
	}
	
	public String getTitleLandingPage() {
		return driver.getTitle();
	}
	
	public void incrementQuantity(int quantity) {
		for (int i = 0; i<quantity-1; i++) {
			driver.findElement(increment).click();
		}	
	}
	
	public void addToCart() {
		driver.findElement(addToCart).click();
	}
}
