package GenericUtilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import LeadsObjectRepository.HomePage;
import LeadsObjectRepository.LoginPage;

public class BaseClass {
	ExcelUtility EUTIL=new ExcelUtility();
	PropertiesUtility PUTIL=new PropertiesUtility();
	SeleniumUtility SUTIL=new SeleniumUtility();
	public WebDriver driver;
@BeforeSuite 
public void bsconfig()
{
	System.out.println("===DB connection successful===");
}
@BeforeClass
public void bcconfig() throws Throwable
{
	String URL=PUTIL.readDataFromProperties("url");
	driver =new ChromeDriver();
	SUTIL.implicitWait(driver);
	SUTIL.maximizeWindow(driver);
	driver.get(URL);
	System.out.println("===browser launched===");
}
@BeforeMethod
public void bmconfig() throws Throwable
{
	String USERNAME=PUTIL.readDataFromProperties("username");
	String PASSWORD=PUTIL.readDataFromProperties("password");
	LoginPage lp=new LoginPage(driver);
	lp.loginToApp(driver, USERNAME, PASSWORD);
	System.out.println("===login successful===");
}
@AfterMethod
public void amconfig() throws Throwable
{
	HomePage hp=new HomePage(driver);
	hp.logoutFromApp(driver);
	System.out.println("===logout done successful===");
}
@AfterClass
public void accoifig()
{
	driver.quit();
	System.out.println("===browser closed successful===");
}
@AfterSuite
public void asconfig()
{
	System.out.println("===DB connection closure successful===");
}
}
