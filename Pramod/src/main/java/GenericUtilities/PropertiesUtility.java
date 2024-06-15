package GenericUtilities;

import java.io.FileInputStream;
import java.util.Properties;
/**
 * This is the class which contains generic method for properties file
 * @author LENOVO
 *
 */
public class PropertiesUtility {
	/**This is the generic method used for access the from properties file
	 * This is the 
	 * @param key
	 * @return VALUE
	 * @throws Throwable
	 */
public String readDataFromProperties(String key) throws Throwable
{
	FileInputStream fisp=new FileInputStream(".\\src\\test\\resources\\CommonData");
	Properties p=new Properties();
	p.load(fisp);
	String VALUE=p.getProperty(key);
	return VALUE;
}
}
