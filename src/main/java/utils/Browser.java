package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Browser {
	WebDriver driver;
	public WebDriver get(String browserName)
	{
		try
		{
			if(browserName.equalsIgnoreCase("ff")||browserName.equalsIgnoreCase("firefox"))
			{
				System.setProperty("webdriver.gecko.driver", "./resources/drivers/geckodriver.exe");
				driver = new FirefoxDriver();
			}
			else if(browserName.equalsIgnoreCase("chrome"))
			{
				System.setProperty("webdriver.chrome.driver", "./resources/drivers/chromedriver.exe");
				driver = new ChromeDriver();
			}
			else
			{
				throw new IllegalArgumentException("No such browser exists : " + browserName);
			}
		}catch(Exception e)
		{
			System.out.println("Got an error while initialzing the browser" + e.getMessage());
		}
		return driver;
	}
}