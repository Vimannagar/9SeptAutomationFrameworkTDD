package testclasses;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import extentlisteners.TestNGListeners;
import utility.ReadPropData;
import utility.TimeValueGenerator;

public class LoginTest extends TestNGListeners {
	
	@Test(priority = 4)
	public void loginToApp() throws IOException
	{	
		test.info("entering the credentials");
		
		ReadPropData data = new ReadPropData();
		
		String emailValue= data.getPropData("emailaddress");
		
		
		loginpage.enterCredentials(TimeValueGenerator.getTime()+emailValue);
		
		test.info("Clicking on login button");
		
		loginpage.clickOnLogin();
	}
	
	@Test(priority = 3)
	
	public void validateTitle()
	{
		test.info("Fetching the title of page");
		
		String title= loginpage.getTitleOfPage();
		
		test.info("Validating the title");
		Assert.assertEquals(title, "Let'ss Shop");


	}

}
