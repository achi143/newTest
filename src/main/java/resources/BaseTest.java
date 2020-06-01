package resources;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;



public class BaseTest {

	public String email="ashrithyadav460@gmail.com";
	public String password = "Thungani@10";
	protected static WebDriver driver;
	public static Properties prop;
	public static Logger logger;
	
	//@BeforeTest
	
	public WebDriver initializeDriver() throws IOException {
		


		logger = Logger.getLogger("HybridFramework1");
		 PropertyConfigurator.configure("Log4j.properties");

		prop = new Properties();

		FileInputStream fis = new FileInputStream(
				System.getProperty("user.dir") + "\\src\\main\\java\\resources\\good.properties");

		prop.load(fis);

		String browserName = prop.getProperty("browser");

		System.out.println(browserName);

		if (browserName.contains("chrome")) {

			System.setProperty("WebDriver.chrome.driver",
					System.getProperty("user.dir") + "\\Drivers\\chromedriver.exe");

			driver = new ChromeDriver();
		}

		else {
			if (browserName.contains("firefox")) {

				System.setProperty("WebDriver.gecko.driver",
						System.getProperty("user.dir") + "\\Drivers\\geckodriver.exe");

				driver = new FirefoxDriver();
			}

			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			

		}
	

	return driver;

	}
	
	@BeforeTest
	public WebDriver initialize() throws IOException {

		driver = initializeDriver();

		driver.get(prop.getProperty("url"));

		driver.manage().window().maximize();

		// driver.get(prop.getProperty("url"));
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

		return driver;
	}

	@AfterTest
	public void teardown() {

		driver.close();

	}

	public String getScreenshotPath(String TestCaseName, WebDriver driver) throws IOException {

		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		String destpath = System.getProperty("user.dir") + "\\Reports\\" + TestCaseName + ".png";

		File file = new File(destpath);
		FileUtils.copyFile(source, file);

		return destpath;

	}

}
