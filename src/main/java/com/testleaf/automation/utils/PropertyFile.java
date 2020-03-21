package com.testleaf.automation.utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import com.testleaf.automation.ProjectSpecificMethods.ProjectSpecificMethods;

public class PropertyFile  extends ProjectSpecificMethods{
	
	public String propertyValue(String element) throws IOException {
		prop= new Properties();
		fis= new FileInputStream(System.getProperty("./dataSource/config.properties"));
		prop.load(fis);
		return prop.getProperty(element);
	}
}
