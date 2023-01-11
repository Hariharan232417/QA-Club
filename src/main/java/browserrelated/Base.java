package browserrelated;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import enums.Browser;
import enums.Locators;
import io.github.bonigarcia.wdm.WebDriverManager;
import utils.Reporter;

public class Base extends Reporter implements SeleniumBase{
	
	protected static RemoteWebDriver driver=null;
	
	protected static WebDriverWait wait = null;

	public void setup(String url) {
		
		WebDriverManager.chromedriver().setup();
		
		 driver =new ChromeDriver();
		
		driver.get(url);
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		
		driver.manage().window().maximize();
	}

	public void setup(Browser browser, String url) {
		
		
		switch(browser) {
		
		case CHROME: 
			 driver =new ChromeDriver();
			 break;
			
		case FIREFOX:
			driver = new FirefoxDriver();
			break;
			
		case EDGE:
			driver = new EdgeDriver();
			break;
		default:
		
		}
		driver.get("https://evv-dashboard.qa-gov.4tellus.net/auth/login");
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		
		driver.manage().window().maximize();
		
		
	}

	public void close() {
		
		driver.close();
	}

	public void quit() {
		// TODO Auto-generated method stub
		driver.quit();
	}

	public WebElement element(Locators type, String value) {
		
		
		try {
			switch(type) {
			
			case id: return driver.findElement(By.id(value));
			case name: return driver.findElement(By.name(value));
			case classname: return driver.findElement(By.className(value));
			case linktext: return driver.findElement(By.linkText(value));
			case partiallinktext: return driver.findElement(By.partialLinkText(value));
			case tagname: return driver.findElement(By.partialLinkText(value));
			case xpath: return driver.findElement(By.xpath(value));
			case css: return driver.findElement(By.cssSelector(value));
			}
		} catch (NoSuchElementException e) {
			System.err.println("Element not found ==> "+e.getMessage());
			throw new NoSuchElementException("Element Not found");
		}
		catch (WebDriverException e) {
		
			throw new WebDriverException("Element Not found - Webdriver exception");
		}
		
		return null;
	}
	
	
public List<WebElement> elements(Locators type, String value) {
		
		
		switch(type) {
		
		case id: return driver.findElements(By.id(value));
		case name: return driver.findElements(By.name(value));
		case classname: return driver.findElements(By.className(value));
		case linktext: return driver.findElements(By.linkText(value));
		case partiallinktext: return driver.findElements(By.partialLinkText(value));
		case tagname: return driver.findElements(By.partialLinkText(value));
		case xpath: return driver.findElements(By.xpath(value));
		case css: return driver.findElements(By.cssSelector(value));
		}
		
		return null;
	}

	public void switchToWindow(int i) {
		
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		Set<String> windowHandles = driver.getWindowHandles();
		List<String> lst_windowHandles = new ArrayList(windowHandles);
		
		lst_windowHandles.get(i);
		
		
		
	}

	public void selectValue(WebElement ele, String value) {
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

		WebElement element = wait.until(ExpectedConditions.visibilityOf(ele));
		
		Select slt = new Select(element);
		
		slt.selectByValue(value);
		
		
	}

	public void selectText(WebElement ele, String text) {
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		WebElement element = wait.until(ExpectedConditions.visibilityOf(ele));
		
		Select slt = new Select(element);
		
		slt.selectByVisibleText(text);
		
	}

	public void selectIndex(WebElement ele, int index) {
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		WebElement element = wait.until(ExpectedConditions.visibilityOf(ele));
		
		Select slt = new Select(element);
		
		slt.selectByIndex(index);
		
	}

