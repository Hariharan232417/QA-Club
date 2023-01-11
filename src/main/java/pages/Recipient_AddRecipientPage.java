package pages;

import java.sql.DriverManager;

import org.openqa.selenium.By;

import browserrelated.Base;
import enums.Locators;

public class Recipient_AddRecipientPage extends Base{
	
	
	private String addDifferentRecipient = "//button[@data-automation='recipient-add-different']";
	
	private String recipientFirstName = "//input[@data-automation='recipient-firstName-input']";
	
	private String recipientLastName = "//input[@data-automation='recipient-lastName-input']";
	
	private String recipientSSN = "//input[@data-automation='recipientSSN-field']";
	
	private String recipientMedicaidID = "//span[contains(normalize-space(),'Medicaid ID:')]/..//input[@data-automation='recipientMedicaidId-field']";
	
	private String dob = "//input[@data-automation='recipient-dateOfBirth-input']";
	
	private String nextButton = "//button[contains(@data-automation,'nextButton')]";
	
	private String emergencyContactAddContactButton = "//evv-emergency-contact-edit//button[normalize-space()='add']";
	
	private String emergencyContactName = "//input[@data-automation='emergencyContact-name-input']";
	
	private String emergencyContactPhoneNumber = "//input[@data-automation='emergencyContact-phoneNumber-input']";
	
	private String enterRelationshipDropdown = "//mat-select[@data-automation='emergencyContact-relationship-select']";
	
	private String relationShipFriend = "//mat-option[@data-automation='Friend-option']";
	
	private String emergencyContactNextButton = "//button[@data-automation='emergencyContact-nextButton']";
	
	private String findAddressInputbox = "//input[@data-automation='editAddress-search-input']";
	
	private String findAddress_FirstResult = "(//div[contains(@class,'pac-container pac-logo')  and not(contains(@style, 'none'))]//span[@class='pac-item-query'])[1]";
	
	private String primaryPhone = "//input[@data-automation='editAddress-phone1-input']";
	
	private String nextAddress = "//button[@data-automation='addressPage-nextButton']";
	
	private String payerDropdown  = "//mat-select[@data-automation='payerSubscriptionEdit-payerName-select']";
	
	private String fltOptionInPayer = "//mat-option[@data-automation='FLT1-option']";
	
	private String addPlan = "//button[@data-automation='plan-table-actions-add-button']";
	
	private String planDialog_Plan = "//input[@data-automation='add-edit-plan-dialog-plan-input']";
	
	private String plan_FirstOption = "//mat-option[@data-automation='add-edit-plan-dialog-plan-0option']";
	
	private String plan_StartDate = "//input[@data-automation='add-edit-dialog-startDate-input']";
	
	private String plan_EndDate = "//input[@data-automation='add-edit-plan-dialog-endDate-input']";
	
	private String plan_submitButton = "//button[@data-automation='add-edit-plan-dialog-submit-button']";
	
	private String caseNumberInputbox = "//input[@data-automation='payerSubscriptionEdit-caseNumber-input']";
	
	private String payerMemberID = "//input[@data-automation='payerSubscriptionEdit-memberId-input']";
	
	private String loadingProgressBar = "//mat-toolbar//mat-progress-bar[contains(@aria-label,'Content is loading')]";
	
	
	public Recipient_AddRecipientPage clickAddDifferentRecipient()
	{
		
		click(element(Locators.xpath, addDifferentRecipient),"Add Different Recipient");
		
		return this;
	}
	
	public Recipient_AddRecipientPage enterRecipientFirstName(String value)
	{
		
		type(element(Locators.xpath,recipientFirstName), value,"Recipient First name");
		
	
		return this;
	}
	
	public Recipient_AddRecipientPage saveRecipientFirstName()
	{
		
		BasePage.recipientFirstNameValue = getAttributeValue(element(Locators.xpath,recipientFirstName),"value");
		System.out.println("Saved Recipient First Name : "+BasePage.recipientFirstNameValue);
		
		return this;
	}
	
	public Recipient_AddRecipientPage enterRecipientLastName(String value)
	{
		
		type(element(Locators.xpath,recipientLastName), value,"Recipient Last name");
		
			
		return this;
	}
	
	public Recipient_AddRecipientPage saveRecipientLastName()
	{
		BasePage.recipientLastNameValue = getAttributeValue(element(Locators.xpath,recipientLastName),"value");
	 
		System.out.println("Saved Recipient Last Name : "+BasePage.recipientLastNameValue);
		
		return this;
	}
	
	
	public Recipient_AddRecipientPage enterRecipientSSN(String value)
	{
		
		type(element(Locators.xpath,recipientSSN), value,"SSN");
		
				
		return this;
	}
	
	
	public Recipient_AddRecipientPage saveSSN()
	{
		BasePage.SSNValue =  getAttributeValue(element(Locators.xpath,recipientSSN),"value");
		
		System.out.println("Saved Recipient SSN  : "+BasePage.SSNValue);
		
		return this;
	}
	
	
	public Recipient_AddRecipientPage enterRecipientMedicaidID(String value)
	{
		
		type(element(Locators.xpath,recipientMedicaidID), value,"Medicaid ID");
		
		
		return this;
	}
	
	
	public Recipient_AddRecipientPage saveMedicaidID()
	{
		BasePage.MedicaidIDValue =  getAttributeValue(element(Locators.xpath,recipientMedicaidID),"value");
			
		System.out.println("Saved Recipient Medicaid ID  : "+BasePage.MedicaidIDValue);
		
		return this;
	}
	
