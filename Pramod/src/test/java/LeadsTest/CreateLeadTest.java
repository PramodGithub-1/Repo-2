package LeadsTest;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import GenericUtilities.ExcelUtility;
import GenericUtilities.PropertiesUtility;
import GenericUtilities.SeleniumUtility;
import LeadsObjectRepository.HomePage;
import LeadsObjectRepository.LeadValidation;
import LeadsObjectRepository.LeadsLookUpPage;
import LeadsObjectRepository.LeadsPage;
import LeadsObjectRepository.LoginPage;

public class CreateLeadTest {
	@Test
public void createLeadWithMF() throws Throwable
{
		PropertiesUtility PUTIL=new PropertiesUtility();
	    ExcelUtility EUTIL=new ExcelUtility();
	    SeleniumUtility SUTIL=new SeleniumUtility();
	       String URL=PUTIL.readDataFromProperties("url");
	  		String USERNAME=PUTIL.readDataFromProperties("username");
	  		String PASSWORD=PUTIL.readDataFromProperties("password");
	  		String LASTNAME=EUTIL.readDataFromExcel("Leads", 1, 2);
	  		String COMPANY=EUTIL.readDataFromExcel("Leads", 1, 3);
	  			WebDriver driver=new ChromeDriver();
	  		    SUTIL.implicitWait(driver);
	  		    SUTIL.maximizeWindow(driver);
	  			driver.get(URL);
	  			LoginPage lp=new LoginPage(driver);
	  			lp.loginToApp(driver, USERNAME, PASSWORD);
	  		    HomePage hp=new HomePage(driver);
	  		    hp.clickOnLeadsLink();
	  		    LeadsLookUpPage llp=new LeadsLookUpPage(driver);
	  		    llp.clickOnLeadLookUp();
	  		    LeadsPage lpe=new LeadsPage(driver);
	  		    lpe.saveLead(LASTNAME, COMPANY);
	  		    LeadValidation lv=new LeadValidation(driver);
	  			String LeadHeader=lv.validateLead();
	  		    if(LeadHeader.contains(LASTNAME))
	  		    {
	  		    	System.out.println("lead is created");
	  		    }
	  		    else
	  		    {
	  		    	System.out.println("lead is not created");
	  		    }
	  		hp.logoutFromApp(driver);
	  	        driver.quit();	
}
}
