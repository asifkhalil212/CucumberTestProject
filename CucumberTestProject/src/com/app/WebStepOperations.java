package com.app;
import org.junit.Assert;

import com.hp.lft.sdk.web.Browser;
import com.hp.lft.sdk.web.BrowserFactory;
import com.hp.lft.sdk.web.BrowserType;
import com.hp.lft.sdk.web.Button;
import com.hp.lft.sdk.web.ButtonDescription;
import com.hp.lft.sdk.web.EditField;
import com.hp.lft.sdk.web.EditFieldDescription;
import com.hp.lft.sdk.web.WebElement;
import com.hp.lft.sdk.web.WebElementDescription;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class WebStepOperations {
	
	Browser browser;
	
	@Given("^a user goes to google$")
	public void a_user_goes_to_google() throws Throwable {
		System.out.println("Test app");
		browser=BrowserFactory.launch(BrowserType.CHROME);
	    browser.navigate("www.google.com");
	    //throw new PendingException();
		
	}

	@Given("^searches for TYPE$")
	public void searches_for_TYPE() throws Throwable {
		System.out.println("Type TEST");
		
		browser.describe(EditField.class, new EditFieldDescription.Builder()
				.name("q")
				.tagName("INPUT")
				.type("text").build()).setValue("TEST");
		
		System.out.println("Hit on Search button");
		
		browser.describe(Button.class, new ButtonDescription.Builder()
				.accessibilityName("Google Search")
				.buttonType("submit")
				.index(1)
				.name("Google Search")
				.role("")
				.tagName("INPUT").build()).click();
		
		System.out.println("End TYPE type");
	}

	@When("^he clicks on link$")
	public void he_clicks_on_link() throws Throwable {
		System.out.println("Click on link");
		
		browser.describe(WebElement.class, new WebElementDescription.Builder()
				.innerText("Speedtest by Ookla - The Global Broadband Speed Test")
				.tagName("H3").build()).click();
	}

	@Then("^the pag should appear$")
	public void the_pag_should_appear() throws Throwable {
		System.out.println("Checking for test");
		
		System.out.println(browser.getTitle());
		//Assert.assertTrue(browser.getTitle().equals("Speedtest by Ookla - The Global Broadband Speed Test"));
		System.out.println("Test ends");
		
		browser.navigate("google.com");
	} 

}
