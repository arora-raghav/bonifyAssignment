package testCases;

import java.util.Hashtable;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import core.TestCore;
import pages.LoginPage;
import pages.UserDashBoard;
import utils.CommonFunctions;

public class VerifyLogin extends TestCore{

	LoginPage loginPage;
	UserDashBoard userDashBoard;
	@BeforeClass
	public void initialise()
	{
		loginPage = new LoginPage(driver); 
	}
	
	@Test
	public void verifyLoginPage()
	{
		loginPage.verifyLoginPage();
	}
	@Test(dataProviderClass=CommonFunctions.class, dataProvider="dp", priority=1)
	public void verifyLogin(Hashtable<String, String> data)
	{
		userDashBoard = loginPage.login(data.get("email"), data.get("password"));
		if(!userDashBoard.getWelcomeMsg().equals(""))
		{
			Assert.assertEquals(userDashBoard.getWelcomeMsg(), data.get("expectedVal"));
			userDashBoard.logout();
		}
		else
		{
			Assert.assertEquals(loginPage.getLoginErrorMsg(), data.get("expectedVal"));			
		}
	}

	@Test
	public void verifyLinks()
	{
		for(String link : loginPage.getLinks())
		{
			Assert.assertTrue(CommonFunctions.linkExists(link), link + " is having an issue.");	
		}
	}
	@AfterClass
	public void clear()
	{
		loginPage = null; 
	}
		
}