package DoItHere;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class UsingDataProvider {
	
	@Test(dataProvider = "getData")
	public void createContact(String name, String sname) {
		System.out.println("name --->" + name + "   sname--->" + sname);
	}
	
	@DataProvider
	public Object [][] getData(){
		Object [][] objarr = new Object[3][2];
		
		objarr [0][0] = "sam";
		objarr [0][1] = "S";
		
		objarr [1][0] = "Tam";
		objarr [1][1] = "T";
		
		objarr [2][0] = "Nam";
		objarr [2][1] = "N";
		
		return objarr;
		
	}

}
