package com.comcast.crm.basetest;

import java.io.IOException;
import java.sql.SQLException;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import com.comcast.crm.genric.databaseutility.DatabaseUtility;
import com.comcast.crm.genric.fileutility.ExcelUtility;
import com.comcast.crm.genric.fileutility.FileUtility;
import com.comcast.crm.genricutility.webdriverutility.JavaUtility;
import com.comcast.crm.genricutility.webdriverutility.UtilityClassObject;
import com.comcast.crm.objectrepositoryutility.HomePage;
import com.comcast.crm.objectrepositoryutility.LoginPage;

public class BaseClass {

	//create  object
	public DatabaseUtility dblib = new DatabaseUtility();
	public FileUtility flib = new FileUtility();
	public ExcelUtility elib = new ExcelUtility();
	public JavaUtility jlib = new JavaUtility();
	public WebDriver driver ;
	public static WebDriver sdriver;

	@BeforeSuite(groups= {"smoke","regression"})
	public void configBS() throws SQLException {
		
		dblib.getConnection();
		// CONNECT TO DB/REPORT CONFIG
	}

	@BeforeClass(groups= {"smoke","regression"})
	public void configBC() throws IOException {
		String browser1 = flib.getDataFromProperties("browser");
		
		
         if (browser1.equalsIgnoreCase("chrome")) {
			driver = new ChromeDriver();
		} else if (browser1.equals("edge")) {
			driver = new EdgeDriver();
		} else {
			driver = new ChromeDriver();
		}
         
         sdriver=driver;
         UtilityClassObject.setDriver(driver);

		// LAUNCH BROWSER

	}

	@BeforeMethod(groups= {"smoke","regression"})
	public void configBM() throws IOException {
		LoginPage loginpage = new LoginPage(driver);
		String username = flib.getDataFromProperties("un");
		String password = flib.getDataFromProperties("pw");
		String url = flib.getDataFromProperties("url");
		driver.get(url);
		loginpage.login(username, password);

		// LOGIN
	}

	@AfterMethod(groups= {"smoke","regression"})
	public void configAM() {
		HomePage homepage = new HomePage(driver);
		homepage.signOut();
		// LOGOUT

	}

	@AfterClass(groups= {"smoke","regression"})
	public void configAC() {
		driver.quit();
		// CLOSE BROWSER
	}

	@AfterSuite(groups= {"smoke","regression"})
	public void configAS() {
		dblib.closeDbConnection();
		
		// CLOSE DB/ REPORT BACKUP
		
	}

}
