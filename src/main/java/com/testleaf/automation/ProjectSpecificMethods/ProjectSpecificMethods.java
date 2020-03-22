package com.testleaf.automation.ProjectSpecificMethods;

import java.io.File;
import java.io.IOException;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.cucumber.listener.Reporter;
import com.testleaf.automation.baseClass.BaseClass;
import com.testleaf.automation.utils.ExcelReader;

import cucumber.api.CucumberOptions;
import cucumber.api.SnippetType;
import cucumber.api.testng.AbstractTestNGCucumberTests;


@CucumberOptions(features="./src/test/java/features/TestLeafHomePage.feature", glue="stepDefinitions"
, monochrome=true  /*, dryRun=true, snippets=SnippetType.CAMELCASE*/,
plugin = {“com.cucumber.listener.ExtentCucumberFormatter:target/cucumber-reports/report.html”})
public class ProjectSpecificMethods extends AbstractTestNGCucumberTests {

	
	
	public String filePath;
	public int sheetNumber;
    
	
	
	@BeforeSuite
	public void loadPropertiesFiles() throws IOException
	{
		new BaseClass().Loadproperty();
	}
	
	@BeforeClass
	public void beforeClass()
	{
		
	}
	
	
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
	@AfterClass
	public void ExtentReports()
	{
		
		
		
	}
	
}
