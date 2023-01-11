package pages;

import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.PageFactory;

import browserrelated.Base;
import enums.Locators;

public class LoginPage extends Base{
	
		
	private String userName = "//input[@data-automation='login-userName-input']";
	
	private String password = "//input[@data-automation='login-userPassword-input']";
	
	private String loginButton = "//button[@data-automation='login-userSubmit-button']";
	

	
	public LoginPage enterUserName(String value)
	{
		
		type(element(Locators.xpath,userName), value,"Username ");
		
		return this;
	}
	
	
	public LoginPage enterPassword(String value)
	{
		
		type(element(Locators.xpath,password), value, "Password");
		
		
		return this;
	}
	
	public DashboardPage clickLoginButton()
	{
		
		//waitTillElementEnabled(element(Locators.xpath,loginButton));
		
		click(element(Locators.xpath, loginButton),"Login button");
		
		
		
		
		return new DashboardPage();
	}

}
