package com.automation.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.automation.base.Driver;
import com.automation.base.SeleniumTest;

public class MyStorePage {

	
	
	@FindBy(how=How.XPATH,using="//div[@id='block_top_menu']//li/a[@title='Women']")
	private WebElement womenTab;
	
	@FindBy(how=How.XPATH,using="//a[@title='Orders' and @href='http://automationpractice.com/index.php?controller=history']")
	private WebElement orderHistoryDetails;
	
	@FindBy(how=How.XPATH,using="//td[@class='history_price']")
	private WebElement totalPrice;
	
	
	WomenMyStorePage womentStorePage;
	
	public MyStorePage() {
		PageFactory.initElements(Driver.getIntsnace().getDriver(),this);
	}
	
	/*
	 * Click on Women tab
	 */
	public WomenMyStorePage clickWomenTab() {
		SeleniumTest.click(womenTab);
		return womentStorePage;
	}
	
	/*
	 * Click on order history details
	 */
	public void clickOrderHistory() {
		SeleniumTest.click(orderHistoryDetails);
	}
	/*
	 * Get total price
	 */
	public String getTotalPrice() {
		return SeleniumTest.getText(totalPrice).trim();
	}
}
