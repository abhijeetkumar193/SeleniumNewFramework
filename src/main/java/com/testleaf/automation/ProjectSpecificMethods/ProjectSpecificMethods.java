package com.testleaf.automation.ProjectSpecificMethods;


import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import com.testleaf.automation.baseClass.BaseClass;
import com.testleaf.automation.utils.ExcelReader;
import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;


@CucumberOptions(features="./src/test/java/features/TestLeafHomePage.feature", glue="stepDefinitions"
, monochrome=true  /*, dryRun=true, snippets=SnippetType.CAMELCASE*/
/*,plugin = {"pretty", "html:target/cucumber"}*/)
public class ProjectSpecificMethods extends AbstractTestNGCucumberTests {

	
	
	public String filePath;
	public int sheetNumber;
	public ExtentReports extent;
	public ExtentTest extentTest;

	
	
	@BeforeSuite
	public void loadPropertiesFiles() throws IOException
	{
		new BaseClass().Loadproperty();
	}
	
	
	
	/*@BeforeTest
	public void extentReport()
	{
		extent = new ExtentReports(System.getProperty("user.dir")+"/test-output/ExtentReport.html", true);
		extent.addSystemInfo("Host Name", "Naveen Mac");
		extent.addSystemInfo("User Name", "Naveen Automation Labs");
		extent.addSystemInfo("Environment", "QA");
	}*/
	
	
	
	@BeforeMethod
	public void openApplication()
	{
		new BaseClass().startApp();
	}
	
	@AfterMethod
	public void closeApp() throws InterruptedException
	{
		
		Thread.sleep(2000);
	new BaseClass().closeApp();
	}
	
	@DataProvider(name="getdata")
	public String[][] fetchExcelData() throws IOException
	{
		String[][] data= ExcelReader.getExcelData(filePath, sheetNumber);
		return data;	
	}
	
	
	/*public static String getScreenshot(WebDriver driver, String screenshotName) throws IOException{
		String dateName = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		// after execution, you could see a folder "FailedTestsScreenshots"
		// under src folder
		String destination = System.getProperty("user.dir") + "/snaps/" + screenshotName + dateName
				+ ".jpeg";
		File finalDestination = new File(destination);
		FileUtils.copyFile(source, finalDestination);
		return destination;
	}*/
	/*@AfterTest
	public void AfterExtentReports(ITestResult result) throws IOException
	{
		if(result.getStatus()==ITestResult.FAILURE){
			extentTest.log(LogStatus.FAIL, "TEST CASE FAILED IS "+result.getName()); //to add name in extent report
			extentTest.log(LogStatus.FAIL, "TEST CASE FAILED IS "+result.getThrowable()); //to add error/exception in extent report
			
			String screenshotPath = ProjectSpecificMethods.getScreenshot(driver, result.getName());
			extentTest.log(LogStatus.FAIL, extentTest.addScreenCapture(screenshotPath)); //to add screenshot in extent report
			//extentTest.log(LogStatus.FAIL, extentTest.addScreencast(screenshotPath)); //to add screencast/video in extent report
		}
		else if(result.getStatus()==ITestResult.SKIP){
			extentTest.log(LogStatus.SKIP, "Test Case SKIPPED IS " + result.getName());
		}
		else if(result.getStatus()==ITestResult.SUCCESS){
			extentTest.log(LogStatus.PASS, "Test Case PASSED IS " + result.getName());

		}
		
		
		extent.endTest(extentTest); //ending test and ends the current test and prepare to create html report
		driver.quit();
		
		
	}*/
	
}
