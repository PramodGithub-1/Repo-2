package Practice;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import GenericUtilities.JavaUtility;
import GenericUtilities.SeleniumUtility;

public class GenericUprogram {

	public static void main(String[] args)throws Throwable{
		   /*  //1.Launch the browser
				WebDriver driver=new ChromeDriver();
				driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
				driver.manage().window().maximize();
		    //2.Access the app using URL
				driver.get("http://localhost:8888/");
			//3.Taking screen shot
				SeleniumUtility SUTIL=new SeleniumUtility();
				SUTIL.takeScreenShotAction(driver,"image2");
			driver.quit();*/
		JavaUtility JUTIL=new JavaUtility();
		String systemDate=JUTIL.getSystemDate();
		System.out.println(systemDate);
	}

}
