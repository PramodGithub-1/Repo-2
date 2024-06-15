package LeadsTest;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import GenericUtilities.BaseClass;
import LeadsObjectRepository.HomePage;
import LeadsObjectRepository.LeadValidation;
import LeadsObjectRepository.LeadsLookUpPage;
import LeadsObjectRepository.LeadsPage;
import LeadsObjectRepository.LoginPage;

public class CreateLeadBaseClassTest  extends BaseClass{
	@Test
	public void createLeadWithMandatoryFields() throws Throwable
	{
		    String LASTNAME=EUTIL.readDataFromExcel("Leads", 1, 2);
  		    String COMPANY=EUTIL.readDataFromExcel("Leads", 1, 3);
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
  		
	}
}
