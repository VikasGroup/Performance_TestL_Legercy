package com.steps;

import java.util.ArrayList;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import vikas.INDashboardPgObj;
import vikas.INHomePgObj;
import vikas.INLoginPgObj;


public class PerfSteps {
	
	public static WebDriver driver = new FirefoxDriver();;
	INHomePgObj inHomePgObj;
	INLoginPgObj inLoginPgObj;
	INDashboardPgObj inDashboardPgObj;


	@Given("^user direct to the site$")
	public void user_direct_to_the_site() throws Throwable {
		//driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.get("http://www.qnetindia.in/");
		Thread.sleep(5000);
	 
	}

	@When("^user click on Login button$")
	public void user_click_on_Login_button() throws Throwable {
		inHomePgObj = new INHomePgObj();
		inHomePgObj.click_irlogin();
	 
	}
	
	@When("^validate login page \"([^\"]*)\"$")
	public void validate_login_page(String arg1) throws Throwable {
	   
	}

	@When("^user enter a valid ID \"([^\"]*)\"$")
	public void user_enter_a_valid_ID(String arg1) throws Throwable {
		inLoginPgObj = new INLoginPgObj();
		inLoginPgObj.enter_irid(arg1);
	 
	}

	@When("^user enter a password \"([^\"]*)\"$")
	public void user_enter_a_password(String arg1) throws Throwable {
	    inLoginPgObj.enter_pwd(arg1);
	
	}

	@Then("^user click on login button$")
	public void user_click_on_login_button() throws Throwable {
	  inLoginPgObj.click_login();
	 
	}

	@Then("^validate the landing page \"([^\"]*)\"$")
	public void validate_the_landing_page(String arg1) throws Throwable {
		ArrayList<String> tabs2 = new ArrayList<String>(driver.getWindowHandles());
		  driver.switchTo().window(tabs2.get(1));
		  driver.switchTo().window(tabs2.get(2));
		  driver.switchTo().window(tabs2.get(2)).close();
		  driver.switchTo().window(tabs2.get(1)).close();
	 
	}

	@Then("^user click on shop link$")
	public void user_click_on_shop_link() throws Throwable {
		inDashboardPgObj = new INDashboardPgObj();
		inDashboardPgObj.click_shop();
	   
	}
	
}
