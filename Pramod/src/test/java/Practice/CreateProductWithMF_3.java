package Practice;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class CreateProductWithMF_3 {
	public static void main(String[] args)throws Throwable {
	     //1.Launch the browser
			WebDriver driver=new ChromeDriver();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
			driver.manage().window().maximize();
	    //2.Access the app using URL
			driver.get("http://localhost:8888/");
			driver.findElement(By.name("user_name")).sendKeys("admin");
			driver.findElement(By.name("user_password")).sendKeys("admin");
			driver.findElement(By.id("submitButton")).click();
		//3.click on contacts module
			driver.findElement(By.linkText("Products")).click();
		//4.click on contacts lookup image
			driver.findElement(By.xpath("//img[@title='Create Product...']")).click();
		//5.Enter data into mandatory fields and click on save button
			driver.findElement(By.name("productname")).sendKeys("Sandelwood");
			driver.findElement(By.xpath("(//input[@title='Save [Alt+S]'])[2]")).click();
		//6.verification
			String conHeader=driver.findElement(By.className("lvtHeaderText")).getText();
		    if(conHeader.contains("Sandlewood"))
		    {
		    	System.out.println("product is created");
		    }
		    else
		    {
		    	System.out.println("product is not created");
		    }
		
		//7.logout
		    WebElement element=driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
	        Actions act=new Actions(driver);
	        act.moveToElement(element).perform();
	        driver.findElement(By.linkText("Sign Out")).click();
	        driver.quit();
		}

}
