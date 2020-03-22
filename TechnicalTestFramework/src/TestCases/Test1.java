package TestCases;

import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import Manager.DriverManager;
import Manager.ScreenManager;
import Pages.HomePage;
import Pages.ProductPage;

public class Test1 {
  	
	@BeforeMethod
	public void startUp() {
		System.setProperty("webdriver.chrome.driver", "Drivers/chromedriver.exe");
		DriverManager.newDriver();
		DriverManager.myDriver().manage().window().maximize();
	}
	
	@Test(priority = 1)
	public void validateTheProductCanBeAddedToCart() {
		//STEP 1, NAVIGATE TO THE PROJECT	
		ProductPage productPage = new ProductPage(DriverManager.myDriver());
		productPage.goToPage("http://34.205.174.166/product/esteban-franco/");
		
		//STEP 2, INCREANSE DE QUALITY NUMBER TO 7
		productPage.IncrenseProduct(7);		
		
		//STEP 3, ADD TO CART
		productPage.addToCart();

		//STEP 4, CLICK TO CART ICON
		productPage.clickOnCartIncon();
		
	}
	
	@Test(priority = 2)
	public void VerifyUsersCanSearchHoodie() {
		//STEP 1, NAVIGATE TO THE HOME PAGE
		HomePage homePage = new HomePage(DriverManager.myDriver());
		homePage.goToHomePage("http://34.205.174.166/");
		
		//STEP 2, FILL THE SEARCH INPUT
		homePage.fillSearchfield("Hoodie");
		//Expected Result

		//STEP 3, PRESS ENTER KEY
		homePage.pressEnterKey();
				
		//STEP 4, CLICK ON HOODIE WITH POCKT
		homePage.clickOnHoodieWithPocket();
	}
	
	@AfterMethod
	public void closeMethod(ITestResult result) {
		String typeSS = "bugs/";
		
		//IF TEST RESULT IS PASSED TAKE A SCREENSHOT
		if(result.isSuccess()) typeSS = "evidence/";
		
		ScreenManager.takeScreenShot(DriverManager.myDriver(), typeSS);
		DriverManager.closeDriver();
	}
	
}
