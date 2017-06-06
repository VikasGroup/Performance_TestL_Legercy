package vikas;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.steps.PerfSteps;

public class SGLoginPgObj {

	
	public WebElement irid_txt = PerfSteps.driver.findElement(By.xpath(".//*[@id='ctl00_ctl00_ContentPlaceHolderBody_MainCosntent_txtTCO']"));
	public WebElement pwd_txt = PerfSteps.driver.findElement(By.xpath(".//*[@id='ctl00_ctl00_ContentPlaceHolderBody_MainCosntent_txtPassword']"));
	public WebElement login_btn = PerfSteps.driver.findElement(By.xpath(".//*[@id='ctl00_ctl00_ContentPlaceHolderBody_MainCosntent_btnLogin']"));
	
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
