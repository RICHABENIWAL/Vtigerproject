package com.comcast.crm.orgtest;


import java.time.Duration;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import com.comcast.crm.genric.fileutility.ExcelUtility;
import com.comcast.crm.genric.fileutility.FileUtility;

public class CreateOrgWithIndustery {
	
	

	@Test
	public void loginTest() throws Throwable {
		WebDriver driver= new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));


		FileUtility fu = new FileUtility();
		String url = fu.getDataFromProperties("url");
		String un =fu.getDataFromProperties("un");
		String pw =fu.getDataFromProperties("pw");

		// generated random number
		Random random = new Random();
		int rannumber = random.nextInt();

		// get data from excel
		ExcelUtility elib = new ExcelUtility();
		String orgname =elib.getDataFromExcelFile("sheet3", 1, 2)+ rannumber;
		String industry =elib.getDataFromExcelFile("sheet3", 4, 3);
		String type =elib.getDataFromExcelFile("sheet3", 4, 4);
		

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
		
		System.out.println("till here");
		
		WebElement indusdrop = driver.findElement(By.name("industry"));
		Select sc = new Select(indusdrop);
		sc.selectByVisibleText(industry);
		
		WebElement typedrop = driver.findElement(By.name("accounttype"));
		Select sc1 = new Select(typedrop);
		sc1.selectByVisibleText(type);
		
		driver.findElement(By.name("button")).click();
		System.out.println("till here2");
		
		
		
	String actualindus = driver.findElement(By.id("dtlview_Industry")).getText();
	if(actualindus.equals(industry)) {
		System.out.println("verified");
	}else {
		System.out.println("not verified");
	}
	
	String actualtype = driver.findElement(By.id("dtlview_Type")).getText();
	if(actualtype.equals(type)) {
		System.out.println("verified");
	}else {
		System.out.println("not verified");
	}

		
		 
		 
         
		 

		
		  Thread.sleep(2000); driver.findElement(By.xpath(
		  "//img[contains(@src,'themes/softed/images/user.PNG')]")).click();
		  
		  Thread.sleep(2000); driver.findElement(By.linkText("Sign Out")).click();
		 

	}

}
