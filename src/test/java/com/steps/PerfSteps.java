package com.steps;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import vikas.WPDashboardPgObj;
import vikas.WPHomePgObj;
import vikas.WPLoginPgObj;

public class PerfSteps {
	
	public static WebDriver driver = new FirefoxDriver();;
	WPHomePgObj wpHomePgObj;
	WPLoginPgObj wpLoginPgObj;
	WPDashboardPgObj wpDashboardPgObj;


	@Given("^user direct to the site$")
	public void user_direct_to_the_site() throws Throwable {
		//driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.get("http://www.qnet.net/");
		Thread.sleep(5000);
	 
	}

	@When("^user click on Login button$")
	public void user_click_on_Login_button() throws Throwable {
		 wpHomePgObj= new WPHomePgObj();
	    wpHomePgObj.click_irlogin();
	 
	}
	
	@When("^validate login page \"([^\"]*)\"$")
	public void validate_login_page(String arg1) throws Throwable {
	   
	}

	@When("^user enter a valid ID \"([^\"]*)\"$")
	public void user_enter_a_valid_ID(String arg1) throws Throwable {
		wpLoginPgObj = new WPLoginPgObj();
	    wpLoginPgObj.enter_irid(arg1);
	 
	}

	@When("^user enter a password \"([^\"]*)\"$")
	public void user_enter_a_password(String arg1) throws Throwable {
	    wpLoginPgObj.enter_pwd(arg1);
	
	}

	@Then("^user click on login button$")
	public void user_click_on_login_button() throws Throwable {
	    wpLoginPgObj.click_login();
	 
	}

	@Then("^validate the landing page \"([^\"]*)\"$")
	public void validate_the_landing_page(String arg1) throws Throwable {
	    
	 
	}

	@Then("^user click on shop link$")
	public void user_click_on_shop_link() throws Throwable {
		wpDashboardPgObj = new WPDashboardPgObj();
		wpDashboardPgObj.click_close();
	    wpDashboardPgObj.click_shop();
	    driver.close();
	}
	
}
