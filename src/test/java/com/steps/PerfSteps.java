package com.steps;

import java.util.ArrayList;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import vikas.TRDashboardPgObj;
import vikas.TRHomePgObj;
import vikas.TRLoginPgObj;


public class PerfSteps {
	
	public static WebDriver driver = new FirefoxDriver();;
	TRHomePgObj trHomePgObj;
	TRLoginPgObj trLoginPgObj;
	TRDashboardPgObj trDashboardPgObj;


	@Given("^user direct to the site$")
	public void user_direct_to_the_site() throws Throwable {
		//driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.get("https://www.qnetturkiye.com.tr/");
		Thread.sleep(5000);
	 
	}

	@When("^user click on Login button$")
	public void user_click_on_Login_button() throws Throwable {
		trHomePgObj = new TRHomePgObj();
		trHomePgObj.click_irlogin();
	 
	}
	
	@When("^validate login page \"([^\"]*)\"$")
	public void validate_login_page(String arg1) throws Throwable {
	   
	}

	@When("^user enter a valid ID \"([^\"]*)\"$")
	public void user_enter_a_valid_ID(String arg1) throws Throwable {
		trLoginPgObj = new TRLoginPgObj();
	    trLoginPgObj.enter_irid(arg1);
	 
	}

	@When("^user enter a password \"([^\"]*)\"$")
	public void user_enter_a_password(String arg1) throws Throwable {
	    trLoginPgObj.enter_pwd(arg1);
	
	}

	@Then("^user click on login button$")
	public void user_click_on_login_button() throws Throwable {
	    trLoginPgObj.click_login();
	 
	}

	@Then("^validate the landing page \"([^\"]*)\"$")
	public void validate_the_landing_page(String arg1) throws Throwable {
		ArrayList<String> tabs2 = new ArrayList<String>(driver.getWindowHandles());
		
		  driver.switchTo().window(tabs2.get(1));
		  driver.switchTo().window(tabs2.get(1)).close();
		  driver.switchTo().window(tabs2.get(0));
	}

	@Then("^user click on shop link$")
	public void user_click_on_shop_link() throws Throwable {
		trDashboardPgObj = new TRDashboardPgObj();
	    trDashboardPgObj.click_shop();
	    driver.close();
	}
	
}
