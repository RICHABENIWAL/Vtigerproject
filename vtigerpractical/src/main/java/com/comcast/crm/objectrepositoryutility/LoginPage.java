package com.comcast.crm.objectrepositoryutility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.comcast.crm.genricutility.webdriverutility.WebDriverUtility;

public class LoginPage extends WebDriverUtility {
	WebDriver driver;
	
	/*
	 * 1. pom class creation 
	 * 2. object identification 
	 * 3. object initialization
	 * 4. object encapsulation 
	 * 5. object utilization
	 */

	public LoginPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	//single elements
	@FindBy(name="user_name")
	public WebElement usernameEdt;
	
	@FindBy(name="user_password")
	public WebElement passwordEdt;
	
	@FindBy(id="submitButton")
	public WebElement loginbuttonEdt;
	
	

	//4. object encapsulation 
	
	public WebElement getUsernameEdt() {
		return usernameEdt;
	}

	public WebElement getPasswordEdt() {
		return passwordEdt;
	}

	public WebElement getloginbuttonEdt() {
		return loginbuttonEdt;
	}
	
	
	//business library method //multiple elements
	public void login(String username, String password) {
		waitForPageToLoad(driver);
		usernameEdt.sendKeys(username);
		passwordEdt.sendKeys(password);
		loginbuttonEdt.click();
	}
	
	
	
	
	

}
