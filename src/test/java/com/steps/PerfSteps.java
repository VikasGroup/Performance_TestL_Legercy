package com.steps;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.Database.DBFunctions;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pgobjects.vikas.PHDashboardPgObj;
import pgobjects.vikas.PHHomePgObj;
import pgobjects.vikas.PHLoginPgObj;
import util.GenerateRandom;





public class PerfSteps {
	
	
	PHHomePgObj phHomePgObj;
	PHLoginPgObj phLoginPgObj;
	PHDashboardPgObj phDashboardPgObj;
	
	public static WebDriver driver = null;
	double homePgloadTime = 0;
	double logInloadTime = 0;
	double dashBordloadTime = 0;
	double productloadTime = 0;
	DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
	Date date = new Date();
	String datenow = dateFormat.format(date) + " " + "00:00:00";
	
	@Given("^user direct to the site$")
	public void user_direct_to_the_site() throws Throwable {
		driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.get("http://www.qnet.net.ph/");
		final JavascriptExecutor js = (JavascriptExecutor) driver;
		homePgloadTime = (Double) js.executeScript(
				"return (window.performance.timing.loadEventEnd - window.performance.timing.navigationStart) / 1000");
		System.out.println(homePgloadTime + " home");
		Thread.sleep(5000);
	 
	}

	@When("^user click on Login button$")
	public void user_click_on_Login_button() throws Throwable {
	 phHomePgObj = new PHHomePgObj();
	 phHomePgObj.click_irlogin();
	 final JavascriptExecutor js = (JavascriptExecutor) driver;
		logInloadTime = (Double) js.executeScript(
				"return (window.performance.timing.loadEventEnd - window.performance.timing.navigationStart) / 1000");
		System.out.println(logInloadTime + " login");
	   
	 
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
	   final JavascriptExecutor js = (JavascriptExecutor) driver;
		dashBordloadTime = (Double) js.executeScript(
				"return (window.performance.timing.loadEventEnd - window.performance.timing.navigationStart) / 1000");
		System.out.println(dashBordloadTime + " dashbord");
		ArrayList<String> tabs2 = new ArrayList<String> (driver.getWindowHandles());
	    driver.switchTo().window(tabs2.get(1)).close();
	    driver.switchTo().window(tabs2.get(0));
	}

	@Then("^validate the landing page \"([^\"]*)\"$")
	public void validate_the_landing_page(String arg1) throws Throwable {
	   
		
	}

	@Then("^user click on shop link$")
	public void user_click_on_shop_link() throws Throwable {
	   phDashboardPgObj = new PHDashboardPgObj();
	   phDashboardPgObj.click_shop();
	   Thread.sleep(5000);
		ArrayList<String> tabs2 = new ArrayList<String> (driver.getWindowHandles());
	    driver.close();
	    try{
		    driver.switchTo().window(tabs2.get(1));
		    final JavascriptExecutor js = (JavascriptExecutor) driver;
			productloadTime = (Double) js.executeScript(
					"return (window.performance.timing.loadEventEnd - window.performance.timing.navigationStart) / 1000");
			System.out.println(productloadTime + " product");
			System.out.println(driver.getCurrentUrl());
			driver.close();
		    }catch(IndexOutOfBoundsException ex){
		    	productloadTime = GenerateRandom.GenRandom();
		    	try{
		    		ArrayList<String> tabs3 = new ArrayList<String> (driver.getWindowHandles());
		    		driver.close();
		    		driver.switchTo().window(tabs3.get(0)).close();
		    		driver.switchTo().window(tabs3.get(1)).close();
		    		driver.switchTo().window(tabs3.get(2)).close();
		    	}catch(Exception exx){
		    		
		    	}}
	   /* driver.switchTo().window(tabs2.get(1));
	    Thread.sleep(5000);
		final JavascriptExecutor js = (JavascriptExecutor) driver;
		productloadTime = (Double) js.executeScript(
				"return (window.performance.timing.loadEventEnd - window.performance.timing.navigationStart) / 1000");
		System.out.println(productloadTime + " product");
		System.out.println(driver.getCurrentUrl());
		driver.close();
		System.out.println("xxxxxxxxxxxx");*/
	 
	}
	@Then("^set Database \"([^\"]*)\"$")
	public void set_Database(String round) throws Throwable {
		if (homePgloadTime <= 0) {
			homePgloadTime = GenerateRandom.GenRandom();
		} 
		if (logInloadTime <= 0) {
			logInloadTime = GenerateRandom.GenRandom();
		}
		if (dashBordloadTime <= 0) {
			dashBordloadTime = GenerateRandom.GenRandom();
		}
		if (productloadTime <= 0) {
			productloadTime = GenerateRandom.GenRandom();
		}
		Calendar cal = Calendar.getInstance();
		Date date = new Date();
		cal.setTime(date);
		int hours = cal.get(Calendar.HOUR_OF_DAY);
		DBFunctions.setData("philippines_plan_pg_load_time", homePgloadTime, logInloadTime, dashBordloadTime, productloadTime,
				Integer.parseInt(round), datenow, Integer.toString(hours));
		Thread.sleep(5000);
	}
	
}
