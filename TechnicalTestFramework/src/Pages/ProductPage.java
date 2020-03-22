package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import Manager.DriverManager;
import Manager.TimeHelper;

public class ProductPage {

	private WebDriver driver;
	private By addToCartButton;
	private By cartIcon;
	private By inputTypeList;
	
	public ProductPage(WebDriver driver){
		this.driver = driver;
		this.addToCartButton = By.name("add-to-cart");
		this.inputTypeList = By.tagName("input");
		this.cartIcon = By.xpath("//*[@id=\"site-header-cart\"]/li[1]/a");
	}
	
	public void goToPage(String url) {
		this.driver.navigate().to(url);
		
		TimeHelper.implicitWait(DriverManager.myDriver(), 10); //Wait for 10 seconds
		
		//Expected result
		Assert.assertTrue(this.driver
				.getTitle()
				.contains("Esteban Franco"), "The product Page didn't load property");
		Assert.assertTrue(this.driver
				.findElement(By.xpath("//*[@id=\"product-2266\"]/div[2]/h1"))
				.isDisplayed(), "The Product Title wasn't Displayed");
		Assert.assertTrue(this.driver
				.findElement(By.xpath("//*[@id=\"product-2266\"]/div[2]/p/span"))
				.isDisplayed(), "The Product Pricing wasn't Display");
		
	}
	public void addToCart() {
		
		this.driver.findElement(addToCartButton).click();
		
		By itemsCount = By.xpath("//*[@id=\"site-header-cart\"]/li[1]/a/span[2]");
		TimeHelper.explicitWait(this.driver, itemsCount, 5);
		
		//Verify Count of cart icon gets updated
		Assert.assertEquals(this.driver
				.findElement(itemsCount).getText()
				, "7 items", 
				"Problems to Add product");
	}
	
	public void IncrenseProduct(int count) {
		WebElement inputProductCount = this.driver.findElements(this.inputTypeList).get(2);
		inputProductCount.clear();
		inputProductCount.sendKeys(Integer.toString(count));
		
		//Verify the product count is 7
		Assert.assertEquals(inputProductCount.getAttribute("value"),"7"
				,"The quantity input didn't show the number 7");
	}
	
	public void clickOnCartIncon() {
		TimeHelper.explicitWait(this.driver, this.cartIcon, 5);
		
		this.driver.findElement(this.cartIcon).click();
		
		TimeHelper.implicitWait(this.driver, 5);
		
		//Validate the user navigate to correct URL
		Assert.assertEquals(this.driver.getCurrentUrl()
				,"http://34.205.174.166/cart/");
		
		//Validate Product the Shows in the list
		Assert.assertTrue(this.driver
				.findElement(By.xpath("//*[@id=\"post-7\"]/div/div/form/table/tbody/tr[1]/td[3]/a"))
				.getText().contains("Esteban"));
		
		//Validate the Price
		Assert.assertTrue(this.driver
				.findElement(By.xpath("//*[@id=\"post-7\"]/div/div/form/table/tbody/tr[1]/td[4]/span"))
				.getText().contains("105.99"));
		//Validate the count
		Assert.assertEquals(this.driver
				.findElement(By.name("cart[eb76c035d5d0a2bd2a0d0834b93c9c26][qty]"))
				.getAttribute("value"),"7");
	}
	
}
