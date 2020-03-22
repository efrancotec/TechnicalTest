package Manager;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TimeHelper {

	public static void implicitWait(WebDriver driver, int time) {
		
		driver.manage().timeouts().implicitlyWait(time, TimeUnit.SECONDS);
	}
	
	public static void explicitWait(WebDriver driver, By locator, int time) {
		WebDriverWait explicitWait = new WebDriverWait(driver, time);
		
		explicitWait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(locator));
	}
	
}
