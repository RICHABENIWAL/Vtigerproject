package com.comcast.crm.objectrepositoryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrganisationInfoPage {

	WebDriver driver;
	public OrganisationInfoPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
   @FindBy(xpath = "//td[@class='tabSelected']/a[text()='Organizations']")
   private WebElement organisationEdt;
   
   public WebElement getOrganisation() {
	   return organisationEdt;
   }
   
   public void navigateToOrganisation() {
	   organisationEdt.click();
   }

	

	
}
