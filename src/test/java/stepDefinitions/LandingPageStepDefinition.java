package stepDefinitions;

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
import pageObjects.LandingPage;
import pageObjects.PageObjectsManager;
import utils.TestContexSetup;

public class LandingPageStepDefinition {
	
	public WebDriver driver;
	public String landingPageProductName;
	public String offerPageProductName;
	TestContexSetup testContextSetup;
	LandingPage landingPage;
	
	//Spring framework, EJB, 
	
	public LandingPageStepDefinition(TestContexSetup testContextSetup) {
		
		this.testContextSetup = testContextSetup;
	    this.landingPage = testContextSetup.pageObjectsManager.getLandingPage();
	}
	
	@Given("^User is on GreenCart Landing Page$")
    public void user_is_on_greencart_landing_page() throws Throwable {
		
		//driver = testContextSetup.testBase.WebDriverManager();
		assertTrue(landingPage.getTitleLandingPage().contains("GreenKart"));
	}
	

	@When("^User searched with Shortname (.+) and extracted actual name of the product$")
    public void user_searched_with_shortname_and_extracted_actual_name_of_the_product(String shortName) throws Throwable {
		
		landingPage.searchItem(shortName);
		
	    Thread.sleep(2000);
	    testContextSetup.landingPageProductName = landingPage.getProductName().split("-")[0].trim();
	    System.out.println(testContextSetup.landingPageProductName + " is extracted from Home Page.");
	}
	
	@And("^Added \"([^\"]*)\" items of the selected product to cart$")
    public void added_something_items_of_the_selected_product_to_cart(String quantity) throws Throwable {
		landingPage.incrementQuantity(Integer.parseInt(quantity));
		landingPage.addToCart();
    }
}
