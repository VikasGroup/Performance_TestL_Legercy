package vikas;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.steps.PerfSteps;

public class WPHomePgObj {

	
	public WebElement irlogin_lnk = PerfSteps.driver.findElement(By.id("ctl00_ctl11_hlLogin"));
	
	public void click_irlogin(){
		irlogin_lnk.click();
	}
}
