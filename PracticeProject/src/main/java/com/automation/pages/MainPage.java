package com.automation.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.automation.base.Driver;
import com.automation.base.SeleniumTest;

public class MainPage {

	@FindBy(how=How.XPATH, using="//a[@href='http://automationpractice.com/index.php?controller=my-account' and @title='Log in to your customer account']")
	private  WebElement signINBtn;
	
	@FindBy(how=How.XPATH, using="//a[@href='http://automationpractice.com/index.php?controller=contact' and @title='Contact Us']")
	private WebElement contactUs;
	
	@FindBy(how=How.XPATH, using="//a[@title='View my customer account']")
	private WebElement viewMyCustomerAcc;
	
	MyAccountPage myAccPage;
	
	public MainPage() {
		PageFactory.initElements(Driver.getIntsnace().getDriver(), this);
	}
	
	public WebElement getSignInBtn() {
		return signINBtn;
	}
	
	public WebElement getContactUsBtn() {
		return contactUs;
	}
	
	/*
	 * On Main page click on sign in button
	 */
	public MyAccountPage clickSignInBtn() {
		SeleniumTest.click(signINBtn);
		return myAccPage;
	}
	
	/*
	 * On Main page click on contact us button
	 */
	
	public void clickContactUs() {
		SeleniumTest.click(contactUs);
		
	}
	/*
	 * Click on View my customer account
	 */
	public void clickViewMyCusAcc() {
		SeleniumTest.click(viewMyCustomerAcc);
	}
}
