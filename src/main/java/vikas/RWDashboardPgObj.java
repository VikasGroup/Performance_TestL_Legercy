package vikas;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.steps.PerfSteps;

public class RWDashboardPgObj {


	
	public WebElement shop_link = PerfSteps.driver.findElement(By.xpath(".//*[@id='ctl00_ctl00_ContentPlaceHolderBody_TabMenu_lbnShopNow']"));
	
	public void click_shop(){
		shop_link.click();
	}
}
