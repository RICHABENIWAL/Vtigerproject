package com.comcast.crm.objectrepositoryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.comcast.crm.genricutility.webdriverutility.WebDriverUtility;

public class OrganisationPage {
      WebDriver driver;
      
      public OrganisationPage(WebDriver driver) {
    	  this.driver=driver;
    	  PageFactory.initElements(driver,this);
      }
	
      @FindBy(xpath = "//img[@title='Search in Organizations...']")
      private WebElement searchiconEdt;
      
      
	@FindBy(xpath="//img[@title='Create Organization...']")
	private WebElement createorgEdt;
	
	@FindBy(name="accountname")
	private WebElement orgnameEdt;
	
	@FindBy(name="ship_street")
	private WebElement shippingaddEdt;
	
	@FindBy(xpath="//input[@title='Save [Alt+S]']")
	private WebElement saveEdt;
	
	
	
	
	
	public WebElement getCreateOrg() {
		return createorgEdt;
	}
	
	public WebElement getOrgName() {
		return orgnameEdt;
	}
	
	public WebElement getShippingAddress() {
		return shippingaddEdt;
	}
	
	public WebElement getSaveBttn() {
		return saveEdt;
	}
	
	
	
	
	public void createNewOrganisation(String orgname, String shippingaddress) {
		createorgEdt.click();
		orgnameEdt.sendKeys(orgname);
		shippingaddEdt.sendKeys(shippingaddress);
		saveEdt.click();
	}
	
	public void navigateToSearchOrg() {
  		searchiconEdt.click();
  	}
	
	
	
	
	
	
	
}
