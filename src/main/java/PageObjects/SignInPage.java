package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import resources.BasePage;

public class SignInPage extends BasePage{
	
	
	public SignInPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	
	By clicksignin = By.xpath("//div[@class='registerSignIn js-register-signin']");
	
	By email = By.id("email");
	
	By password = By.id("password");
	
	By Signin = By.id("login_submit");
	
	
	public void button() {
		click(clicksignin);
	}
	
	public void setEmail(String mail) {
		
		writeText(email,mail);
	}
	
	public void setPwd(String Password) {
		
		writeText(password,Password);		
	}
	
	public void Submit() {
		click(Signin);
	}

}
