package ContactsTests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import ContactsObjectRepository.ContactValidation;
import ContactsObjectRepository.ContactsLookUpPage;
import ContactsObjectRepository.ContactsPage;
import ContactsObjectRepository.HomePage;
import ContactsObjectRepository.LoginPage;
import GenericUtilities.BaseClass;

public class CreateConatctBaseClassTest extends BaseClass {
	@Test
	public void createConatactWithMandatoryFields() throws Throwable
	{
		String LASTNAME=EUTIL.readDataFromExcel("Contacts", 1, 2);
		HomePage hp=new HomePage(driver);
		hp.clickOnContactsLink();
		ContactsLookUpPage clp=new ContactsLookUpPage(driver);
		clp.clickOnConatctLookUp();
	   ContactsPage cp=new ContactsPage(driver);
	   cp.saveContact(LASTNAME);
	   ContactValidation cv=new ContactValidation(driver);
		String conHeader=cv.validateContact();
	    if(conHeader.contains(LASTNAME))
	    {
	    	System.out.println("contact is created");
	    }
	    else
	    {
	    	System.out.println("contact is not created");
	    }
	   	
	}
}
