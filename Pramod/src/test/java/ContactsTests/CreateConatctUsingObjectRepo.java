package ContactsTests;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import ContactsObjectRepository.ContactValidation;
import ContactsObjectRepository.ContactsLookUpPage;
import ContactsObjectRepository.ContactsPage;
import ContactsObjectRepository.HomePage;
import ContactsObjectRepository.LoginPage;
import GenericUtilities.ExcelUtility;
import GenericUtilities.PropertiesUtility;
import GenericUtilities.SeleniumUtility;

public class CreateConatctUsingObjectRepo {
public static void main(String[] args) throws Throwable {
	        PropertiesUtility PUTIL=new PropertiesUtility();
	        ExcelUtility EUTIL=new ExcelUtility();
	        SeleniumUtility SUTIL=new SeleniumUtility();
			String URL=PUTIL.readDataFromProperties("url");
			String USERNAME=PUTIL.readDataFromProperties("username");
			String PASSWORD=PUTIL.readDataFromProperties("password");
		    String LASTNAME=EUTIL.readDataFromExcel("Contacts", 1, 2);
				WebDriver driver=new ChromeDriver();
				SUTIL.implicitWait(driver);
				SUTIL.maximizeWindow(driver);
				driver.get(URL);
				LoginPage lp=new LoginPage(driver);
				lp.loginToApp(driver, USERNAME, PASSWORD);
				HomePage hp=new HomePage(driver);
				hp.clickOnContactsLink();
				ContactsLookUpPage clp=new ContactsLookUpPage(driver);
				clp.clickOnConatctLookUp();
			   ContactsPage cp=new ContactsPage(driver);
			   cp.saveContact(LASTNAME);
			//8.verification
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
			
			//9.logout
			    hp.logoutFromApp(driver);
		        driver.quit();
}
}
