package com.comcast.crm.objectrepositoryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactInformationPage {
	WebDriver driver;
	
	public ContactInformationPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	
	@FindBy(css = "span[class='dvHeaderText']")
	private WebElement headerEdt;
	
	
	@FindBy(xpath = "//input[@title='Edit [Alt+E]']")
	private WebElement editbuttonEdt;

	@FindAll({@FindBy(xpath = "//input[@title='Delete [Alt+D]']"),@FindBy(name="Delete")})
	private WebElement deletebuttonEdt;
	
	public WebElement getEditButton() {
		return editbuttonEdt;
	}
	
	public WebElement getDeletebutton() {
		return deletebuttonEdt;
	}
	
	public WebElement getHeader() {
		return headerEdt;
	}
	
	
	
	public void verifyHeader(String lastname) {
		String header = headerEdt.getText();
		if(header.contains("hf")) {
			System.out.println("verified");
		}else {
			System.out.println("not verified");
		}
	}
	
	
	
	}
	
	

	

