package com.automation.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.automation.base.Driver;
import com.automation.base.SeleniumTest;

public class WomenMyStorePage {

	@FindBy(how=How.XPATH,using="//img[@title='Faded Short Sleeve T-shirts']")
	private WebElement shortSleeve;	

	@FindBy(how=How.XPATH,using="//span[text()='Quick view']")
	private WebElement quickView;
	
	@FindBy(how=How.XPATH,using="//input[@name='qty' and @id='quantity_wanted']")
	private WebElement quantity;
	
	@FindBy(how=How.XPATH,using="//select[@id='group_1']")
	private WebElement size;
	
	@FindBy(how=How.XPATH,using="//a[@title='Orange']")
	private WebElement colorOrange;
	
	@FindBy(how=How.XPATH,using="//button/span[text()='Add to cart']")
	private WebElement addToCart;
	
	@FindBy(how=How.ID,using="layer_cart_product_attributes")
	private WebElement colorSizeText;
	
	@FindBy(how=How.ID,using="layer_cart_product_quantity")
	private WebElement qtyText;
	
	@FindBy(how=How.ID,using="layer_cart_product_price")
	private WebElement totalPrice;
	
	@FindBy(how=How.XPATH,using="//a[@title='Proceed to checkout']")
	private WebElement processToChkoutBtn;
	
	@FindBy(how=How.XPATH,using="//iframe[@class='fancybox-iframe']")
	private WebElement frameElement;
	
	OrderSummaryPage orderSummaryPage;
	
	public WomenMyStorePage() {
		PageFactory.initElements(Driver.getIntsnace().getDriver(),this);
	}
	
	/*
	 * Add product
	 */
	public void addProduct() throws InterruptedException {
		SeleniumTest.moveMouseToElement(shortSleeve);
		SeleniumTest.click(quickView);
		SeleniumTest.waitFor(10);
	}
	
	/*
	 * Add the product quantity
	 */
	public void addProductQuantity(int qty) {
		SeleniumTest.switchToFrame(frameElement);
		SeleniumTest.clearAndEnterText(quantity, String.valueOf(qty));
	}
	
	/*
	 * Select the size
	 */
	public void selectSeize(String Size) {
		SeleniumTest.selectByText(size, Size);
	}
	
	/*
	 * Select the orange color
	 */
	public void selectOrangeColor() {
		SeleniumTest.click(colorOrange);
	}
	/*
	 * Click on add to car button
	 */
	public void clickAddToCart() throws InterruptedException {
		SeleniumTest.click(addToCart);
		SeleniumTest.waitFor(5);
	}
	
	/*
	 * Add the qty , color and add the product into cart
	 */
	
	public void addQtySizeColor(int qty,String size) {
		//SeleniumTest.switchToFrame(frameElement);
		addProductQuantity(qty);
		selectSeize(size);
		selectOrangeColor();
		
	}
	/*
	 * Get the text for color and Size
	 */
	
	public String getTextcolorSize() {
		return SeleniumTest.getText(colorSizeText);
	}
	
	/*
	 * Get text for Qty
	 */
	public String getTextQty() {
		return SeleniumTest.getText(qtyText);
	}
	
	/*
	 * Get total price text
	 */
	public String getTextTotalPrice() {
		return SeleniumTest.getText(totalPrice);
	}
	
	/*
	 * Click on proceed to checkout
	 */
	public OrderSummaryPage clickProceedToCheckOut() {
		SeleniumTest.click(processToChkoutBtn);
		return orderSummaryPage;
	}
	
}
