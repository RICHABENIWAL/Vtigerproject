package DoItHere;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import com.comcast.crm.genric.fileutility.ExcelUtility;
import com.comcast.crm.genric.fileutility.FileUtility;
import com.comcast.crm.genricutility.webdriverutility.JavaUtility;
import com.comcast.crm.objectrepositoryutility.CreateNewOrganisationPage;
import com.comcast.crm.objectrepositoryutility.HomePage;
import com.comcast.crm.objectrepositoryutility.LoginPage;
import com.comcast.crm.objectrepositoryutility.OrganisationInfoPage;
import com.comcast.crm.objectrepositoryutility.SearchOrganisationsPage;

public class HandlingDynamicXpathTest {

	WebDriver driver = new ChromeDriver();

	String orgname;

	@Test
	public void loginTest() throws IOException {

		FileUtility flib = new FileUtility();
		String un = flib.getDataFromProperties("un");
		String pw = flib.getDataFromProperties("pw");
		String url = flib.getDataFromProperties("url");

		driver.get(url);
		driver.manage().window().maximize();

		LoginPage loginpage = new LoginPage(driver);
		loginpage.login(un, pw);
	}

	@Test(dependsOnMethods = "loginTest")
	public void createOrganisationTest() throws IOException, Throwable {
		HomePage homepage = new HomePage(driver);
		homepage.navigateToOrganisation();

		ExcelUtility elib = new ExcelUtility();
		String shipaddres = elib.getDataFromExcelFile("sheet3", 1, 3);

		JavaUtility jlib = new JavaUtility();
		orgname = elib.getDataFromExcelFile("sheet3", 1, 2) + jlib.getRandomNumber();

		CreateNewOrganisationPage neworg = new CreateNewOrganisationPage(driver);
		neworg.createNewOrganisation(orgname, shipaddres);

	}

	@Test(dependsOnMethods = "createOrganisationTest")
	public void searchOrganisationTest() throws IOException, Throwable {
		Thread.sleep(2000);
		OrganisationInfoPage orginfo = new OrganisationInfoPage(driver);
		orginfo.getOrganisation().click();

		SearchOrganisationsPage searchorg = new SearchOrganisationsPage(driver);
		ExcelUtility elib = new ExcelUtility();

		String searchclmn = elib.getDataFromExcelFile("sheet3", 1, 5);

		searchorg.searchOrganisationInChild(orgname);

		Thread.sleep(5000);
		WebElement delete = driver.findElement(By.xpath("//a[text()='del']"));

		Thread.sleep(2000);
		delete.click();
		driver.switchTo().alert().accept();

	}

}
