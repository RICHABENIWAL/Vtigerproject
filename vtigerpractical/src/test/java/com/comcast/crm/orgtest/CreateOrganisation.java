package com.comcast.crm.orgtest;


import java.time.Duration;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.comcast.crm.basetest.BaseClass;
import com.comcast.crm.genric.databaseutility.DatabaseUtility;
import com.comcast.crm.genric.fileutility.ExcelUtility;
import com.comcast.crm.genric.fileutility.FileUtility;
import com.comcast.crm.genricutility.webdriverutility.JavaUtility;
import com.comcast.crm.genricutility.webdriverutility.WebDriverUtility;
import com.comcast.crm.objectrepositoryutility.HomePage;
import com.comcast.crm.objectrepositoryutility.LoginPage;
import com.comcast.crm.objectrepositoryutility.OrganisationPage;
import com.mysql.cj.conf.DatabaseUrlContainer;

public class CreateOrganisation {

	
	@Test(groups="regression")
	public void loginTest() throws Throwable {
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

		
		DatabaseUtility du = new DatabaseUtility();
		du.getConnection("jdbc:my sql://localhost 3306/company_db", "root", "root");
		du.executeSelectQuery("select * from employee");
		
		
		FileUtility fu = new FileUtility();
		String url = fu.getDataFromProperties("url");
		String un =fu.getDataFromProperties("un");
		String pw =fu.getDataFromProperties("pw");

		// generated random number
		JavaUtility jlib = new JavaUtility();
		

		// get data from excel
		ExcelUtility elib = new ExcelUtility();
		String orgname = elib.getDataFromExcelFile("sheet3", 1, 2)+ jlib.getRandomNumber();
		
		// 1.log in
		driver.get(url);
		LoginPage lp= new LoginPage(driver);	
		lp.login(pw, pw);
		
		


		// 2.navigate to organisation
		HomePage hp = new HomePage(driver);
		hp.navigateToOrganisation();
		OrganisationPage orgpage = new OrganisationPage(driver);
		orgpage.createNewOrganisation(orgname, "New York City");
		
		
		// verify header msg expected result

		  String headerinfo = driver.findElement(By.cssSelector("span[class='dvHeaderText']")).getText();
	
		  if(headerinfo.contains(orgname)) {
		 
		  Reporter.log(orgname+"header verified == pass");
		  }else {
			  Reporter.log(orgname+"header verified == failed");
		  }
		 
		 

		// verify header orgname info expected result
		
		  String actualorgname = driver.findElement(By.id("dtlview_Organization Name")).getText();
		  SoftAssert sf = new SoftAssert();
		  sf.assertEquals(actualorgname, orgname);
		  sf.assertAll();
		 
			/*
			 * if(actualorgname.equals(orgname)) { System.out.println(actualorgname
			 * +"organisation is created"); }else { System.out.println(actualorgname
			 * +"organisation is not created"); }
			 */
		 

		// 5.log out
		
		 hp.signOut();
		  
		 driver.quit();
		 

	}
}
