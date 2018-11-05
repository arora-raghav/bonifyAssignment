package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class ForgotPassword {
	WebDriver driver;
	public ForgotPassword(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
		Assert.assertEquals(driver.getTitle(), "bonify");
	}
	@FindBy(name="email")
	private WebElement email;
	
	@FindBy(xpath="//button[@type='submit']")
	private WebElement submit;
	
}
