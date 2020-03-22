package com.testleaf.automation.baseClass.api;

import java.util.List;

import org.openqa.selenium.WebElement;

public interface webelementAPI {

	
	public WebElement locateElement(String locatorType, String locatorValue);
	public String getTestFromElement(WebElement ele);
	public void clickElement(WebElement ele);
	public void enterValue(WebElement ele,String enterValue);
	public void selectDropdownbyindex(WebElement ele, int index);
	public void selectDropdownbyvisibleText(WebElement ele, String text);
	public void selectDropdownbyValue(WebElement ele, String value);
	public void checkBoxIsSelected(WebElement ele);
	public void checkBoxDeSelect(WebElement ele);
	public List<WebElement> locateElements(String locatorType, String locatorValue);
	public void actionDragAndDrop(WebElement src, WebElement dest);
	public void actionDragAndDropMoveToelement(WebElement ele);
	public void windowFrameHandlng(String locatorType);
	public void defaultWindowFrame();
	public void SwitchTowindowsHandling(int Winum);
	public void switchToParentWindow();
	public void alertHandling(String alerthandle);
	public void enterValueWithKeyPress(WebElement ele, String enterValue,String keyPress);
	
	
}
