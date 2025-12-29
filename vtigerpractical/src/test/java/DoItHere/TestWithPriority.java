package DoItHere;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import com.comcast.crm.genric.fileutility.ExcelUtility;
import com.comcast.crm.genric.fileutility.FileUtility;
import com.comcast.crm.genricutility.webdriverutility.JavaUtility;
import com.comcast.crm.genricutility.webdriverutility.WebDriverUtility;
import com.comcast.crm.objectrepositoryutility.ContactEditPage;
import com.comcast.crm.objectrepositoryutility.ContactInformationPage;
import com.comcast.crm.objectrepositoryutility.CreateContactPage;
import com.comcast.crm.objectrepositoryutility.HomePage;
import com.comcast.crm.objectrepositoryutility.LoginPage;

public class TestWithPriority {
	//never use priority in test cases instead use dependsOnMethods instead
	//in priority it just sets the order of execution and executes the test cases
	//even if 1st test case got failed it will continue the execution of 2nd test case
	WebDriver driver = new ChromeDriver();
	WebDriverUtility wlib = new WebDriverUtility();
	ExcelUtility elib = new ExcelUtility();
	FileUtility flib = new FileUtility();
	JavaUtility jlib = new JavaUtility();
	ContactEditPage contactedit = new ContactEditPage(driver);
	ContactInformationPage contactinfo = new ContactInformationPage(driver);
	HomePage homepage = new HomePage(driver);
	
	
	
	
	@Test(priority=1)
	public void login() throws IOException {
		LoginPage loginpage = new LoginPage(driver);
		String username = flib.getDataFromProperties("un");
		String password = flib.getDataFromProperties("pw");
		String url = flib.getDataFromProperties("url");
		driver.get(url);
		loginpage.login(username, password);
		
		
	}
		
	@Test(priority=2)
	public void createContactTest() throws IOException, Throwable {
		
	    String lastname = elib.getDataFromExcelFile("contact",1 , 2)+jlib.getRandomNumber();
		CreateContactPage contactpage = new CreateContactPage(driver);
		contactpage.createContact(lastname);	
		contactinfo.verifyHeader(lastname);
	}
	
	@Test(priority=3)
	public void editContactTest() throws IOException, Throwable {
		contactinfo.getEditButton().click();
		String lastname = elib.getDataFromExcelFile("contact", 1, 2)+jlib.getRandomNumber();
		contactedit.editContact(lastname);
		
	}
	
	
	
	  @Test(priority=4)
	  public void deleteContactTest() {
	  contactinfo.getDeletebutton().click();
	  wlib.switchToAlertAccept(driver);
	  }
	  
	  @Test(priority=5)
	  public void signOut() {
		  homepage.signOut();
		  
	  }
	 
	 
	

}
