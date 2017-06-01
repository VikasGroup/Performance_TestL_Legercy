package vikas;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.steps.PerfSteps;

public class WPLoginPgObj {

	
	public WebElement irid_txt = PerfSteps.driver.findElement(By.id("ctl00_ContentPlaceHolder1_txtTCO"));
	public WebElement pwd_txt = PerfSteps.driver.findElement(By.id("ctl00_ContentPlaceHolder1_txtPassword"));
	public WebElement login_btn = PerfSteps.driver.findElement(By.id("ctl00_ContentPlaceHolder1_btnLogin"));
	
	public void enter_irid(String value){
		irid_txt.sendKeys(value);
	}
	public void enter_pwd(String value){
		pwd_txt.sendKeys(value);
	}
	public void click_login(){
		login_btn.click();
	}
}
