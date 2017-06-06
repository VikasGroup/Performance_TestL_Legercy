package vikas;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.steps.PerfSteps;

public class MYHomePgObj {

	
	public WebElement irlogin_lnk = PerfSteps.driver.findElement(By.xpath(".//*[@id='ctl00_ctl13_hlLogin']"));
	
	public void click_irlogin(){
		irlogin_lnk.click();
	}
}