	public Recipient_AddRecipientPage enterRecipientDOB(String value)
	{
	
		type(element(Locators.xpath,dob), value,"DOB");
		
				
		return this;
	}
	
	public Recipient_AddRecipientPage clickNextButton()
	{
		
		click(element(Locators.xpath, nextButton),"Next button in Add RecipientPage");
			
		return this;
	}
	
	
	public Recipient_AddRecipientPage clickEmergencyContactAddContact()
	{
		
		click(element(Locators.xpath, emergencyContactAddContactButton),"Emergency contact Add button");
		
		
		return this;
	}
	
	public Recipient_AddRecipientPage enterRecipientContactName(String value)
	{
		
		
		type(element(Locators.xpath,emergencyContactName), value,"Emergency contact Name");
	
		return this;
	}
	
	
	public Recipient_AddRecipientPage saveEmergencyContactName()
	{
		BasePage.EmergencyContactnameValue =  getAttributeValue(element(Locators.xpath,emergencyContactName),"value");
		
		System.out.println("Saved Recipient Emergency contact name  : "+BasePage.EmergencyContactnameValue);
		
		return this;
	}
	
	
	public Recipient_AddRecipientPage enterEmergencyContactPhone(String value)
	{
		
		type(element(Locators.xpath,emergencyContactPhoneNumber), value,"Emergency Contact Phone");
		
		return this;
	}
	
	
	public Recipient_AddRecipientPage saveEmergencyContactPhoneNumber()
	{
		BasePage.EmergencyPhoneNumber =  getAttributeValue(element(Locators.xpath,emergencyContactPhoneNumber),"value");
			
		
		System.out.println("Saved Emergency Phone number  : "+BasePage.EmergencyPhoneNumber);
		
		return this;
	}
	
	public Recipient_AddRecipientPage clickRelationshipDropdown()
	{
		
		click(element(Locators.xpath, enterRelationshipDropdown),"Relationship Dropdown");
		
		
		return this;
	}
	
	
	public Recipient_AddRecipientPage clickRelationshipValueFromListBox()
	{
		
		click(element(Locators.xpath, relationShipFriend),"Relation ship friend");
		
		
		return this;
	}
	
	public Recipient_AddRecipientPage clickNextButtonInEmergencyContact()
	{
		
		click(element(Locators.xpath, emergencyContactNextButton),"Next button in Emergency contact");
		
		
		
		return this;
	}
	
	public Recipient_AddRecipientPage enterFindAddress(String value)
	{
		
		type(element(Locators.xpath,findAddressInputbox), value,"Find Address Inputbox");
		
		
		
		return this;
	}
	
	
	public Recipient_AddRecipientPage clickFindAddressFirstResult()
	{
		
		
		click(element(Locators.xpath, findAddress_FirstResult),"First Result in findAddress");
		
		
		return this;
	}

	public Recipient_AddRecipientPage enterPrimaryPhone(String value)
	{
		
		type(element(Locators.xpath,primaryPhone), value,"Primary phone");
		
		return this;
	}
	
	
	public Recipient_AddRecipientPage savePrimaryPhone()
	{
		BasePage.primaryPhoneNumber =  	getAttributeValue(element(Locators.xpath,primaryPhone),"value");
		
		
		System.out.println("Saved primary Phone number  : "+BasePage.primaryPhoneNumber);
		
		return this;
	}
	
	public Recipient_AddRecipientPage clickNextButtonInAddress()
	{
		
		click(element(Locators.xpath, nextAddress),"Next button in Address");
		
		
		
		
		return this;
	}
	
	
	public Recipient_AddRecipientPage clickPayerDropdown()
	{
		
		click(element(Locators.xpath, payerDropdown),"Payer dropdown");
		
		
		return this;
	}
	
	public Recipient_AddRecipientPage clickFLT1OptionInPayer()
	{
		click(element(Locators.xpath, fltOptionInPayer),"FLT option in Payer");
		
		
		return this;
	}
	
	public Recipient_AddRecipientPage clickAddPlan()
	{
		
		click(element(Locators.xpath, addPlan),"Add plan");
		
		
		return this;
	}
	
	public Recipient_AddRecipientPage enterPlanInputbox(String value)
	{
		
		type(element(Locators.xpath,planDialog_Plan), value,"Plan dialog Plan");
		
		
		return this;
	}
	
	public Recipient_AddRecipientPage clickPlanFirstOption()
	{
	
		click(element(Locators.xpath, plan_FirstOption), "First option in Plan");
		
		
		return this;
	}
	
	
	
}
