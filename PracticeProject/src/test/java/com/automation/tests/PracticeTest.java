package com.automation.tests;

import static org.testng.Assert.assertEquals;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.automation.base.Driver;
import com.automation.base.SeleniumTest;
import com.automation.pages.CreateAccountPage;
import com.automation.pages.MainPage;
import com.automation.pages.MyAccountPage;
import com.automation.pages.MyStorePage;
import com.automation.pages.OrderSummaryPage;
import com.automation.pages.PaymentSummaryPage;
import com.automation.pages.WomenMyStorePage;

public class PracticeTest extends SeleniumTest {

	MainPage mainPage;
	MyAccountPage myAccountPage;
	CreateAccountPage createAccountPage;
	WomenMyStorePage womenStorePage;
	MyStorePage myStorePage;
	OrderSummaryPage orderSummaryPage;
	PaymentSummaryPage paymentSummaryPage;

	@BeforeTest()
	public void setup() {
		mainPage = new MainPage();
		myAccountPage = new MyAccountPage();
		createAccountPage = new CreateAccountPage();
		myStorePage = new MyStorePage();
		womenStorePage = new WomenMyStorePage();
		orderSummaryPage= new OrderSummaryPage();
		paymentSummaryPage= new PaymentSummaryPage();
	}

	@Test()
	public void createAccountTest() {
		SeleniumTest.navigateToURL(Driver.prop.getProperty("appURL"));
		mainPage.clickSignInBtn();
		myAccountPage.enterEmail(Driver.prop.getProperty("custEmail"));
		myAccountPage.clickCreateAcc();
		createAccountPage.enterPersonalInfo(Driver.prop.getProperty("custFirstName"),
				Driver.prop.getProperty("custLastName"), Driver.prop.getProperty("accountPwd"));
		createAccountPage.enterCustAddress(Driver.prop.getProperty("custFirstName"),
				Driver.prop.getProperty("custLastName"), Driver.prop.getProperty("city"),
				Driver.prop.getProperty("state"));
		createAccountPage.clickRegister();
		
	}

	@Test(dependsOnMethods ="createAccountTest" )
	public void addProductIntoCart() throws InterruptedException {
		myStorePage.clickWomenTab();
		womenStorePage.addProduct();
		womenStorePage.addQtySizeColor(2,"S");
		womenStorePage.clickAddToCart();
		SeleniumTest.waitFor(5);
		assertEquals(womenStorePage.getTextcolorSize(), "Orange, S");
		assertEquals(womenStorePage.getTextQty(), "2");
		assertEquals(womenStorePage.getTextTotalPrice(), "$33.02");
		womenStorePage.clickProceedToCheckOut();		
	}
	
	@Test(dependsOnMethods="addProductIntoCart")
	public void verifyTodatPriceOrderSummaryPage() {
		assertEquals(orderSummaryPage.getTotalPrice(), "$35.02");
		
	}
	
	@Test(dependsOnMethods="verifyTodatPriceOrderSummaryPage")
	public void proceedToChkOut() {
		
		//Click checkout on summary page
		orderSummaryPage.clickOnProceedToCheckOut();
		//Click checkout on address page
		orderSummaryPage.clickOnProceedToCheckOut1();
		//select the check-box of Terms of service
		orderSummaryPage.clickServiceTerm();
		//Click on checkout payment
		orderSummaryPage.clickOnProceedToCheckOut2();
		
	}
	
	@Test(dependsOnMethods="proceedToChkOut")
	public void verifyTotalPriceOnPaymentSummaryPage() {
		//Verify the total price on payment summary page
		assertEquals(paymentSummaryPage.getTextTotalPrice(), "$35.02");
		//Click on payment option Pay By Bank Wire
		paymentSummaryPage.clickPayByBankWire();
		paymentSummaryPage.confirmOrder();
		
	}
	
	@Test(dependsOnMethods = "verifyTotalPriceOnPaymentSummaryPage")
	public void verifyOrderHistory() {
		//CLick on the customer link right corner of the page
		mainPage.clickViewMyCusAcc();
		//Click on order history
		myStorePage.clickOrderHistory();
		//Verify total price
		assertEquals(myStorePage.getTotalPrice(), "$35.02");
	}
	@AfterTest()
	public void endTest() {
	    SeleniumTest.closeBrowser();
	}
}
