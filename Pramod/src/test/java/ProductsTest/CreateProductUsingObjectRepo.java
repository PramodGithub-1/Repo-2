package ProductsTest;

import java.io.FileInputStream;
import java.time.Duration;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.internal.thread.ThreadExecutionException;

import GenericUtilities.ExcelUtility;
import GenericUtilities.PropertiesUtility;
import GenericUtilities.SeleniumUtility;
import ProductsObjectRepository.HomePage;
import ProductsObjectRepository.LoginPage;
import ProductsObjectRepository.ProductValidation;
import ProductsObjectRepository.ProductsLookUpPage;
import ProductsObjectRepository.ProductsPage;

public class CreateProductUsingObjectRepo {
public static void main(String[] args) throws Throwable
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
