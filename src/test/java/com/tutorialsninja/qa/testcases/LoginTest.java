package com.tutorialsninja.qa.testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.tutorialsninja.qa.base.base;
import com.tutorialsninja.qa.pages.AccountPage;
import com.tutorialsninja.qa.pages.Homepage;
import com.tutorialsninja.qa.pages.LoginPage;
import com.tutorialsninja.qa.utils.Utilities;

public class LoginTest extends base {
	LoginPage loginpage;
	public LoginTest() {
		super();

	}

	public WebDriver driver;
	

	@BeforeMethod
	public void setup() {

		driver = initializeBrowserAndOpenApplicationURL(prop.getProperty("browser"));
		Homepage homepage = new Homepage(driver);
		loginpage = homepage.navigatetoLoginPage();
		// driver.findElement(By.xpath("//i[@class=\"fa fa-user\"]")).click();
		// driver.findElement(By.xpath("//ul[@class=\"dropdown-menu
		// dropdown-menu-right\"]//a[text()=\"Login\"]")).click();
	}

	@AfterMethod
	public void Closure() {

		driver.quit();

	}

	@Test(priority = 1, dataProvider = "DataSupplier")
	public void Verifylogingwithvalidcredentials(String Email, String Password) {

		

		AccountPage accountpage =loginpage.login(Email, Password);
		/*
		 * driver.findElement(By.id("input-email")).sendKeys(Email);
		 * driver.findElement(By.id("input-password")).sendKeys(Password);
		 * driver.findElement(By.xpath("//input[@value=\"Login\"]")).click();
		 */

		Assert.assertTrue(accountpage.accountBreadcrumb());

		// Assert.assertTrue(driver.findElement(By.xpath("//ul[@class=\"breadcrumb\"]")).isDisplayed());

	}

	@Test(priority = 2)
	public void VerifylogingwithInvalidcredentials() {
		loginpage.login(dataprop.getProperty("invalidEmail"), dataprop.getProperty("invalidPassword"));
		

		/*driver.findElement(By.id("input-email")).sendKeys(dataprop.getProperty("invalidEmail"));
		driver.findElement(By.id("input-password")).sendKeys(dataprop.getProperty("invalidPassword"));
		driver.findElement(By.xpath("//input[@value=\"Login\"]")).click();*/
		Assert.assertTrue(loginpage.invalidEmailWarning(dataprop.getProperty("Warning")));
		//Assert.assertEquals(driver.findElement(By.xpath("//div[@class=\"alert alert-danger alert-dismissible\"]")).getText(),dataprop.getProperty("Warning"));

	}

	@Test(priority = 3)
	public void VerifylogingwithInvalidEmailValidPassword() {
		loginpage.login(dataprop.getProperty("invalidEmail"), prop.getProperty("validPassword"));
		
		//driver.findElement(By.id("input-email")).sendKeys(dataprop.getProperty("invalidEmail"));
		//driver.findElement(By.id("input-password")).sendKeys(prop.getProperty("validPassword"));
		//driver.findElement(By.xpath("//input[@value=\"Login\"]")).click();
		Assert.assertTrue(loginpage.invalidEmailWarning(dataprop.getProperty("Warning")));

		//Assert.assertEquals(
				//driver.findElement(By.xpath("//div[@class=\"alert alert-danger alert-dismissible\"]")).getText(),
				//dataprop.getProperty("Warning"));

	}

	@Test(priority = 4)
	public void VerifylogingwithValidEmailInvalidPassword() {
		loginpage.login(prop.getProperty("validEmail"), dataprop.getProperty("invalidPassword"));
		
		//driver.findElement(By.id("input-email")).sendKeys(prop.getProperty("validEmail"));
		//driver.findElement(By.id("input-password")).sendKeys(dataprop.getProperty("invalidPassword"));
		//driver.findElement(By.xpath("//input[@value=\"Login\"]")).click();
		Assert.assertTrue(loginpage.invalidEmailWarning(dataprop.getProperty("Warning")));
		//Assert.assertEquals(
				//driver.findElement(By.xpath("//div[@class=\"alert alert-danger alert-dismissible\"]")).getText(),
				//dataprop.getProperty("Warning"));

	}

	@Test(priority = 5)
	public void VerifylogingwithoutCredentials() {

		//driver.findElement(By.xpath("//input[@value=\"Login\"]")).click();
		loginpage.login(" ", " ");
		Assert.assertTrue(loginpage.invalidEmailWarning(dataprop.getProperty("Warning")));
		//Assert.assertEquals(
				//driver.findElement(By.xpath("//div[@class=\"alert alert-danger alert-dismissible\"]")).getText(),
				//dataprop.getProperty("Warning"));

	}

	@DataProvider(name = "DataSupplier")
	public Object[][] supplyTestData() {

		Object[][] data = Utilities.getTestData("Login");

		return data;

	}

}
