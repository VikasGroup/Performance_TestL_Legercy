package vikas;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.steps.PerfSteps;

public class WPDashboardPgObj {


	
	public WebElement shop_link = PerfSteps.driver.findElement(By.id("ctl00_TabMenu1_lbnShopNow"));
	public WebElement close_btn = PerfSteps.driver.findElement(By.xpath(".//*[@id='ctl00_objHTML']/body/div[1]/div/div/a"));
	
	public void click_shop(){
		shop_link.click();
	}
	public void click_close(){
		close_btn.click();
	}
	
}
