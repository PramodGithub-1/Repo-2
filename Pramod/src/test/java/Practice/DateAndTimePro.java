package Practice;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateAndTimePro {
public static void main(String[] args)throws Throwable {
	SimpleDateFormat sdf=new SimpleDateFormat("dd/MM/YYYY   HH:mm:ss");
	Date d=new Date();
	String systemDateandTime=sdf.format(d);
	System.out.println(systemDateandTime);
}
}
