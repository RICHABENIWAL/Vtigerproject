package com.comcast.crm.listenerutility;

import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ISuite;
import org.testng.ISuiteListener;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.comcast.crm.basetest.BaseClass;
import com.comcast.crm.genricutility.webdriverutility.UtilityClassObject;

public class ListenerImplement implements ITestListener, ISuiteListener {
	public ExtentReports report;
	public ExtentTest test;

	public void onStart(ISuite suite) {
		System.out.println("report configuration");
		String time = new Date().toString().replace(" ", "_").replace(":", "_");
		ExtentSparkReporter spark = new ExtentSparkReporter("./AdvanceReports/report_"+time+".html");
		spark.config().setDocumentTitle("test Report");
		spark.config().setReportName("Verify Header");
		spark.config().setTheme(Theme.DARK);

		// ADD environment and create test
		report = new ExtentReports();
		report.attachReporter(spark);
		report.setSystemInfo("Os", "Windows_11");
		report.setSystemInfo("Browser", "Chrome");

	}

	public void onFinish(ISuite suite) {
		System.out.println("report backup");
		report.flush();

	}

	public void onTestStart(ITestResult result) {
		test = report.createTest(result.getMethod().getMethodName());
		System.out.println("Method Name :" + result.getMethod().getMethodName() + "starts");
		UtilityClassObject.setTest(test);
		test.log(Status.INFO, result.getMethod().getMethodName());
	}

	public void onTestSuccess(ITestResult result) {
		System.out.println("Method Name :" + result.getMethod().getMethodName() + " finish");
		test.log(Status.PASS, "passed" + test.log(Status.INFO, result.getMethod().getMethodName()));
		
	}

	public void onTestFailure(ITestResult result) {
		String testname = result.getMethod().getMethodName();
		TakesScreenshot screenshot = (TakesScreenshot) BaseClass.sdriver;
		String getscreen = screenshot.getScreenshotAs(OutputType.BASE64);
		String time = new Date().toString().replace(" ", "_").replace(":", "_");
		// File file = new File("./screenshots/" + testname + "+" + time + ".png");
		test.addScreenCaptureFromBase64String(testname, getscreen);
		test.log(Status.FAIL, "failed" + test.log(Status.INFO, result.getMethod().getMethodName()));
	}

	public void onTestSkipped(ITestResult result) {
		test.log(Status.SKIP, "got skipped" + test.log(Status.INFO, result.getMethod().getMethodName()));
	}

}
