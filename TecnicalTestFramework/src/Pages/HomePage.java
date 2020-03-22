package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import Manager.DriverManager;
import Manager.TimeHelper;

public class HomePage {
	
	private WebDriver driver;
	By serchField;
	By hoodieWithPocketItem;
	
	public HomePage(WebDriver driver) {
		this.driver = driver;
		this.serchField = By.id("woocommerce-product-search-field-0");
		this.hoodieWithPocketItem = By.xpath("//*[@id=\"main\"]/ul/li[4]/a[1]/img");
	}
	
	public void goToHomePage(String url) {
		this.driver.get(url);
		
		TimeHelper.implicitWait(DriverManager.myDriver(), 5);
		
		Assert.assertTrue(this.driver.getTitle().contains("QA Playground")
				, "The Home Page didn't load property");
		Assert.assertTrue(this.driver
				.findElement(By.id("woocommerce-product-search-field-0")).isDisplayed());
	}
	
	public void fillSearchfield(String productName) {
		WebElement searchInput = this.driver.findElement(serchField);
		searchInput.sendKeys(productName);
	}
	
	public void pressEnterKey() {
		TimeHelper.explicitWait(this.driver, this.serchField, 5);
		this.driver.findElement(serchField).sendKeys(Keys.ENTER);
		
		TimeHelper.implicitWait(this.driver, 5);
		
		Assert.assertTrue(this.driver.getTitle().contains("Search Result"));
		Assert.assertTrue(DriverManager.myDriver()
				.findElement(By.xpath("//*[@id=\"main\"]/div[1]/p"))
				.getText().contains("4 result"));
	}
	
	public void clickOnHoodieWithPocket() {
		this.driver.findElement(this.hoodieWithPocketItem).click();
		
		TimeHelper.implicitWait(this.driver, 5);
		
		Assert.assertTrue(this.driver.getTitle().contains("Hoodie with Pocket"));
	}
	
}
