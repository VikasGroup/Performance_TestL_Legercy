package vikas;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.steps.PerfSteps;

public class RWDashboardPgObj {


	

	public WebElement closebtn = PerfSteps.driver.findElement(By.xpath(".//*[@id='ctl00_objHTML']/body/div[3]/div/div/a"));
	
	public void click_shop(){
		 WebElement shop_link = PerfSteps.driver.findElement(By.xpath(".//*[@id='ctl00_TabMenu1_lbnShopNow']"));
		shop_link.click();
	}
	public void clickCloseBtn(){
		closebtn.click();
	}
}
