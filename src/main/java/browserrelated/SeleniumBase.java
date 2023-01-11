package browserrelated;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

import enums.Browser;
import enums.Locators;

public interface SeleniumBase {
	
	void setup(String url);
	void setup(Browser browser, String url);
	void close();
	void quit();
	WebElement element(Locators type, String value);
	void switchToWindow(int i);
	void selectValue(WebElement ele, String value);
	void selectText(WebElement ele, String text);
	void selectIndex(WebElement ele, int  index);
	void click(WebElement ele, String elementName);
	void type(WebElement ele,String value, String elementName);
	void type(WebElement ele,String value, Keys key, String elementName);
	void appendText(WebElement ele,String value);
	boolean isDisplayed(WebElement ele);


}
