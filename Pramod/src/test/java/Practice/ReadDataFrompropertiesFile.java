package Practice;

import GenericUtilities.PropertiesUtility;

public class ReadDataFrompropertiesFile {

	public static void main(String[] args) throws Throwable {
		PropertiesUtility PUTIL=new PropertiesUtility();
		String URL=PUTIL.readDataFromProperties("url");
		String USERNAME=PUTIL.readDataFromProperties("username");
		String PASSWORD=PUTIL.readDataFromProperties("password");
        System.out.println(URL);
        System.out.println(USERNAME);
        System.out.println(PASSWORD);
	}

}
