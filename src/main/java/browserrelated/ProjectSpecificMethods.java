package browserrelated;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import pages.LoginPage;
import utils.ReadPropertyFile;

public class ProjectSpecificMethods extends Base{
	
	
	@BeforeMethod
	public void precondition() throws FileNotFoundException, IOException
	{
		setup(ReadPropertyFile.readFile("url"));
		
		setNode();
		
		new LoginPage()
		.enterUserName("<<EnterUsername here>>")
		.enterPassword("<<Enter Pwd here>>")
		.clickLoginButton()
		.validateUserLogIn();
	}
	
	@AfterMethod(alwaysRun=true)
	public void postcondition()
	{
		quit();
	}

}
