package GenericUtilities;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.google.common.io.Files;

/**
 * This is the class contains generic methods to perform several operations
 * @author LENOVO
 *
 */
public class SeleniumUtility {
/**
 * This is the generic method used for maximize the window
 * @param driver
 * @throws Throwable
 */
	public void maximizeWindow(WebDriver driver) throws Throwable
	{
	driver.manage().window().maximize();	
	}

/**
 * This is the generic method used for give implicit wait for window	
 * @param driver
 * @throws Exception
 */
	public void implicitWait(WebDriver driver) throws Exception
	{
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	}
	/**
	 * This is the generic method for give thread for 2 seconds
	 * @throws Exception
	 */
	public void threadWait() throws Exception
	{
		Thread.sleep(2000);
	}
	/**
	 * This is the generic method used for move mouse cursor to specific web element
	 * @param driver
	 * @param element
	 */
	public void moveMouseToElement(WebDriver driver, WebElement element)
	{
	Actions act=new Actions(driver);
	act.moveToElement(element).perform();
	}
	/**
	 * Dropdown handling based on index
	 * @param element
	 * @param index
	 */
	public void dropDownBasedOnIndex(WebElement element,int index)
	{
		Select s=new Select(element);
		s.selectByIndex(index);
	}
	/**
	 * drop down handling using value
	 * @param element
	 * @param value
	 */
	public void dropDownBasedOnValue(WebElement element,String value)
	{
		Select s=new Select(element);
		s.selectByValue(value);
	}
	/**
	 * Drop down handling using text
	 * @param element
	 * @param text
	 */
	public void dropDownBasedOnText(WebElement element,String text)
	{
		Select s=new Select(element);
		s.selectByVisibleText(text);
	}
	
	public String takeScreenShotAction(WebDriver driver,String screenshotName) throws Throwable
	{
		TakesScreenshot ts=(TakesScreenshot) driver;
		File src=ts.getScreenshotAs(OutputType.FILE);
		File dest=new File(".\\Screenshots"+screenshotName+".PNG");
		Files.copy(src, dest);
		return dest.getAbsolutePath();
	}
}
