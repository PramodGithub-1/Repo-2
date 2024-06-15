package GenericUtilities;

import java.io.FileInputStream;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
/**
 * This class contains generic methods for excel file
 * @author LENOVO
 *
 */
public class ExcelUtility {
	/**
	 * This is the generic method used for access data from excel sheet
	 * @param sheetName
	 * @param rowNum
	 * @param cellNum
	 * @return VALUE
	 * @throws Exception
	 */
public String readDataFromExcel(String sheetName,int rowNum,int cellNum) throws Exception
{
	FileInputStream fise=new FileInputStream(".\\src\\test\\resources\\TestData.xlsx");
	Workbook wb=WorkbookFactory.create(fise);
	Sheet sh=wb.getSheet(sheetName);
	String VALUE=sh.getRow(rowNum).getCell(cellNum).getStringCellValue();
	return VALUE;
}
}
