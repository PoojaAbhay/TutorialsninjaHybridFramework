package com.tutorialsninja.qa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	WebDriver driver;

	@FindBy(id = "input-email")
	private WebElement emailAddress;
	
	@FindBy(id = "input-password")
	private WebElement passwordField;
	
	@FindBy(xpath ="//input[@value=\"Login\"]")
	private WebElement loginButton;
	
	@FindBy(xpath ="//div[@class=\"alert alert-danger alert-dismissible\"]")
	private WebElement InvalidEmailWarning;
	
	
	public LoginPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

	
	public void enterEmailAddress(String Email) {
		 emailAddress.sendKeys(Email);
		
	}
	
	public void enterPAssword(String Password) {
		passwordField.sendKeys(Password);
		
	}
	
	public AccountPage login(String Email, String Password) {
		emailAddress.sendKeys(Email);
		passwordField.sendKeys(Password);
		loginButton.click();
		return new AccountPage(driver);
		
	}
	
	public Boolean invalidEmailWarning(String invalidEmailWarning) {
		return InvalidEmailWarning.getText().equalsIgnoreCase(invalidEmailWarning);
		
	}
	
}
