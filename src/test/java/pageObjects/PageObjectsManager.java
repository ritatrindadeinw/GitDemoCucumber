package pageObjects;

import org.openqa.selenium.WebDriver;

public class PageObjectsManager {
	
	
	public LandingPage landingPage;
	public OffersPage offersPage;
	public CheckOutPage checkOutPage;
	public WebDriver driver;
	
	public PageObjectsManager (WebDriver driver) {
		this.driver = driver;
	}
	
	public LandingPage getLandingPage() {
		
		landingPage = new LandingPage(driver);
		return landingPage;
	}
	
	public OffersPage getOffersPage() {
		offersPage = new OffersPage(driver);
		return offersPage;
	}

	public CheckOutPage getCheckOutPage() {
		checkOutPage = new CheckOutPage(driver);
		return checkOutPage;
	}
}
