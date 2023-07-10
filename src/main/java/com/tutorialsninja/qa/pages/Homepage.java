package com.tutorialsninja.qa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Homepage {
	WebDriver driver;
	@FindBy(xpath ="//a[@title=\"My Account\"]")
	private WebElement myAccountDropmenu;
	
	@FindBy(xpath="//ul[@class=\"dropdown-menu dropdown-menu-right\"]//a[text()=\"Login\"]")
	private WebElement LoginOption;
	
	@FindBy(xpath="//ul[@class=\"dropdown-menu dropdown-menu-right\"]//a[text()=\"Register\"]")
	private WebElement RegisterOption;
	
	@FindBy(name ="search")
	private WebElement SearchField;
	
	@FindBy(xpath ="//span[@class=\"input-group-btn\"]")
	private WebElement SearchButton;
	
	
	public Homepage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

	
	public LoginPage navigatetoLoginPage() {
		myAccountDropmenu.click();
		LoginOption.click();
		return new LoginPage(driver);
		
	}
	
	public RegisterPage navigatetoRegisterPage() {
		myAccountDropmenu.click();
		RegisterOption.click();
		return new RegisterPage(driver);
		
	}
	
	public void EnterProductinSearch(String ProductName) {
		SearchField.sendKeys(ProductName);
		
	}
	public SearchPage clickonSearchButton() {
		SearchButton.click();
		return new SearchPage(driver);
		
	}
}
