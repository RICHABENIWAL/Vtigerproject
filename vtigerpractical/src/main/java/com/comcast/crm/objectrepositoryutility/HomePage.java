package com.comcast.crm.objectrepositoryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
    WebDriver driver;
    
    public HomePage(WebDriver driver) {
    	this.driver=driver;
    	PageFactory.initElements(driver, this);
    }
	
	
	@FindBy(linkText = "Organizations")
	private WebElement orglink;
	
	@FindBy(linkText = "Contacts")
	private WebElement contactslink;
	
	@FindBy(linkText = "More")
	private WebElement morelink;
	
	@FindBy(linkText = "Campaigns")
	private WebElement campaignslink;
	
	@FindBy(xpath="//img[contains(@src,'themes/softed/images/user.PNG')]")
	private WebElement signoutimglink;
	
	@FindBy(linkText = "Sign Out")
	private WebElement SignOutlink;
	
	
	public WebElement getOrgLink1() {
		return orglink;
	}
	
	public WebElement getcontactLink() {
		return contactslink;
	}
	
	public WebElement getMorelink() {
		return morelink;
	}
	
	public WebElement getCampaigns() {
		return campaignslink;
	}
	
	public void navigateToCampaign() {
		Actions ac = new Actions(driver);
		ac.moveToElement(morelink);
		campaignslink.click();
		
	}
	
	public void navigateToOrganisation() {
	   orglink.click();
		
	}
	
	public void navigateToContact() {
		contactslink.click();
	}
	
	public void signOut() {
		signoutimglink.click();
		SignOutlink.click();
	}
	
	
	
}
