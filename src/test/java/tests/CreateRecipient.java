package tests;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import browserrelated.Base;
import browserrelated.ProjectSpecificMethods;
import pages.DashboardPage;
import utils.ReadPropertyFile;
import utils.Reusable;

public class CreateRecipient extends ProjectSpecificMethods{
	
	
	@BeforeTest
	public void setValues() {
		testcaseName = "Create Recipient";
		testDescription ="Create Recipient with mandatory fields";
		authors="Hari";
		category ="Smoke";
		
	}
	
	


	@Test
	public void createRecipient() throws FileNotFoundException, IOException
	{
		new DashboardPage()
		.clickRecipientsTab()
		.clickAddRecipientButton()
		.clickAddDifferentRecipient()
		.enterRecipientFirstName(Reusable.generateFirstName())
		.saveRecipientFirstName()
		.enterRecipientLastName(Reusable.generateLastName())
		.saveRecipientLastName()
		.enterRecipientSSN(Reusable.generateRandomNumber(5))
		.saveSSN()
		.enterRecipientMedicaidID(Reusable.generateRandomNumber(5))
		.saveMedicaidID()
		.enterRecipientDOB("03/16/1989")
		.clickNextButton()
		.clickEmergencyContactAddContact()
		.enterRecipientContactName(Reusable.generateUserName())
		.saveEmergencyContactName()
		.enterEmergencyContactPhone(Reusable.generateRandomNumber(10))
		.saveEmergencyContactPhoneNumber()
		.clickRelationshipDropdown()
		.clickRelationshipValueFromListBox()
		.clickNextButtonInEmergencyContact()
		.enterFindAddress("1230 Montauk")
		.clickFindAddressFirstResult()
		.enterPrimaryPhone(Reusable.generateRandomNumber(10))
		.savePrimaryPhone()
		.clickNextButtonInAddress()
		.clickPayerDropdown()
		.clickFLT1OptionInPayer()
		.clickAddPlan()
		.enterPlanInputbox("");
		
	}
}
