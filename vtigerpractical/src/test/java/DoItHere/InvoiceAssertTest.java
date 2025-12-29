package DoItHere;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.comcast.crm.basetest.BaseClass;

@Listeners(com.comcast.crm.listenerutility.ListenerImplement.class)
public class InvoiceAssertTest extends BaseClass {

	@Test
	public void createInvoiceTest() {

		String actualtitle = driver.getTitle();
		Assert.assertEquals(actualtitle, "login");
		System.out.println("executed");

	}

	@Test
	public void createcontactTest() {

		String actualtitle = driver.getTitle();
		Assert.assertEquals(actualtitle, "home");
		System.out.println("executed");

	}

}
