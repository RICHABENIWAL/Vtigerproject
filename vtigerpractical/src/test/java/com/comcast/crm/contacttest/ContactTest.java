package com.comcast.crm.contacttest;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import com.comcast.crm.basetest.BaseClass;
import com.comcast.crm.genric.fileutility.ExcelUtility;
import com.comcast.crm.genric.fileutility.FileUtility;
import com.comcast.crm.genricutility.webdriverutility.JavaUtility;
import com.comcast.crm.genricutility.webdriverutility.WebDriverUtility;
import com.comcast.crm.objectrepositoryutility.ContactEditPage;
import com.comcast.crm.objectrepositoryutility.ContactInformationPage;
import com.comcast.crm.objectrepositoryutility.CreateContactPage;
import com.comcast.crm.objectrepositoryutility.HomePage;
import com.comcast.crm.objectrepositoryutility.LoginPage;

public class ContactTest extends BaseClass{

	// dependsOnMethods is use to create dependencies b/w 2 tests and set the order
	// of execution
	// if 1test case got failed then 2nd test will not get execute and get skipped
	
	WebDriverUtility wlib = new WebDriverUtility();

	@Test(groups="smoke")
	public void createContactTest() throws IOException, Throwable {
		
		ExcelUtility elib = new ExcelUtility();
		JavaUtility jlib = new JavaUtility();
		String lastname = elib.getDataFromExcelFile("contact", 1, 2) + jlib.getRandomNumber();
		CreateContactPage contactpage = new CreateContactPage(driver);
		contactpage.createContact(lastname);
		ContactInformationPage contactinfo = new ContactInformationPage(driver);
		contactinfo.verifyHeader(lastname);
	}

	@Test(enabled = false)
	public void editContactTest() throws IOException, Throwable {
		ContactInformationPage contactinfo = new ContactInformationPage(driver);
		contactinfo.getEditButton().click();
		ExcelUtility elib = new ExcelUtility();
		JavaUtility jlib = new JavaUtility();
		String lastname = elib.getDataFromExcelFile("contact", 1, 2) + jlib.getRandomNumber();
		ContactEditPage contactedit = new ContactEditPage(driver);
		contactedit.editContact(lastname);

	}

	@Test(enabled = false)
	public void deleteContactTest() {
		ContactInformationPage contactinfo = new ContactInformationPage(driver);
		contactinfo.getDeletebutton().click();
		wlib.switchToAlertAccept(driver);
	}

	@Test(enabled = false)
	public void createContact() throws IOException, Throwable {
		
		System.out.println("done");
	}
	
	
}
