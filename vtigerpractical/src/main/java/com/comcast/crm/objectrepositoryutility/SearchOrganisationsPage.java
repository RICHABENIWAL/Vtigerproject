package com.comcast.crm.objectrepositoryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.comcast.crm.genricutility.webdriverutility.WebDriverUtility;

public class SearchOrganisationsPage {
	
	WebDriver driver;
	public SearchOrganisationsPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	
	@FindBy(name="search_text")
	private WebElement searchforEdt;
	
	public WebElement getSearchfor() {
		return searchforEdt;
	}
	
	
	@FindBy(id="bas_searchfield")
	private WebElement searchinfield;
	
	public WebElement getSearchin() {
		return searchinfield;
	}
	
	
	@FindBy(name="submit")
	private WebElement searchNowButtonEdt;

	public WebElement getSearchnowbutton() {
		return searchNowButtonEdt;
	}
	
	
	
	
	
	public void searchOrgnaisation(String orgname, String searchcolumn) {
		WebDriverUtility wlib = new WebDriverUtility();
		searchforEdt.sendKeys(orgname);
		wlib.selectOnText(searchinfield, searchcolumn);
		searchinfield.click();
		searchNowButtonEdt.click();
		
		
	}
	
   

}
