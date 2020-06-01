package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;


import resources.BasePage;

public class Bookrooms extends BasePage{

	public Bookrooms(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	By clickHotel = By.id("hotels-module");
	
	By select = By.id("autocomplete-js");
	
	By remove = By.id("autocomplete-js");
	
	By location = By.id("autocomplete-js");
	
	By Enter = By.id("autocomplete-js");
	
	By cal = By.xpath("//div[@class='icon-left']//i//i[@class='icon icon_check-in']");

	
	public void hotel() {
		
		click(clickHotel);
	}
	
	public void clickonLocation() {
		
		click(remove);
	}
	
	/*ss*/
	
	public void nearlocation(String near) {
		
		writeText(location,near);
	}
	
	public void select(String enter) {
		writeText(Enter,enter);
	}

	public void calander() {
		click(cal);
		
	}
	

}