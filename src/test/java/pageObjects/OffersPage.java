package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class OffersPage {
	
	public WebDriver driver;
	private By search = By.xpath("//input[@id='search-field']");
	private By productName = By.cssSelector("tr td:nth-child(1)");
	
	public OffersPage (WebDriver driver) {
		this.driver = driver;
	}
	
	public void searchItem(String name) {
		driver.findElement(By.xpath("//input[@id='search-field']")).sendKeys(name);
	}
	
	public String getProductName() {
		return driver.findElement(By.cssSelector("tr td:nth-child(1)")).getText();
	}
	
	public void selectTopDealsPage() {
		driver.findElement(By.linkText("Top Deals")).click();
	}
}
