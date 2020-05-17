package com.automation.base;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SeleniumTest {
	
	static EventFiringWebDriver driver = new EventFiringWebDriver(Driver.getIntsnace().getDriver());
	static WebDriverWait wait = new WebDriverWait(driver, 30);
	static Select sel;
	static Actions act=new Actions(driver);
	/*
	 * Navigate to a given URL
	 */
	
	public static void navigateToURL(String url) {
		driver.get(url);
	}

	/*
	 * Close browser instance
	 */
	public static void closeBrowser() {
		driver.close();
	}
	
	/*
	 * To click on a webelement
	 */
	public static void click(WebElement element) {
      wait.until(ExpectedConditions.visibilityOf(element));
      element.click();
	}
	
	/*
	 * To click on a webelement using javascript
	 */
	public static void clickByJavaScript(WebElement element) {
		driver.executeScript("arguments[0].click();", element);
	}

	/*
	 * To enter text in an input box
	 */
	public static void enterText(WebElement element,String str) {
		wait.until(ExpectedConditions.visibilityOf(element));
		element.sendKeys(str);
	}
	
	/*
	 * Select value from a drop-down using text
	 */
	
	public static void selectByText(WebElement element,String visibleText) {
		sel= new Select(element);
		sel.selectByVisibleText(visibleText);
	}
	
	/*
	 *  Select value from a drop-down using value
	 */
	
	public static void selectByValue(WebElement element,String value) {
		sel= new Select(element);
		sel.selectByValue(value);
	}
	
	/*
	 * Move mouse with the help of Actions class
	 */
	public static void moveMouseToElement(WebElement element) {
		act.moveToElement(element).build().perform();
	}
	/*
	 * Wait until element is invisible
	 */
	
	public static void waitUntilElementInvisible(WebElement element) {		
		wait.until(ExpectedConditions.invisibilityOf(element));
	}
	
	/*
	 * Wait for the given time
	 */
	
	public static void waitFor(int time) throws InterruptedException {
		Thread.sleep(time*1000);
	}
	
	/*
	 * Clear text before entering text
	 */
	
	public static void clearAndEnterText(WebElement element, String text) {
		element.clear();
		element.sendKeys(text);
	}
	
	/*
	 * Get text from the webelement
	 */
	public static String getText(WebElement element) {
		return element.getText();
	}
	
	/*
	 * Switch to a frame
	 * 
	 */
	public static void switchToFrame(WebElement frame) {
		driver.switchTo().frame(frame);
	
	}
	
	/*
	 * Switch to default content
	 */
	public static void switchToDefault() {
		driver.switchTo().defaultContent();
	}
	
}
