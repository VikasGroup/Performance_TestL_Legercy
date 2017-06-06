package com.steps;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pgobjects.vikas.PHDashboardPgObj;
import pgobjects.vikas.PHHomePgObj;
import pgobjects.vikas.PHLoginPgObj;





public class PerfSteps {
	
	public static WebDriver driver = new FirefoxDriver();
	PHHomePgObj phHomePgObj;
	PHLoginPgObj phLoginPgObj;
	PHDashboardPgObj phDashboardPgObj;
	
	@Given("^user direct to the site$")
	public void user_direct_to_the_site() throws Throwable {
		//driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.get("http://www.qnet.net.ph/");
		Thread.sleep(5000);
	 
	}

	@When("^user click on Login button$")
	public void user_click_on_Login_button() throws Throwable {
	 phHomePgObj = new PHHomePgObj();
	 phHomePgObj.click_irlogin();
	   
	 
	}

	@When("^validate login page \"([^\"]*)\"$")
	public void validate_login_page(String arg1) throws Throwable {
	   
	 
	}

	@When("^user enter a valid ID \"([^\"]*)\"$")
	public void user_enter_a_valid_ID(String arg1) throws Throwable {
	   phLoginPgObj = new PHLoginPgObj();
	   phLoginPgObj.enter_irid(arg1);
	 
	}

	@When("^user enter a password \"([^\"]*)\"$")
	public void user_enter_a_password(String arg1) throws Throwable {
	   phLoginPgObj.enter_pwd(arg1);
	 
	}

	@Then("^user click on login button$")
	public void user_click_on_login_button() throws Throwable {
	   phLoginPgObj.click_login();
	 
	}

	@Then("^validate the landing page \"([^\"]*)\"$")
	public void validate_the_landing_page(String arg1) throws Throwable {
	   
		String parentWindowHandler = driver.getWindowHandle(); // Store your parent window
		String subWindowHandler = null;

		Set<String> handles = driver.getWindowHandles(); // get all window handles
		Iterator<String> iterator = handles.iterator();
		while (iterator.hasNext()){
		    subWindowHandler = iterator.next();
		}
		//driver.switchTo().window(subWindowHandler); // switch to popup window
		driver.switchTo().window(subWindowHandler).close();
		// Now you are in the popup window, perform necessary actions here

		driver.switchTo().window(parentWindowHandler);
	}

	@Then("^user click on shop link$")
	public void user_click_on_shop_link() throws Throwable {
	   phDashboardPgObj = new PHDashboardPgObj();
	   phDashboardPgObj.click_shop();
	 
	}
	
}
