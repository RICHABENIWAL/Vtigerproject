package com.comcast.crm.contacttest;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import com.comcast.crm.genric.fileutility.ExcelUtility;
import com.comcast.crm.genric.fileutility.FileUtility;
import com.comcast.crm.genricutility.webdriverutility.JavaUtility;

public class CreateContactWithSupportDate {
	

	@Test
	public void loginTest() throws Throwable {
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        
	    FileUtility fu = new FileUtility();
		String url = fu.getDataFromProperties("url");
		String un =fu.getDataFromProperties("un");
		String pw =fu.getDataFromProperties("pw");
		
		// generated random number
		JavaUtility jlib = new JavaUtility();
		
				

		// get data from excel
		ExcelUtility elib = new ExcelUtility();
		String lastname = elib.getDataFromExcelFile("sheet3", 10, 3)+ jlib.getRandomNumber();
				
		
		// 1.log in
				driver.get(url);
				driver.findElement(By.name("user_name")).sendKeys(un);
				driver.findElement(By.name("user_password")).sendKeys(pw);
				driver.findElement(By.id("submitButton")).click();
				
				
				
		//2. create contacts with support date
				
				driver.findElement(By.linkText("Contacts")).click();
				driver.findElement(By.xpath("//img[@title='Create Contact...']")).click();
				driver.findElement(By.name("lastname")).sendKeys(lastname);
				
				
				String startdate = jlib.getSystemDateyyyymmdd();
				String enddate = jlib.getRequiredDate(30);
			
				
				driver.findElement(By.name("support_start_date")).sendKeys(startdate);
				
				
				driver.findElement(By.name("support_end_date")).sendKeys(enddate);
				driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
				
				//verify page header
				String headerverify = driver.findElement(By.className("dvHeaderText")).getText();				
				if(headerverify.contains(lastname)) {
					System.out.println("contact verified");
				}else {
					System.out.println("not verified");
				}
				
				//verify last name
				String actlastname = driver.findElement(By.id("dtlview_Last Name")).getText();
				if(actlastname.equals(lastname)) {
					System.out.println("last name verified");
				}else {
					System.out.println("last name not verified");
				}
				
				
				
				driver.quit();
		
	}
}
