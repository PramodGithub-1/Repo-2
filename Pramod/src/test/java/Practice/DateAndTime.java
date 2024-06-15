package Practice;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import GenericUtilities.JavaUtility;

public class DateAndTime {
public static void main(String[] args) throws Throwable {
	/*SimpleDateFormat df=new SimpleDateFormat("dd/MM/YYYY HH:mm:ss");
	Date d=new Date();
	String systemdate=df.format(d);
	System.out.println(systemdate);*/
	Date d=new Date();
	JavaUtility JUTIL=new JavaUtility();
	String systemdate=JUTIL.getSystemDate();
	System.out.println(systemdate);
}
}