	public void click(WebElement ele, String elementName) {
		
		String text = "";
		
		try {
			Thread.sleep(1000);
			
			WebElement element = wait.until(ExpectedConditions.elementToBeClickable(ele));
			
			text = element.getText();
			
			reportStep("The Element " + text + " is to be clicked ", "pass");
			
			element.click();
			
			
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		catch (StaleElementReferenceException e) {
			System.err.println(e);
			reportStep("The Element " + text + " could not be clicked due to:" + e.getMessage(), "fail");
		} catch (WebDriverException e) {
			System.err.println(e);
			reportStep("The Element " + ele + " could not be clicked due to: " + e.getMessage(), "fail");
		} catch (Exception e) {
			System.err.println(e);
			reportStep("The Element " + ele + " could not be clicked due to: " + e.getMessage(), "fail");
		}
		
		
		
	}

	public void type(WebElement ele, String value, String elementName) {
		
		try {
			Thread.sleep(1000);
		
			wait=new WebDriverWait(driver,Duration.ofSeconds(20));
			WebElement element = wait.until(ExpectedConditions.visibilityOf(ele));
			element.clear();
			element.sendKeys(value);
			
			reportStep(elementName+" is entered ", "pass");
			
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		catch (StaleElementReferenceException e) {
			throw new StaleElementReferenceException("Element is stale ");
		}
		catch (ElementNotInteractableException e) {
			reportStep("The Element " + ele + " is not Interactable \n" + e.getMessage(), "fail");
		} catch (WebDriverException e) { // retry - 1
			
			try {
				ele.sendKeys(value);
			} catch (Exception e1) {
				reportStep("The Element " + ele + " did not allow to clear / type \n" + e.getMessage(), "fail");
			}
		}
	}

	public void type(WebElement ele, String value, Keys key, String elementName) {
		
		try {
			Thread.sleep(1000);
			WebElement element = wait.until(ExpectedConditions.visibilityOf(ele));
			element.clear();
			element.sendKeys(value,key.ENTER);
			
			reportStep(elementName+" is entered and Enter Key pressed", "pass");
			
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		catch (ElementNotInteractableException e) {
			reportStep("The Element " + ele + " is not Interactable \n" + e.getMessage(), "fail");
		} catch (WebDriverException e) {
			reportStep("The Element " + ele + " is not Interactable \n" + e.getMessage(), "fail");
		}
		
		
	}

	public void appendText(WebElement ele,String value) {
		
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		WebElement element = wait.until(ExpectedConditions.visibilityOf(ele));
		element.clear();
		element.sendKeys(value);
		
	}

	public boolean isDisplayed(WebElement ele) {
		
		try {
			if (ele.isDisplayed()) {
				return true;
			} else {
				reportStep("The element " + ele + " is not visible", "warnings");
			}
		} catch (WebDriverException e) {
			reportStep("WebDriverException : \n" + e.getMessage(), "fail");
		}
		return false;
		
	}
	
	public void waitTillElementEnabled(WebElement ele)
	{
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		wait.until(ExpectedConditions.attributeContains(ele, "disabled", "false"));
	}
	
	
	public void waitTillElementNotDisplayed(List<WebElement> ele)
	{
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		if (ele.size() > 0) {
			WebDriverWait wait = new WebDriverWait(driver, 20);
			wait.until(ExpectedConditions.invisibilityOf(ele.get(0)));
			
			System.out.println("Waited till progress bar loading is completed");

		} else {
			System.out.println("No element found for wait");
		}
	}
	
	
	public String getAttributeValue(WebElement ele, String attribute)
	{
		return ele.getAttribute(attribute);
	}

	@Override
	public long takeSnap() {
		long number = (long) Math.floor(Math.random() * 900000000L) + 10000000L;
		try {
			FileUtils.copyFile(driver.getScreenshotAs(OutputType.FILE),new File("./report_output/screenshots/"+number+".jpg"));
					//new File("./"+Reporter.folderName+"/images/" + number + ".jpg"));
			
		} catch (WebDriverException e) {
			reportStep("The browser has been closed." + e.getMessage(), "fail");
		} catch (IOException e) {
			reportStep("The snapshot could not be taken " + e.getMessage(), "warning");
		}
		return number;
	}

	

}
