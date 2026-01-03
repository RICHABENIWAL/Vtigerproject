package com.comcast.crm.objectrepositoryutility;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.comcast.crm.genricutility.webdriverutility.WebDriverUtility;

public class SearchOrganisationsPage {
	
	WebDriver driver;

	public SearchOrganisationsPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(name = "search_text")
	private WebElement searchorgtextEdt;

	@FindBy(name = "search")
	private WebElement searchnowEdt;

	public WebElement getSearchNow() {
	    return searchnowEdt;
	}

	public WebElement getsearchorgtext() {
		return searchorgtextEdt;
	}
	
	public void searchOrganisationInChild(String orgname) {
		searchorgtextEdt.sendKeys(orgname);
		searchnowEdt.click();
		driver.findElement(By.xpath("//a[text()='" + orgname + "']")).click();
	}

	
   

}
