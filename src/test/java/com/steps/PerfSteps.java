package com.steps;

import java.util.Iterator;
import java.util.Set;



import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import vikas.SGDashboardPgObj;
import vikas.SGHomePgObj;
import vikas.SGLoginPgObj;


public class PerfSteps {
	
	public static WebDriver driver = new FirefoxDriver();;
	SGHomePgObj sgHomePgObj;
	SGLoginPgObj sgLoginPgObj;
	SGDashboardPgObj sgDashboardPgObj;


	@Given("^user direct to the site$")
	public void user_direct_to_the_site() throws Throwable {
		//driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.get("http://www.qnet.com.sg/");
		Thread.sleep(5000);
	 
	}

	@When("^user click on Login button$")
	public void user_click_on_Login_button() throws Throwable {
		sgHomePgObj = new SGHomePgObj(); 
		sgHomePgObj.click_irlogin();
	 
	}
	
	@When("^validate login page \"([^\"]*)\"$")
	public void validate_login_page(String arg1) throws Throwable {
	   
	}

	@When("^user enter a valid ID \"([^\"]*)\"$")
	public void user_enter_a_valid_ID(String arg1) throws Throwable {
		sgLoginPgObj = new SGLoginPgObj();
		sgLoginPgObj.enter_irid(arg1);
	 
	}

	@When("^user enter a password \"([^\"]*)\"$")
	public void user_enter_a_password(String arg1) throws Throwable {
	    sgLoginPgObj.enter_pwd(arg1);
	
	}

	@Then("^user click on login button$")
	public void user_click_on_login_button() throws Throwable {
	    sgLoginPgObj.click_login();
	 
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
		
		driver.switchTo().window(subWindowHandler).close();
		
		
	
		driver.switchTo().window(parentWindowHandler);
	 
	}

	@Then("^user click on shop link$")
	public void user_click_on_shop_link() throws Throwable {
		sgDashboardPgObj= new SGDashboardPgObj();
		sgDashboardPgObj.click_close();
		sgDashboardPgObj.click_shop();
	}
	
}
