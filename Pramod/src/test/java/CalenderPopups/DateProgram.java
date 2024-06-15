package CalenderPopups;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.testng.annotations.Test;

public class DateProgram {
	@Test
public void sample()
{
	/*Calendar cal=Calendar.getInstance();
	SimpleDateFormat sdf=new SimpleDateFormat("dd/MM/YYYY hh:mm:ss");
	Date date=cal.getTime();
	String currentDate=sdf.format(date);
	System.out.println(currentDate);*/
	SimpleDateFormat sdf=new SimpleDateFormat("dd/MM/YYYY hh:mm:ss");
	Date d=new Date();
	String currentdate=sdf.format(d);
	System.out.println(currentdate);
	
}
}
