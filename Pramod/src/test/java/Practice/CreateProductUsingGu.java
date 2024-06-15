package Practice;

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

import GenericUtilities.PropertiesUtility;

public class CreateProductUsingGu {
	public static void main(String[] args)throws Throwable {
		//1.using properties utility
		PropertiesUtility PUTIL=new PropertiesUtility();
		String URL=PUTIL.readDataFromProperties("url");
		String USERNAME=PUTIL.readDataFromProperties("username");
		String PASSWORD=PUTIL.readDataFromProperties("password");
		//2.using excel utility
		FileInputStream fise=new FileInputStream(".\\src\\test\\resources\\TestData.xlsx");
		Workbook wb=WorkbookFactory.create(fise);
		Sheet sh=wb.getSheet("Products");
		String PRODUCTNAME=sh.getRow(1).getCell(2).getStringCellValue();
	     //3.Launch the browser
			WebDriver driver=new ChromeDriver();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
			driver.manage().window().maximize();
	    //4.Access the app using URL
			driver.get(URL);
			driver.findElement(By.name("user_name")).sendKeys(USERNAME);
			driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
			driver.findElement(By.id("submitButton")).click();
		//5.click on contacts module
			driver.findElement(By.linkText("Products")).click();
		//6.click on contacts lookup image
			driver.findElement(By.xpath("//img[@title='Create Product...']")).click();
		//7.Enter data into mandatory fields and click on save button
			driver.findElement(By.name("productname")).sendKeys(PRODUCTNAME);
			driver.findElement(By.xpath("(//input[@title='Save [Alt+S]'])[2]")).click();
		//8.verification
			String conHeader=driver.findElement(By.className("lvtHeaderText")).getText();
		    if(conHeader.contains(PRODUCTNAME))
		    {
		    	System.out.println("product is created");
		    }
		    else
		    {
		    	System.out.println("product is not created");
		    }
		
		//9.logout
		    WebElement element=driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
	        Actions act=new Actions(driver);
	        act.moveToElement(element).perform();
	        driver.findElement(By.linkText("Sign Out")).click();
	        driver.quit();
		}
}
