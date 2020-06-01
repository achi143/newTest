package test.Aretrip;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;
import org.testng.log4testng.Logger;

import PageObjects.Bookrooms;
import PageObjects.SignInPage;
import resources.BaseTest;

public class Tc_002 extends BaseTest {
	

	@Test
	public void LoginIn() throws InterruptedException {
		
		SignInPage s = PageFactory.initElements(driver, SignInPage.class);
		
		s.button();
		
	logger.info("click on the sign in button");
		s.setEmail(email);
		
		logger.info("Enter email address");
		
		s.setPwd(password);
		
		logger.info("Enter password");
		s.Submit();
		
		Thread.sleep(3000);
		
		logger.info("click on the Signin button");
	}
	
	
	
	@Test
	public void bookroom() throws InterruptedException {
		
		Bookrooms br = PageFactory.initElements(driver, Bookrooms.class);
		
		br.hotel();
		Thread.sleep(3000);
		
		logger.info("click on the hotel");
		
		br.clickonLocation();
		Thread.sleep(3000);
		
		logger.info("click on the location");
		
		driver.findElement(By.id("autocomplete-js")).clear();
		Thread.sleep(3000);
		
		logger.info("clear the element which is already present in the location textbox");
		
		br.nearlocation("hanamkonda");
		
		Thread.sleep(3000);
		
	//	br.select(Keys.ENTER);
		
		driver.findElement(By.id("autocomplete-js")).sendKeys(Keys.ENTER);
		Thread.sleep(3000);
		
		br.calander();
		Thread.sleep(3000);
		
		logger.info("clicked on the calander");
		
		//Aug 23
		
		while(!driver.findElement(By.xpath("//th[@class='datepickerMonth']//a[@href='#']")).getText().contains("Aug"))
		{
			
			driver.findElement(By.xpath("//th[@class='datepickerGoNext']")).click();
		}
		
		
		
		List<WebElement> dates = driver.findElements(By.xpath("//a[@href='#']"));
		
		int count = driver.findElements(By.xpath("//a[@href='#']")).size();
		
		for(int i=0;i<count;i++)
		{
			String text = driver.findElements(By.xpath("//a[@href='#']")).get(i).getText();
			
			if(text.equalsIgnoreCase("23"))
			{
				driver.findElements(By.xpath("//a[@href='#']")).get(i).click();
				
				break;
			}
		}
		//.datepickerDisabled
		
		////a[@href='#']
		
	}
}
