package Manager;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DriverManager {

	private static WebDriver myDriver;
	
	public static WebDriver newDriver() {
		myDriver = new  ChromeDriver();
		return myDriver;	
	}
	
	public static WebDriver myDriver() {
		return myDriver;
	}
	
	public static void closeDriver() {
		myDriver.close();
	}
	
	public static void quitDriver() {
		myDriver.quit();
	}
		
}
