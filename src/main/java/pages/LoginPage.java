package pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import core.TestCore;

public class LoginPage extends TestCore{
	
	WebDriver driver;
	public LoginPage(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
		Assert.assertEquals(driver.getTitle(), "bonify");
	}
	
	@FindBy(name="email")
	private WebElement txtEmail;
	@FindBy(name="password")
	private WebElement txtPassword;
	@FindBy(xpath="//button[@type='submit']")
	private WebElement btnLogin;
	@FindBy(className = "ico-logo-bonify")
	private WebElement bonifyLogo;
	@FindBy(xpath = "//div[@class='login-panel']/h1")
	private WebElement h1Tag;
	@FindBy(xpath="//a/span[text()='Passwort vergessen?']")
	private WebElement lnkForgotPassword;
	@FindBy(xpath="//button/span[text()='Neu registrieren']")
	private WebElement lnkRegistration;
	@FindBy(xpath = "//a[@href='http://bonify.de/impressum']")
	private WebElement lnkConditions;
	@FindBy(xpath = "//a[@href='http://bonify.de/agb']")
	private WebElement lnkImprint;
	@FindBy(xpath = "//a[@href='http://bonify.de/datenschutz']")
	private WebElement lnkDataProtection;
	@FindBy(xpath = "//p[@class='general-error']")
	private WebElement txtLoginErrorMessage;
	
	@FindBy(xpath="//span[text()]/parent::a")
	private List<WebElement> links;

	boolean boolCheck;
	
	public List<String> getLinks()
	{
		List<String> list = new ArrayList<>();
		links.forEach((e) -> list.add(e.getAttribute("href")));
		return list;
	}
	public boolean setEmail(String email)
	{
		boolCheck=false;
		if(txtEmail.isDisplayed())
		{
			if(txtEmail.isEnabled())
			{
				txtEmail.clear();
				txtEmail.sendKeys(email);
				boolCheck=true;
			}
		}
		return boolCheck;
	}
	
	public boolean setPassword(String password)
	{
		boolCheck = false;
		if(txtPassword.isDisplayed())
		{
			if(txtPassword.isEnabled())
			{
				txtPassword.clear();
				txtPassword.sendKeys(password);
				boolCheck=true;
			}
		}
		return boolCheck;
	}
	
	public boolean clickLogin()
	{
		boolCheck = false;
		if(btnLogin.isDisplayed())
		{
			if(btnLogin.isEnabled())
			{
				btnLogin.click();
				boolCheck = true;
			}
		}
		return boolCheck;
	}
	public void verifyLoginPage() {
		SoftAssert softAssert = new SoftAssert();
		softAssert.assertTrue(bonifyLogo.isDisplayed(), "Bonify logo is not displayed on the login page");
		softAssert.assertTrue(h1Tag.getText().equals("Willkommen bei bonify!"), "Welcome Text is not displayed on the login page");
		softAssert.assertTrue(lnkForgotPassword.isDisplayed(), "Forgot Password link is not displayed on the login page");
		softAssert.assertTrue(lnkImprint.isDisplayed(), "Imprint Link is not displayed on the login page");
		softAssert.assertTrue(lnkConditions.isDisplayed(), "Conditions Link is not displayed on the login page");
		softAssert.assertTrue(lnkConditions.isDisplayed(), "Data Protection Link is not displayed on the login page");
		softAssert.assertAll();
	}

	public String getLoginErrorMsg()
	{
		return txtLoginErrorMessage.getText().trim();
	}
	public UserDashBoard login(String emailId, String password)
	{
		setEmail(emailId);
		setPassword(password);
		clickLogin();
		return new UserDashBoard(driver);
	}	
}