package util;



import java.util.Set;

import org.openqa.selenium.WebDriver;

import com.steps.PerfSteps;

public class TabCatcher {
	
	public static void setBaseTab(){
		
			Set<String> set = PerfSteps.driver.getWindowHandles();
			PerfSteps.driver.switchTo().window((String) set.toArray()[0]).close();
			PerfSteps.driver.switchTo().window((String) set.toArray()[1]);
			
			
	}
	

}
