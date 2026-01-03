package com.comcast.crm.objectrepositoryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.comcast.crm.genricutility.webdriverutility.WebDriverUtility;

public class CreateContactPage {
	
	WebDriver driver;
	
	public CreateContactPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(linkText="Contacts")
	private WebElement contactEdt;
	
	@FindBy(xpath = "//img[@title='Create Contact...']")
	private WebElement createcontactEdt;
	
	@FindBy(name="lastname")
	private WebElement lastnameEdt;
	
	@FindBy(xpath = "//input[@title='Save [Alt+S]']")
	private WebElement savebuttonEdt;
	
	@FindBy(xpath = "//input[@name='account_name']/following-sibling::img")
	private WebElement selectorgEdt;
	
	public WebElement getSelectOrg() {
		return selectorgEdt;
	}
	
	
	public WebElement getContactEdt() {
		return contactEdt;	
	}
	
	public WebElement getCreateContact() {
		return createcontactEdt;
	}
	
	public WebElement getLastName() {
		return lastnameEdt;
	}
	
	public WebElement getSaveButton() {
		return savebuttonEdt;
	}
	
	public void createContact(String lastname) {
		contactEdt.click();
		createcontactEdt.click();
		lastnameEdt.sendKeys(lastname);
		savebuttonEdt.click();
		
	}
	
	public void createContactWithOrganisation(String orgname, String lastname) throws InterruptedException {
		WebDriverUtility wlib = new WebDriverUtility();
		wlib.waitForPageToLoad(driver);
		contactEdt.click();
		createcontactEdt.click();
		lastnameEdt.sendKeys(lastname);
		selectorgEdt.click();
	}
	
	
	

}
