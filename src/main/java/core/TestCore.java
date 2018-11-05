package core;

import java.util.concurrent.TimeUnit;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import utils.Browser;
import utils.ExcelReader;
import utils.Property;

public class TestCore {
	public static WebDriver driver;
	public static Logger logger;
	public static ExcelReader excel = new ExcelReader(System.getProperty("user.dir") +"\\resources\\testData\\TestData.xlsx");
	Browser browser = new Browser();
	@BeforeSuite
	public void init()
	{
	    System.setProperty("logDirectory", "./src/main/java/logs/");
		System.setProperty("log4j.configurationFile", "./log4j2.xml");
		logger = LogManager.getLogger(this.getClass().getName());
		if(driver==null)
		{
			driver=browser.get(Property.get("browser"));
			logger.debug("Opening Browser : " + Property.get("browser"));
		}
		browserSettings();
		logger.info("Browser settings completed");
		driver.get(Property.get("URL"));
		logger.info("Navigating to URL : "+Property.get("URL"));
	}
	public void browserSettings()
	{
		driver.manage().window().maximize();
		logger.debug("Maximizing Browser");
		driver.manage().timeouts().implicitlyWait(30l, TimeUnit.SECONDS);
		logger.debug("Applying Implicit Wait..");
	}
	@AfterSuite
	public void tearDown()
	{
		if(driver!=null)
		{
			logger.debug("Closing Browser session");
			driver.quit();
		}
	}
}
