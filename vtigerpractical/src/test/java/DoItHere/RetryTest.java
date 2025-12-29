package DoItHere;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.comcast.crm.basetest.BaseClass;

public class RetryTest extends BaseClass {

	
	@Test(retryAnalyzer = com.comcast.crm.listenerutility.RetryListenerImpliment.class)
	public void activeSim() {

		String actualtitle = driver.getTitle();
		Assert.assertEquals(actualtitle, "home");
		System.out.println("executed");
	}
}
