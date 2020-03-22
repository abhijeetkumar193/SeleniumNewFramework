package stepDefinitions;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.testleaf.automation.baseClass.BaseClass;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;

public class stepErailHomePage extends BaseClass{
	
	@Given("Open the erail web application")
	public stepErailHomePage open_the_erail_web_aplication()
	{	
		return this;
	}
	
	@And("Enter the (.*) station")
	public void enter_the_to_station(String from) throws InterruptedException
	{
		String keypress="";
		//enterValue(locateElement("id", prop.getProperty("ToStationId")), from, "keypress");
		//enterValueWithKeyPress(locateElement("id",prop.getProperty("ToStationId") ), from, keypress);
		enterValueWithKeyPress(locateElement("id",prop.getProperty("ToStation") ), from, keypress);
		Thread.sleep(2000);
		
	}
	
	@And("Enter the (.*) Station")
	public void enter_the_from_station(String To) throws InterruptedException
	{
		String keypress="";
	//	enterValue(locateElement("id", prop.getProperty("FromstationId")), To);
		enterValueWithKeyPress(locateElement("id",prop.getProperty("FromstationId") ), To, keypress);
		Thread.sleep(2000);
	}
	
	
	
	@Then("Click on enter button")
	public void Click_on_enter_button()
	{
		clickElement(locateElement("id", prop.getProperty("FindTrains")));
		
	}
	@And("find all the train names")
	public void find_all_the_train_names() {
		int count=0;
		WebElement locateElement = locateElement("xpath", prop.getProperty("NoOTrainsId"));
		List<WebElement> findElements = locateElement.findElements(By.tagName("tr"));
		for (WebElement webElement : findElements) {
			if(webElement.findElements(By.tagName("td")).size()>0) {
				count++;
			}
			
			
		}
		System.out.println("Number of trains displaying are as :: "+count);
		
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
}
