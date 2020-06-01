package test.Aretrip;

import org.openqa.selenium.support.PageFactory;

import org.testng.annotations.Test;

import PageObjects.SignInPage;
import resources.BaseTest;

public class SignInTest extends BaseTest {
	
	
	
	@Test
	public void LoginIn() {
		
		SignInPage s = PageFactory.initElements(driver, SignInPage.class);
		
		s.button();
		
	logger.info("click on the sign in button");
		s.setEmail(email);
		
		logger.info("Enter email address");
		
		s.setPwd(password);
		
		logger.info("Enter password");
		s.Submit();
		
		logger.info("click on the Signin button");
	}
	
	
	

}
