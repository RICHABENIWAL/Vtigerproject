package DoItHere;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.comcast.crm.genric.fileutility.ExcelUtility;

public class DataProviderWithExcel {
	WebDriver driver = new ChromeDriver();
	
	
	@Test(dataProvider = "getData")
	public void getPrice(String brand, String product) {
		driver.get("https://www.flipkart.com/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.findElement(By.name("q")).sendKeys(brand,Keys.ENTER);
		String price = driver.findElement(By.xpath("//div[text()='"+product+"']/ancestor::div[@class='ZFwe0M row']/descendant::div[text()='₹1,34,900']")).getText();
		
		System.out.println("product :" + product + " price :" + price);
		
		driver.quit();
		
	}
	
	@DataProvider
	public Object[][] getData() throws IOException, Throwable{
		ExcelUtility elib = new ExcelUtility();
		int rowcount = elib.getRowCount("price");
		
		Object [][] objarr = new Object[rowcount][2];
		for(int i =0; i<rowcount;i++) {
		objarr[i][0]= elib.getDataFromExcelFile("price", i+1, 0);
		objarr[i][1]= elib.getDataFromExcelFile("price", i+1, 1);
		
			
		}
		
		return objarr;
		
	}

}
