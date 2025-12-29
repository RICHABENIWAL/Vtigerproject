package DoItHere;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProviderTest {
   
	@Test(dataProvider = "getData")
	public void createContact(String name, String Sname) {
		
		System.out.println("name :" + name + " " + "Sname :" + Sname);
	}
	
	

	@DataProvider
	public Object[][] getData(){
		Object [][] obj = new Object[3][2];
		obj[0][0] = "sam";
	    obj[0][1] = "s";
	    
	    obj[1][0] = "tam";
	    obj[1][1] = "t";
	    
	    obj[2][0] = "lam";
	    obj[2][1] = "l";		
	    
	    return obj;
		
	}
	
	
	
}
