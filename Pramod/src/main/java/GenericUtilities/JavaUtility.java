package GenericUtilities;

import java.util.Date;

public class JavaUtility {
public String getSystemDate()
{
	Date d=new Date();
	String darr[]=d.toString().split(" ");
	String date=darr[0]+"-"+darr[1]+"-"+darr[2]+"_"+darr[3]+"-"+darr[4]+"-"+darr[5];
	return date;
	
}
}
