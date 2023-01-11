package pages;

import browserrelated.Base;
import enums.Locators;

public class RecipientsPage extends Base{
	
	private String addRecipientButton= "//a[@data-automation='recipient-addButton']";
	
	private String loadingProgressBar = "//mat-toolbar//mat-progress-bar[contains(@aria-label,'Content is loading')]";
	
	public Recipient_AddRecipientPage clickAddRecipientButton()
	{
		
		click(element(Locators.xpath, addRecipientButton),"Add recipient button");
		
		waitTillElementNotDisplayed(elements(Locators.xpath, loadingProgressBar));
		
		
		return new Recipient_AddRecipientPage();
	}

}
