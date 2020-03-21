package com.testleaf.automation.ProjectSpecificMethods;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.testng.annotations.DataProvider;

import com.testleaf.automation.baseClass.BaseClass;
import com.testleaf.automation.utils.ExcelReader;

public class ProjectSpecificMethods extends BaseClass {

	public FileInputStream fis;
	public Properties prop;
	public String filePath;
	public int sheetNumber;
	
	
	
	
	@DataProvider(name="getdata")
	public String[][] fetchExcelData() throws IOException
	{
		String[][] data= ExcelReader.getExcelData(filePath, sheetNumber);
		return data;	
	}
	
}
