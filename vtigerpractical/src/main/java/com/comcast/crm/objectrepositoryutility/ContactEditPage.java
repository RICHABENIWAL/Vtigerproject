package com.comcast.crm.objectrepositoryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactEditPage {
	
	WebDriver driver;
	
	public ContactEditPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(name = "lastname")
	private WebElement lastnameEdt;
	
	@FindBy(xpath = "//input[@title='Save [Alt+S]']")
	private WebElement savebuttonEdt;

	public WebElement getLastName() {
		return lastnameEdt;
	}
	
	public WebElement getSaveButton() {
		return  savebuttonEdt;
	}
	
	public void editContact(String lastname) {
		
		lastnameEdt.sendKeys(lastname);
		savebuttonEdt.click();
		
	}
	
	
	
	
}
