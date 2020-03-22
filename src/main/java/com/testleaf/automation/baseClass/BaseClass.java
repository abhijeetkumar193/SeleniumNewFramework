package com.testleaf.automation.baseClass;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.Select;

import com.aventstack.extentreports.ExtentReports;
import com.testleaf.automation.baseClass.api.BrowserAPI;
import com.testleaf.automation.baseClass.api.webelementAPI;
import com.testleaf.automation.utils.ReporterClass;

public class BaseClass extends ReporterClass implements BrowserAPI,webelementAPI{

	
	
	public static Properties prop;
	//public FileInputStream fis;
	public  static RemoteWebDriver driver;
	
	
	
	public void Loadproperty() throws IOException {
		prop= new Properties();
		prop.load(new FileInputStream(new File("./dataSource/config.properties")));
		//return prop.getProperty(element);
	}
	
	public String getValueFrompropertyFile(String key)
	{
		return prop.getProperty(key);
	}
	
	
	/*@Override
	public void openBrowser(String browser) {
		// TODO Auto-generated method stub
		
		switch(browser.toLowerCase()) {
		
		case "chrome":
			System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
			driver= new ChromeDriver();
		}
	}*/
	
	@Override
	public WebElement locateElement(String locatorType, String locatorValue) {
		// TODO Auto-generated method stub
		switch(locatorType.toLowerCase()) {
		
		case "id":
			return driver.findElementById(locatorValue);
		case "name":
			return driver.findElementByName(locatorValue);
		case "class":
		return	driver.findElementByClassName(locatorValue);
		case "linktext":
			return driver.findElementById(locatorValue);
		case "xpath":
		return 	driver.findElementByXPath("//*[contains(text(),"+locatorValue+")]");
		case "partialtext":
			return driver.findElementByPartialLinkText(locatorValue);
		case "tagname":
		return 	driver.findElementByTagName(locatorValue);
			
		}
		return null;
		
	}
	
	
	
	

	@Override
	public String getTestFromElement(WebElement ele) {
		// TODO Auto-generated method stub
		return ele.getText();
		
	}

	@Override
	public void clickElement(WebElement ele) {
		// TODO Auto-generated method stub
		ele.click();
	}

	@Override
	public void enterValue(WebElement ele, String enterValue) {
		// TODO Auto-generated method stub
		ele.clear();
		ele.sendKeys(enterValue);
		
	}
	
	@Override
	public void enterValueWithKeyPress(WebElement ele, String enterValue,String keyPress) {
		// TODO Auto-generated method stub
		ele.clear();
		ele.sendKeys(enterValue,Keys.TAB);
		
	}

	@Override
	public void selectDropdownbyindex(WebElement ele, int index) {
		// TODO Auto-generated method stub
		new Select(ele).selectByIndex(index);
	}
	
	@Override
	public void selectDropdownbyvisibleText(WebElement ele, String text) {
		// TODO Auto-generated method stub
		new Select(ele).selectByVisibleText(text);
	}

	@Override
	public void selectDropdownbyValue(WebElement ele, String value) {
		// TODO Auto-generated method stub
		new Select(ele).selectByVisibleText(value);
		
	}

	@Override
	public void checkBoxIsSelected(WebElement ele) {
		// TODO Auto-generated method stub
		if(!ele.isSelected())
			ele.click();
		
	}

	@Override
	public void checkBoxDeSelect(WebElement ele) {
		// TODO Auto-generated method stub
		if(ele.isSelected())
			ele.click();
		
	}

	@Override
	public List<WebElement> locateElements(String locatorType, String locatorValue) {
		// TODO Auto-generated method stub
switch(locatorType.toLowerCase()) {
		
		case "id":
			return driver.findElementsById(locatorValue);
		case "name":
			return driver.findElementsByName(locatorValue);
		case "class":
		return	driver.findElementsByClassName(locatorValue);
		case "linktext":
			return driver.findElementsById(locatorValue);
		case "xpath":
		return 	driver.findElementsByXPath(locatorType);
		case "partialtext":
			return driver.findElementsByPartialLinkText(locatorValue);
		case "tagname":
		return 	driver.findElementsByTagName(locatorValue);
			
		}
		return null;
		
	}

	@Override
	public void actionDragAndDrop(WebElement src, WebElement dest) {
		// TODO Auto-generated method stub
		new Actions(driver).dragAndDrop(src, dest).perform();
		
		
	}
	public void actionDragAndDropMoveToelement(WebElement ele) {
		// TODO Auto-generated method stub
		new Actions(driver).moveToElement(ele).perform();
		
		
	}

	@Override
	public void windowFrameHandlng(String locatorType) {
		// TODO Auto-generated method stub
			driver.switchTo().frame(locatorType);
		
		}
	public void defaultWindowFrame()
	{
		driver.switchTo().defaultContent();
	}
		
	

	@Override
	public void SwitchTowindowsHandling(int Winum) {
		// TODO Auto-generated method stub
		Set<String> allwindowshandles = driver.getWindowHandles();
		List<String> listOfWindows = new ArrayList<>(allwindowshandles);
		driver.switchTo().window(listOfWindows.get(Winum));
		
	}

	@Override
	public void alertHandling(String alerthandle) {
		// TODO Auto-generated method stub
		Alert alert= driver.switchTo().alert();
		
		switch(alerthandle.toLowerCase()) {
			
			case "ok":
				 alert.accept();break;
				
			case "dismiss":
				alert.dismiss(); break;
				
			case "gettext"	:
				alert.getText(); break;
				
			case "entervalue":
				alert.sendKeys("a23"); break;
				
		}
		
		
	}

	@Override
	public void switchToParentWindow() {
		// TODO Auto-generated method stub
		String CurrentWindowHandle= driver.getWindowHandle();
		Set<String> allwindowshandles = driver.getWindowHandles();
		List<String> listOfWindows = new ArrayList<>(allwindowshandles);
		for (String string : listOfWindows) {
			if(!string.equals(CurrentWindowHandle))
			{
				driver.switchTo().window(string).close();
			}
		}
		
		
		
		
	}
@Override
	public void startApp()
	{
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		driver= new ChromeDriver();
		driver.get(prop.getProperty("url"));
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	
		
	}

@Override
public void closeApp() {
	driver.close();
	
}


	

}
