package com.tutorialsninja.qa.testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.tutorialsninja.qa.base.base;
import com.tutorialsninja.qa.pages.AccountPage;
import com.tutorialsninja.qa.pages.Homepage;
import com.tutorialsninja.qa.pages.RegisterPage;
import com.tutorialsninja.qa.utils.Utilities;

public class RegisterTest extends base {
	RegisterPage registerpage;
	AccountPage accountpage;
	public RegisterTest() {
		super();

	}

	public WebDriver driver;
	

	@BeforeMethod
	public void setup() {

		driver = initializeBrowserAndOpenApplicationURL(prop.getProperty("browser"));
		Homepage homepage = new Homepage(driver);
		registerpage =homepage.navigatetoRegisterPage();
		
		//driver.findElement(By.xpath("//i[@class=\"fa fa-user\"]")).click();
		//driver.findElement(By.xpath("//ul[@class=\"dropdown-menu dropdown-menu-right\"]//a[text()=\"Register\"]")).click();

	}

	@AfterMethod
	public void Closure() {

		driver.quit();

	}

	@Test(priority = 1)
	public void VerifyRegisterwithMandatoryField() {
		
		registerpage.enterFirstName(dataprop.getProperty("firstname"));
		registerpage.enterLastName(dataprop.getProperty("lastname"));
		registerpage.enterEmail(Utilities.timeStamp());
		registerpage.enterTelephoneNumber(dataprop.getProperty("telephone"));
		registerpage.enterPasswordFiled(prop.getProperty("validPassword"));
		registerpage.enterConfirmPasswordFiled(prop.getProperty("validPassword"));
		registerpage.tickPrivacyCheckbox();
		accountpage = registerpage.clickContinueButton();
		
		Assert.assertTrue(accountpage.accountCreatedmessage());
		//driver.findElement(By.id("input-firstname")).sendKeys(dataprop.getProperty("firstname"));
		//driver.findElement(By.id("input-lastname")).sendKeys(dataprop.getProperty("lastname"));
		//driver.findElement(By.id("input-email")).sendKeys(Utilities.timeStamp());
		//driver.findElement(By.id("input-telephone")).sendKeys(dataprop.getProperty("telephone"));
		//driver.findElement(By.id("input-password")).sendKeys(prop.getProperty("validPassword"));
		//driver.findElement(By.id("input-confirm")).sendKeys(prop.getProperty("validPassword"));
		//driver.findElement(By.name("agree")).click();
		//driver.findElement(By.xpath("//input[@class=\"btn btn-primary\"]")).click();
		//Assert.assertTrue(
			//	driver.findElement(By.xpath("//ul[@class=\"breadcrumb\"]//a[text()=\"Success\"]")).isDisplayed());

	}

	@Test(priority = 2)
	public void VerifyRegisterwithAllField() {
		
		registerpage.enterFirstName(dataprop.getProperty("firstname"));
		registerpage.enterLastName(dataprop.getProperty("lastname"));
		registerpage.enterEmail(Utilities.timeStamp());
		registerpage.enterTelephoneNumber(dataprop.getProperty("telephone"));
		registerpage.enterPasswordFiled(prop.getProperty("validPassword"));
		registerpage.enterConfirmPasswordFiled(prop.getProperty("validPassword"));
		registerpage.tickPrivacyCheckbox();
		registerpage.clickContinueButton();
		Assert.assertTrue(accountpage.accountCreatedmessage());

		/*driver.findElement(By.id("input-firstname")).sendKeys(dataprop.getProperty("firstname"));
		driver.findElement(By.id("input-lastname")).sendKeys(dataprop.getProperty("lastname"));
		driver.findElement(By.id("input-email")).sendKeys(Utilities.timeStamp());
		driver.findElement(By.id("input-telephone")).sendKeys(dataprop.getProperty("telephone"));
		driver.findElement(By.id("input-password")).sendKeys(prop.getProperty("validPassword"));
		driver.findElement(By.id("input-confirm")).sendKeys(prop.getProperty("validPassword"));
		driver.findElement(By.name("agree")).click();
		driver.findElement(By.xpath("//input[@class=\"btn btn-primary\"]")).click();
		Assert.assertTrue(
				driver.findElement(By.xpath("//ul[@class=\"breadcrumb\"]//a[text()=\"Success\"]")).isDisplayed());*/

	}

	@Test(priority = 3, dependsOnMethods = {"VerifyRegisterwithAllField"})
	public void VerifyRegisterwithDuplicateEmail() {
		
		registerpage.enterFirstName(dataprop.getProperty("firstname"));
		registerpage.enterLastName(dataprop.getProperty("lastname"));
		registerpage.enterEmail(prop.getProperty("validEmail"));
		registerpage.enterTelephoneNumber(dataprop.getProperty("telephone"));
		registerpage.enterPasswordFiled(prop.getProperty("validPassword"));
		registerpage.enterConfirmPasswordFiled(prop.getProperty("validPassword"));
		registerpage.tickPrivacyCheckbox();
		registerpage.clickContinueButton();
		//Assert.assertEquals(registerpage.duplicateEmailWarning(), "dataprop.getProperty(\"duplicateEmailWarning\")");

		/*driver.findElement(By.id("input-firstname")).sendKeys(dataprop.getProperty("firstname"));
		driver.findElement(By.id("input-lastname")).sendKeys(dataprop.getProperty("lastname"));
		driver.findElement(By.id("input-email")).sendKeys(prop.getProperty("validEmail"));
		driver.findElement(By.id("input-telephone")).sendKeys(dataprop.getProperty("telephone"));
		driver.findElement(By.id("input-password")).sendKeys(prop.getProperty("validPassword"));
		driver.findElement(By.id("input-confirm")).sendKeys(prop.getProperty("validPassword"));
		driver.findElement(By.name("agree")).click();
		driver.findElement(By.xpath("//input[@class=\"btn btn-primary\"]")).click();*/

		Assert.assertEquals(
				driver.findElement(By.xpath("//div[@class=\"alert alert-danger alert-dismissible\"]")).getText(),
				dataprop.getProperty("duplicateEmailWarning"));
	}

	@Test(priority = 4)
	public void VerifyRegisterwithoutField() {
		
		
		registerpage.tickPrivacyCheckbox();
		registerpage.clickContinueButton();
		
		//driver.findElement(By.name("agree")).click();
		//driver.findElement(By.xpath("//input[@class=\"btn btn-primary\"]")).click();
		Assert.assertEquals(driver
				.findElement(By.xpath("//div[text()=\"First Name must be between 1 and 32 characters!\"]")).getText(),
				dataprop.getProperty("BlankFirstName"));

	}

}
