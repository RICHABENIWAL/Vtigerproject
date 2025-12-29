package com.comcast.crm.objectrepositoryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateNewOrganisationPage {

	WebDriver driver;
	public CreateNewOrganisationPage(WebDriver driver){
		this.driver= driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//img[@title='Create Organization...']")
	private WebElement createorgEdt;
	
	@FindBy(name="accountname")
	private WebElement orgnameEdt;
	
	@FindBy(name="ship_street")
	private WebElement shipaddEdt;
	
	@FindBy(xpath="//input[@title='Save [Alt+S]']")
	private WebElement saveEdt;
	
	
	
	
	public WebElement getCreateorg() {
		return createorgEdt;
	}
	
	public WebElement getOrgName() {
		return orgnameEdt;
	}
	
	public WebElement getShipAdd() {
		return shipaddEdt;
	}
	
	public WebElement getSaveButton() {
		return saveEdt;
	}
	
	public void createNewOrganisation(String organisationname, String shippingaddres) {
		createorgEdt.click();
		orgnameEdt.sendKeys(organisationname);
		shipaddEdt.sendKeys(shippingaddres);
		saveEdt.click();
	}
	
	
}
