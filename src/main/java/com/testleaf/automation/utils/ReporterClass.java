package com.testleaf.automation.utils;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.testleaf.automation.baseClass.BaseClass;

public class ReporterClass
{
	public ExtentReports extentReports;
	public static ExtentTest scExtentTest;
	public static ExtentTest featureTest;
	public static String reportFolder="TestLeaf/test-output/ExtentReport/";
	String filename=reportFolder+"report.html";
	
	public void ExtentReports()
	{
		extentReports= new ExtentReports();
		ExtentHtmlReporter htmlReporter= new ExtentHtmlReporter(filename);
		htmlReporter.config().setTheme(Theme.DARK);
		htmlReporter.config().setDocumentTitle("TestLeaf Test Report");
		htmlReporter.config().setEncoding("UTF-8");
		htmlReporter.config().setReportName("TestLeaf Report");
		extentReports.attachReporter(htmlReporter);
		extentReports.flush();
		
	}
	
	

	
	
	
}
