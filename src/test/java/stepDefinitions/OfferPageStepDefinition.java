package stepDefinitions;

import java.io.IOException;
import java.util.Iterator;
import java.util.Set;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import static org.testng.AssertJUnit.*;
import pageObjects.OffersPage;
import pageObjects.PageObjectsManager;
import utils.TestContexSetup;

public class OfferPageStepDefinition {
	
	public String offerPageProductName;
	TestContexSetup testContextSetup;
	OffersPage offersPage;
	public WebDriver driver;
	
	public OfferPageStepDefinition(TestContexSetup testContextSetup) {
		
		this.testContextSetup = testContextSetup;
	}
	
	public void switchToOffersPage() {
		 offersPage.selectTopDealsPage();
		 testContextSetup.genericUtils.SwitchToChild();
	}
	
	@Then("^User search for the (.+) Shortname in Offers page$")
	public void user_search_for_the_beet_shortname_in_offers_page(String shortName) throws IOException, InterruptedException {
		 
		 offersPage = testContextSetup.pageObjectsManager.getOffersPage();
		 
		 if(!testContextSetup.testBase.WebDriverManager().getCurrentUrl().equals("https://rahulshettyacademy.com/seleniumPractise/#/offers")) {
			 switchToOffersPage();
		 }
		 
		 offersPage.searchItem(shortName);
		 Thread.sleep(2000);
		 offerPageProductName = offersPage.getProductName();
	}
	 
	 @And("^Validate product name matches with Landing Page$")
	    public void validate_product_name_matches_with_landing_page() throws Throwable {
		 
		assertEquals(offerPageProductName, testContextSetup.landingPageProductName);
    }
}
