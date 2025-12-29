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

import com.comcast.crm.genric.fileutility.ExcelUtility;
import com.comcast.crm.genric.fileutility.FileUtility;
import com.comcast.crm.genricutility.webdriverutility.WebDriverUtility;

public class CreateContactWithOrganisation {

	@Test
	public void loginTest() throws Throwable {
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

		FileUtility fu = new FileUtility();
		String url =	fu.getDataFromProperties("url");
		String un =fu.getDataFromProperties("un");
		String pw = fu.getDataFromProperties("pw");


		// generated random number
		Random random = new Random();
		int rannumber = random.nextInt();

		// get data from excel
		ExcelUtility excel = new ExcelUtility();
		String orgname = excel.getDataFromExcelFile("sheet3", 1, 2)+ rannumber;;
		String lastname = excel.getDataFromExcelFile("sheet3", 10, 3);
		
	   

		
		// 1.log in
		driver.get(url);
		driver.findElement(By.name("user_name")).sendKeys(un);
		driver.findElement(By.name("user_password")).sendKeys(pw);
		driver.findElement(By.id("submitButton")).click();

		// 2.navigate to organisation
		driver.findElement(By.linkText("Organizations")).click();

		//3. click on create organisation
		driver.findElement(By.xpath("//img[@title='Create Organization...']")).click();

		//4.enter all the details and create an organisation
		WebElement accountname = driver.findElement(By.name("accountname"));
		accountname.sendKeys(orgname);
		driver.findElement(By.name("button")).click();
		
		
		Thread.sleep(2000);
        //create contact
		driver.findElement(By.linkText("Contacts")).click();
		driver.findElement(By.xpath("//img[@title='Create Contact...']")).click();
		driver.findElement(By.name("lastname")).sendKeys(lastname);
		
	
		
		driver.findElement(By.xpath("//input[@name='account_name']/following-sibling::img")).click();
		
		//switch to child window
		WebDriverUtility weblib = new WebDriverUtility();
		weblib.switchTabOnURL(driver, "module=Accounts");
		
		
	
		
		driver.findElement(By.id("search_txt")).sendKeys(orgname);
		Thread.sleep(2000);
		driver.findElement(By.name("search")).click();
		driver.findElement(By.xpath("//a[text()='"+orgname+"']")).click();
		

		//switch to parent window
		weblib.switchTabOnURL(driver,"Contacts&action");
		
		
	
		
		
		// verify header msg expected result
		
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
          
		Thread.sleep(2000);
		  String headerinfo = driver.findElement(By.cssSelector("span[class='dvHeaderText']")).getText();
	
		  if(headerinfo.contains(lastname)) {
		  System.out.println(lastname+"header verified == pass"); 
		  }else {
		  System.out.println(lastname+"header verified == failed"); }
		  
			// verify header orgname info expected result
			
		  String actualorgname = driver.findElement(By.id("mouseArea_Organization Name")).getText();
		  if(actualorgname.trim().equals(orgname)) {
			  System.out.println(actualorgname +"organisation is created");
			  }else { System.out.println(actualorgname +"organisation is not created"); 
			  }
		 
		driver.quit();
		
		
	}
}
