package com.automation.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.automation.base.Driver;
import com.automation.base.SeleniumTest;

public class PaymentSummaryPage {

	@FindBy(how=How.ID,using="total_price")
	private WebElement totalPrice;
	
	@FindBy(how=How.XPATH,using="//a[@title='Pay by bank wire']")
	private WebElement payByBankWire;
	
	@FindBy(how=How.XPATH,using="//button[@type='submit']/span[text()='I confirm my order']")
	private WebElement confirmOrder;
	
	
	
	public PaymentSummaryPage() {
		PageFactory.initElements(Driver.getIntsnace().getDriver(), this);
	}
	
	/*
	 * Get the total amount on payment summary page
	 */
	public String getTextTotalPrice() {
		return SeleniumTest.getText(totalPrice);
	}
	
	/*
	 * Click on Pay By Bank Wire option to make the payment
	 */
	public void clickPayByBankWire() {
		SeleniumTest.click(payByBankWire);
	}
	
	/*
	 * Click on confirm order
	 */
	public void confirmOrder() {
		SeleniumTest.click(confirmOrder);
	}
}
