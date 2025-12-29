package DoItHere;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.comcast.crm.basetest.BaseClass;

public class ReportsTest extends BaseClass {

	@Test
	public void test1() {
		//spark report config]]
		ExtentSparkReporter spark = new ExtentSparkReporter("./Reports");
		spark.config().setDocumentTitle("test Report");
		spark.config().setReportName("Verify Header");
		spark.config().setTheme(Theme.DARK);
		
		//ADD environment and create test
		ExtentReports report = new ExtentReports();
		report.attachReporter(spark);
		report.setSystemInfo("Os", "Windows_11");
		report.setSystemInfo("Browser", "Chrome");
		ExtentTest test = report.createTest("test1");
		
	
		driver.findElement(By.xpath("//a[@class='hdrLink']")).click();
		
		String headerinfo = driver.findElement(By.cssSelector("span[class='dvHeaderText']")).getText();
        if (headerinfo.contains("Home")) {
          	test.log(Status.PASS, "verified");
		} else {
			test.log(Status.FAIL, "not verified");
		}
	}

}
