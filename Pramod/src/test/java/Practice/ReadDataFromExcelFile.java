package Practice;

import java.io.FileInputStream;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ReadDataFromExcelFile {
public static void main(String[] args) throws Throwable{
	FileInputStream fise=new FileInputStream(".\\src\\test\\resources\\TestData.xlsx");
	Workbook wb=WorkbookFactory.create(fise);
	/*Sheet sh=wb.getSheet("Contacts");
	String LASTNAME=sh.getRow(1).getCell(2).getStringCellValue();
	System.out.println(LASTNAME);*/
	/*Sheet sh=wb.getSheet("Leads");
	String LASTNAME=sh.getRow(1).getCell(2).getStringCellValue();
	String COMPANY=sh.getRow(1).getCell(3).getStringCellValue();
	System.out.println(LASTNAME);
	System.out.println(COMPANY);*/
	Sheet sh=wb.getSheet("Products");
	String PRODUCTNAME=sh.getRow(1).getCell(2).getStringCellValue();
	System.out.println(PRODUCTNAME);
}
}
