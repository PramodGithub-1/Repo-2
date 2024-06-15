package CalenderPopups;



import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Calendar;
import java.util.Date;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Popup1 {

	public static void main(String[] args) throws Throwable{
		 WebDriver driver=new ChromeDriver();
		 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		 driver.manage().window().maximize();
		 driver.get("https://www.makemytrip.com/");
		 WebElement element=driver.findElement(By.xpath("//a[class='close']"));
		 Actions act=new Actions(driver);
		 act.moveToElement(element, 400, 400).click().build().perform();
		 
  /*Calendar cal=Calendar.getInstance();
 Date d=cal.getTime();
 SimpleDateFormat sdf=new SimpleDateFormat("dd/MM/YYYY");
 String currentDate=sdf.format(d);

 
 System.out.println(currentDate);*/
 }

}
