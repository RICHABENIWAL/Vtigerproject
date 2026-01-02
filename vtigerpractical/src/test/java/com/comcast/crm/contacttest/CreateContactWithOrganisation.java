package com.comcast.crm.contacttest;


import java.time.Duration;
import java.util.Iterator;
import java.util.Random;
import java.util.Set;

import org.jspecify.annotations.Nullable;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import com.comcast.crm.basetest.BaseClass;
import com.comcast.crm.genric.fileutility.ExcelUtility;
import com.comcast.crm.genric.fileutility.FileUtility;
import com.comcast.crm.genricutility.webdriverutility.WebDriverUtility;
import com.comcast.crm.objectrepositoryutility.ContactInformationPage;
import com.comcast.crm.objectrepositoryutility.CreateContactPage;
import com.comcast.crm.objectrepositoryutility.HomePage;
import com.comcast.crm.objectrepositoryutility.OrganisationPage;
import com.comcast.crm.objectrepositoryutility.SearchOrganisationPage;

public class CreateContactWithOrganisation extends BaseClass {

	@Test(groups="regression")
	public void loginTest() throws Throwable {

		String orgname = elib.getDataFromExcelFile("sheet3", 1, 2) + jlib.getRandomNumber();
		String lastname = elib.getDataFromExcelFile("sheet3", 10, 3);
		HomePage homepage = new HomePage(driver);
		homepage.navigateToOrganisation();
		OrganisationPage orgpage = new OrganisationPage(driver);
		orgpage.createNewOrganisation(orgname, lastname);

		Thread.sleep(2000);
		// create contact
		homepage.navigateToContact();
		CreateContactPage contactpage = new CreateContactPage(driver);
		contactpage.createContactWithOrganisation(orgname, lastname);

		// switch to child window
		WebDriverUtility weblib = new WebDriverUtility();
		weblib.switchTabOnURL(driver, "module=Accounts");
		SearchOrganisationPage searchorg = new SearchOrganisationPage(driver);
		searchorg.searchOrganisationInChild(orgname);

		// switch to parent window
		weblib.switchTabOnURL(driver, "Contacts&action");

		// verify header msg expected result
		contactpage.getSaveButton().click();
		ContactInformationPage contactinfo = new ContactInformationPage(driver);
		contactinfo.verifyHeader(lastname);

		// verify header orgname info expected result
		contactinfo.verifyOrgname(orgname);

	}
	
		
	}
}
