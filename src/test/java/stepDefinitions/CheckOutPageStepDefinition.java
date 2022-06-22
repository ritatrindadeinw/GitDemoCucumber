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
import pageObjects.CheckOutPage;
import pageObjects.LandingPage;
import pageObjects.PageObjectsManager;
import utils.TestContexSetup;

public class CheckOutPageStepDefinition {
	
	public WebDriver driver;
	public String landingPageProductName;
	public String offerPageProductName;
	public CheckOutPage checkOutPage;
	TestContexSetup testContextSetup;
	
	//Spring framework, EJB, 
	
	public CheckOutPageStepDefinition(TestContexSetup testContextSetup) {
		
		this.testContextSetup = testContextSetup;
		this.checkOutPage= testContextSetup.pageObjectsManager.getCheckOutPage();
	}
	
    @Then("^User proceeds to Checkout and validate the (.+) items in checkout page$")
    public void user_proceeds_to_checkout_and_validate_the_items_in_checkout_page(String name) throws Throwable {

    	checkOutPage.checkOutItems();
    }

    @And("^Verifies if user has ability to enter promo code and place the order$")
    public void verifies_if_user_has_ability_to_enter_promo_code_and_place_the_order() throws Throwable {
    	assertTrue(checkOutPage.verifiyPromoButton());
    	assertTrue(checkOutPage.verifyPlaceOrder());
    }
	
}
