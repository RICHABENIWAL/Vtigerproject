package com.comcast.crm.objectrepositoryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

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
	
	
	

}
