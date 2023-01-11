package pages;

import java.sql.DriverManager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import browserrelated.Base;
import enums.Locators;


public class DashboardPage extends Base{
	
	RemoteWebDriver driver;
		
	private String userLogIn= "//button[@data-automation='username-menu-button']";
	
	private String dashboardTab = "//a[@data-automation='menuItem-mainComponent.sidenav.dashboard']";
	
	private String usersTab = "//a[@data-automation='menuItem-mainComponent.sidenav.users']";
	
	private String visitsTab = "//a[@data-automation='menuItem-mainComponent.sidenav.visits']";
	
	private String recipientsTab = "//a[@data-automation='menuItem-mainComponent.sidenav.recipients']";
	
	private String loadingProgressBar = "//mat-toolbar//mat-progress-bar[contains(@aria-label,'Content is loading')]";
	
	
	
	
	public void validateUserLogIn()
	{
		waitTillElementNotDisplayed(elements(Locators.xpath, loadingProgressBar));
		Assert.assertEquals(isDisplayed(element(Locators.xpath, userLogIn)), true);
	}
	

	
	public DashboardPage clickDashboardTab()
	{
		
		click(element(Locators.xpath, dashboardTab),"Dashboard Tab");
		
		return this;
	}
	
	public UsersPage clickUsersTab()
	{
		
		click(element(Locators.xpath, usersTab),"Users Tab");
		
		return new UsersPage();
	}
	
	public VisitsPage clickVisitsTab()
	{
		
		click(element(Locators.xpath, visitsTab), "Visits Tab");
		
		
		return new VisitsPage();
	}
	
	public RecipientsPage clickRecipientsTab()
	{
		click(element(Locators.xpath, recipientsTab),"Recipients tab");
		
		waitTillElementNotDisplayed(elements(Locators.xpath, loadingProgressBar));
		
		return new RecipientsPage();
	}
	
	

}
