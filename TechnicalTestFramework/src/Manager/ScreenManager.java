package Manager;

import java.io.File;
import java.io.IOException;
import org.apache.commons.io.FileUtils;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class ScreenManager {

	public static void takeScreenShot(WebDriver driver, String typeSS) {
		
		StringBuilder sb = new StringBuilder("ScreenShots/");
		sb.append(typeSS);

		File myScreenShot= ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	    try {
			FileUtils.copyFile(myScreenShot, 
					new File(sb.append(System.currentTimeMillis()).append(".png").toString()));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
