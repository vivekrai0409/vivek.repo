package com.automation.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.automation.base.Driver;
import com.automation.base.SeleniumTest;

public class OrderSummaryPage {

	@FindBy(how=How.ID,using="total_price")
	private WebElement totalPrice;
	
	@FindBy(how=How.XPATH,using="(//a[@title='Proceed to checkout'])[2]")
	private WebElement processToChkoutBtn;
	
	@FindBy(how=How.XPATH, using="//form[@id='form']//label[@for='cgv']")
	private WebElement serviceTerm;
	
	@FindBy(how=How.XPATH,using="//button[@name='processAddress']")
	private WebElement processToChkoutBtn1;
	
	
	@FindBy(how=How.XPATH,using="//button[@name='processCarrier']")
	private WebElement processToChkoutBtn2;
	
	
	
	public OrderSummaryPage(){
		PageFactory.initElements(Driver.getIntsnace().getDriver(), this);
	}
	/*
	 * Get the total price of the product
	 */
	public String getTotalPrice() {
		return SeleniumTest.getText(totalPrice);
	}
	
	/*
	 * Click on process to checkout button
	 */
	public void clickOnProceedToCheckOut() {
		SeleniumTest.click(processToChkoutBtn);
	}
	
	/*
	 * Check the service term checkbox
	 */
	public void clickServiceTerm() {
		SeleniumTest.click(serviceTerm);
	}
	/*
	 * Click on process to checkout button1
	 */
	public void clickOnProceedToCheckOut1() {
		SeleniumTest.click(processToChkoutBtn1);
	}
	/*
	 * Click on process to checkout button2
	 */
	public void clickOnProceedToCheckOut2() {
		SeleniumTest.click(processToChkoutBtn2);
	}
}
