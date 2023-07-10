package com.tutorialsninja.qa.testcases;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.tutorialsninja.qa.base.base;
import com.tutorialsninja.qa.pages.Homepage;
import com.tutorialsninja.qa.pages.SearchPage;

public class SearchTest extends base {
	SearchPage searchpage;
	Homepage homepage;
	public SearchTest () {
		super();
		
	}
	public WebDriver driver;
	
	//Updated by team member!!
	
	

	@BeforeMethod

	public void setup() {
	
		
		driver = initializeBrowserAndOpenApplicationURL(prop.getProperty("browser"));

	}

	@AfterMethod

	public void Closure() {

		driver.quit();

	}

	@Test

	public void VerifySearchwithExistingProductName() {
		
		homepage = new Homepage(driver);
		homepage.EnterProductinSearch(dataprop.getProperty("searchProduct"));
		searchpage=homepage.clickonSearchButton();
		//driver.findElement(By.name("search")).sendKeys(dataprop.getProperty("searchProduct"));
		//driver.findElement(By.xpath("//span[@class=\"input-group-btn\"]")).click();
		Assert.assertTrue(searchpage.productdisplyaed());
		//Assert.assertTrue(driver.findElement(By.linkText("HP LP3065")).isDisplayed());

	}
	@Test

	public void VerifySearchwithInvalidProductName() {
		homepage = new Homepage(driver);
		homepage.EnterProductinSearch(dataprop.getProperty("invalidProduct"));
		homepage.clickonSearchButton();
		//driver.findElement(By.name("search")).sendKeys(dataprop.getProperty("invalidProduct"));
		//driver.findElement(By.xpath("//span[@class=\"input-group-btn\"]")).click();
		Assert.assertEquals(driver.findElement(By.xpath("//p[text()=\"There is no product that matches the search criteria.\"]")).getText(),dataprop.getProperty("notAvailableWarning"));

	}
	@Test

	public void VerifySearchwithoutProductName() {
		homepage = new Homepage(driver);
		homepage.clickonSearchButton();
		//driver.findElement(By.name("search")).sendKeys("");
		//driver.findElement(By.xpath("//span[@class=\"input-group-btn\"]")).click();
		Assert.assertEquals(driver.findElement(By.xpath("//p[text()=\"There is no product that matches the search criteria.\"]")).getText(),dataprop.getProperty("notAvailableWarning"));

	}
	
	
	
	

}
