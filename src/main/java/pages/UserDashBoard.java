package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import core.TestCore;

public class UserDashBoard extends TestCore{

	WebDriver driver;
	public UserDashBoard(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
		Assert.assertEquals(driver.getTitle(), "bonify");
	}
	
	@FindBy(xpath="//*[@id='main-header']//*[@class='dropdown nav-menu-dropdown']")
	private WebElement userSettings;
	@FindBy(xpath="//*[@class='dropdown-layer open']//*[text()='Abmelden']/parent::button")
	private WebElement logout;
	@FindBy(xpath="//div[@class='welcome']//span")
	private WebElement welcomeMsg;
	 
	public String getWelcomeMsg()
	{
		try
		{
			return welcomeMsg.getText().trim();			
		}catch(Exception e)
		{
			return "";
		}
	}
	public void logout()
	{
		userSettings.click();
		if(logout.isDisplayed())
		{
			logout.click();			
		}
	}
}
