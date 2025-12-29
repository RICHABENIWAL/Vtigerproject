package DoItHere;

import java.io.IOException;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.comcast.crm.basetest.BaseClass;
import com.comcast.crm.genricutility.webdriverutility.UtilityClassObject;
import com.comcast.crm.objectrepositoryutility.ContactInformationPage;
import com.comcast.crm.objectrepositoryutility.CreateContactPage;
@Listeners(com.comcast.crm.listenerutility.ListenerImplement.class)
public class ReportImplement extends BaseClass {

	@Test(groups= {"smoke","regression"})
	public void createContactTest() throws IOException, Throwable {
		String lastname = elib.getDataFromExcelFile("contact", 1, 2) + jlib.getRandomNumber();
		CreateContactPage contactpage = new CreateContactPage(driver);
		contactpage.createContact(lastname);
		ContactInformationPage contactinfo = new ContactInformationPage(driver);
		contactinfo.verifyHeader(lastname);
		//for low level reporting to be shared in html report
		UtilityClassObject.getTest().log(Status.INFO, "executed");
	}
}
