package com.tutorialsninja.qa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RegisterPage {

	WebDriver driver;

	@FindBy(id = "input-firstname")
	private WebElement firstName;

	@FindBy(id = "input-lastname")
	private WebElement lastName;

	@FindBy(id = "input-email")
	private WebElement emailField;

	@FindBy(id = "input-telephone")
	private WebElement telephoneNumber;

	@FindBy(id = "input-password")
	private WebElement passwordFiled;

	@FindBy(id = "input-confirm")
	private WebElement passwordConfirm;

	@FindBy(name = "agree")
	private WebElement privacyCheckbox;

	@FindBy(xpath = "//input[@class=\"btn btn-primary\"]")
	private WebElement continueButton;
	
	@FindBy(xpath = "//div[@class=\"alert alert-danger alert-dismissible\"]")
	private WebElement duplicateEmailWarning;

	public RegisterPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public void enterFirstName(String FirstName) {
		firstName.sendKeys(FirstName);

	}

	public void enterLastName(String LastName) {
		lastName.sendKeys(LastName);

	}

	public void enterEmail(String Email) {
		emailField.sendKeys(Email);
	}
	
	public void enterTelephoneNumber(String TelephoneNumber) {
		telephoneNumber.sendKeys(TelephoneNumber);

	}
	
	public void enterPasswordFiled(String Password) {
		passwordFiled.sendKeys(Password);
	}
	
	public void enterConfirmPasswordFiled(String PasswordConfirm) {
		passwordConfirm.sendKeys(PasswordConfirm);

	}
	
	public void tickPrivacyCheckbox() {
		privacyCheckbox.click();

	}
	public AccountPage clickContinueButton() {
		continueButton.click();
		return new AccountPage(driver);

	}
	public String duplicateEmailWarning() {
		return duplicateEmailWarning.getText();

	}

}
