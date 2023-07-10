package com.tutorialsninja.qa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AccountPage {

	WebDriver driver;

	@FindBy(xpath = "//ul[@class=\"breadcrumb\"]//a[text()=\"Account\"]")
	private WebElement accountBreadcrumb;
	
	@FindBy(xpath = "//ul[@class=\"breadcrumb\"]//a[text()=\"Success\"]")
	private WebElement accountCreatedmessage;

	public AccountPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

	public Boolean accountBreadcrumb() {
		return accountBreadcrumb.isDisplayed();
	}
	
	public Boolean accountCreatedmessage() {
		return accountCreatedmessage.isDisplayed();
	}
}
