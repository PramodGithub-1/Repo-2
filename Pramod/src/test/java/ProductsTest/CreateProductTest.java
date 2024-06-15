package ProductsTest;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import GenericUtilities.ExcelUtility;
import GenericUtilities.PropertiesUtility;
import GenericUtilities.SeleniumUtility;
import ProductsObjectRepository.HomePage;
import ProductsObjectRepository.LoginPage;
import ProductsObjectRepository.ProductValidation;
import ProductsObjectRepository.ProductsLookUpPage;
import ProductsObjectRepository.ProductsPage;

public class CreateProductTest {
	@Test
public void createProductWithMF() throws Throwable
{
		PropertiesUtility PUTIL=new PropertiesUtility();
	    ExcelUtility EUTIL=new ExcelUtility();
	    SeleniumUtility SUTIL=new SeleniumUtility();
	        String URL=PUTIL.readDataFromProperties("url");
	  		String USERNAME=PUTIL.readDataFromProperties("username");
	  		String PASSWORD=PUTIL.readDataFromProperties("password");
	  		String PRODUCTNAME=EUTIL.readDataFromExcel("Products", 1, 2);
	  			WebDriver driver=new ChromeDriver();
	  			SUTIL.implicitWait(driver);
	  			SUTIL.maximizeWindow(driver);
	  			driver.get(URL);
	  			LoginPage lp=new LoginPage(driver);
	  			lp.loginToApp(driver, USERNAME, PASSWORD);
	  		    HomePage hp=new HomePage(driver);
	  		    hp.clickOnProductsLink();
	  		    ProductsLookUpPage plp=new ProductsLookUpPage(driver);
	  		    plp.clickOnProductsLookUp();
	  		    ProductsPage pp=new ProductsPage(driver);
	  		    pp.saveProduct(PRODUCTNAME);
	  		    ProductValidation pv=new ProductValidation(driver);
	  			String proHeader=pv.validateProduct();
	  		    if(proHeader.contains(PRODUCTNAME))
	  		    {
	  		    	System.out.println("product is created");
	  		    }
	  		    else
	  		    {
	  		    	System.out.println("product is not created");
	  		    }
	  		   hp.logoutFromApp(driver);
	  	        driver.quit();
}
}
