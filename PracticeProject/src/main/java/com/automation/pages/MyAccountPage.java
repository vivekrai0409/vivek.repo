package com.automation.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.automation.base.Driver;
import com.automation.base.SeleniumTest;

public class MyAccountPage {

	CreateAccountPage createAccountPage;
	
	@FindBy(how=How.ID, using="email_create")
	private WebElement email;
	
	@FindBy(how=How.ID,using="SubmitCreate")
	private WebElement createAcclink;
	
	public MyAccountPage() {
		PageFactory.initElements(Driver.getIntsnace().getDriver(),this);
	}
	
	/*
	 * To enter emailID on My Account page
	 */
	public void enterEmail(String emailID) {
		SeleniumTest.enterText(email, emailID);
	}
	
	/*
	 * To click on create account link on My Account page
	 */
	public CreateAccountPage clickCreateAcc() {
		SeleniumTest.click(createAcclink);
		return createAccountPage;
	}
}
