package com.comcast.crm.contacttest;
import org.testng.annotations.Test;
import com.comcast.crm.basetest.BaseClass;
import com.comcast.crm.genricutility.webdriverutility.WebDriverUtility;
import com.comcast.crm.objectrepositoryutility.ContactInformationPage;
import com.comcast.crm.objectrepositoryutility.CreateContactPage;
import com.comcast.crm.objectrepositoryutility.HomePage;
import com.comcast.crm.objectrepositoryutility.OrganisationPage;
import com.comcast.crm.objectrepositoryutility.SearchOrganisationsPage;

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
		SearchOrganisationsPage searchorg = new SearchOrganisationsPage(driver);
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

