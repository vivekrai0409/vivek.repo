package com.automation.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.automation.base.CONSTANT;
import com.automation.base.Driver;
import com.automation.base.SeleniumTest;

public class CreateAccountPage {

	@FindBy(how=How.ID,using="id_gender1")
	private WebElement titleMr;
	
	@FindBy(how=How.ID,using="id_gender2")
	private WebElement titleMrs;
	
	@FindBy(how=How.ID,using="customer_firstname")
	private WebElement firstName;
	
	@FindBy(how=How.ID,using="customer_lastname")
	private WebElement lastName;
	
	@FindBy(how=How.ID,using="email")
	private WebElement email;
	
	@FindBy(how=How.ID,using="passwd")
	private WebElement password;
	
	@FindBy(how=How.XPATH,using="//select[@id='days']")
	private WebElement dobDropdownDays;
	
	@FindBy(how=How.XPATH,using="//select[@id='months']")
	private WebElement dobDropdownMonth;
	
	@FindBy(how=How.XPATH,using="//select[@id='years']")
	private WebElement dobDropdownYear;
	
	@FindBy(how=How.ID,using="firstname")
	private WebElement addressFirstName;
	
	@FindBy(how=How.ID,using="lastname")
	private WebElement addressLastName;
	
	@FindBy(how=How.ID,using="address1")
	private WebElement addressLine1;
	
	@FindBy(how=How.ID,using="address2")
	private WebElement addressLine2;
	
	@FindBy(how=How.ID,using="city")
	private WebElement addressCity;
	
	@FindBy(how=How.XPATH,using="//select[@id='id_state']")
	private WebElement addressState;
	
	@FindBy(how=How.ID,using="postcode")
	private WebElement addressPostCode;
	
	@FindBy(how=How.XPATH,using="//select[@id='id_country']")
	private WebElement addressCountry;
	
	@FindBy(how=How.ID,using="phone")
	private WebElement homePhone;
	
	@FindBy(how=How.ID,using="phone_mobile")
	private WebElement mobilePhone;
	
	@FindBy(how=How.ID,using="alias")
	private WebElement aliasAddress;
	
	@FindBy(how=How.ID,using="submitAccount")
	private WebElement registerBtn;
	
	public CreateAccountPage() {
		PageFactory.initElements(Driver.getIntsnace().getDriver(), this);
	}
	
	
	/*
	 * Select the title of the customer as Mr
	 */
	
	public void selectTitleMr() {
		SeleniumTest.click(titleMr);
	}
	
	/*
	 * Select the title of the customer as Mrs
	 */
	
	public void selectTitleMrs() {
		SeleniumTest.click(titleMrs);
	}
	
	/*
	 * Enter customer first name
	 */
	
	public void enterFirstName(String nameFirst) {
		SeleniumTest.enterText(firstName, nameFirst);
	}
	
	/*
	 * Enter customer last name
	 */
	public void enterLastName(String nameLast) {
		SeleniumTest.enterText(lastName, nameLast);
	}
	
	/*
	 * Enter password
	 */
	public void enterPwd(String pwd) {
		SeleniumTest.enterText(password, pwd);
	}
	
	/*
	 * Select the day , month and year from the DOB dropdown
	 */
	public void selectDay(int day) {
		SeleniumTest.selectByValue(dobDropdownDays,String.valueOf(day));
	}
	
	public void selectMonth(String month) {
		SeleniumTest.selectByText(dobDropdownMonth,month);
	}
	
	public void selectYear(int year) {
		SeleniumTest.selectByValue(dobDropdownYear,String.valueOf(year));
	}
	
	/*
	 * Enter the customer full address
	 */
	public void enterAddFirstName(String firstName) {
		SeleniumTest.clearAndEnterText(addressFirstName, firstName);
	}
	
	public void enterAddLastName(String lastName) {
		SeleniumTest.clearAndEnterText(addressLastName, lastName);
	}
	
	public void enterAddressLine1(String address) {
		SeleniumTest.enterText(addressLine1, address);
	}
	
	public void enterAddressLine2(String address) {
		SeleniumTest.enterText(addressLine2, address);
	}
	
	public void enterCity(String city) {
		SeleniumTest.enterText(addressCity, city);
	}
	
	public void selectState(String state) {
		SeleniumTest.selectByText(addressState, state);
	}
	
	public void enterPostalCode(int zipCode) {
		SeleniumTest.enterText(addressPostCode, String.valueOf(zipCode));
	}
	
	public void selectCountry(String country) {
		SeleniumTest.selectByText(addressCountry, country);
	}
	
	public void enterMobilePhone(String mobileNum) {
		SeleniumTest.enterText(mobilePhone,mobileNum);
	}
	
	public void enterAliasAddress(String aliasAdd) {
		SeleniumTest.enterText(aliasAddress, aliasAdd);
	}
	
	/*
	 * Click on register button 
	 */
	public void clickRegister() {
		SeleniumTest.click(registerBtn);
	}
	
	/*
	 * Enter the personal info about the customer
	 */
	public void enterPersonalInfo(String firstName,String lastName,String pwd) {
		selectTitleMr();
		enterFirstName(firstName);
		enterLastName(lastName);
		enterPwd(pwd);
		selectDay(CONSTANT.dayDOB);
		selectMonth(CONSTANT.monthDOB);
		selectYear(CONSTANT.yearDOB);
	}
	
	/*
	 * Enter the customer address
	 */
	public void enterCustAddress(String custFirstName,String custLastName,String city,String state) {
		enterAddFirstName(custFirstName);
		enterAddLastName(custLastName);
		enterAddressLine1(CONSTANT.addressLine1);
		enterCity(city);
		selectState(state);
		enterPostalCode(CONSTANT.zipCode);
		enterMobilePhone(CONSTANT.mobileNum);
	}
}
