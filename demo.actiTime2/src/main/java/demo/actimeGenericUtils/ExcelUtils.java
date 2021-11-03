package demo.actimeGenericUtils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
/**
 * this class consist of methods to fetch the data from excel sheet
 * @author LENOVO
 *
 */
public class ExcelUtils {
	/**
	 * This method will return only the string data from the excel sheet
	 * @param filePath
	 * @param sheetName
	 * @param rowNo
	 * @param columnNo
	 * @return
	 */

	public String getStringData(String filePath, String sheetName, int rowNo, int columnNo) {
		//create a object for fileinputstream to pass the physical excel file path
		FileInputStream file;
		try {
			file = new FileInputStream(filePath);
			//create a workbook object by calling creatge method of workbook factory class
			Workbook workbook = WorkbookFactory.create(file);
			//using workbook object reference call sheet, row, and cell methods of apache poi to get the data 
			return workbook.getSheet(sheetName).getRow(rowNo).getCell(columnNo).getStringCellValue();
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
		
	}
	/**
	 * This method will return only the numeric data from the excel sheet
	 * @param filePath
	 * @param sheetName
	 * @param rowNo
	 * @param columnNo
	 * @return
	 */
	public double getNumericData(String filePath, String sheetName, int rowNo, int columnNo) {
		//create a object for fileinputstream to pass the physical excel file path
		FileInputStream file;
		try {
			file = new FileInputStream(filePath);
			//create a workbook object by calling creatge method of workbook factory class
			Workbook workbook = WorkbookFactory.create(file);
			//using workbook object reference call sheet, row, and cell methods of apache poi to get the data 
			return workbook.getSheet(sheetName).getRow(rowNo).getCell(columnNo).getNumericCellValue();
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0.0;
		
		
		
	}
	/**
	 * This method will return all the data in the form of string
	 * @param filePath
	 * @param sheetName
	 * @param rowNo
	 * @param columnNo
	 * @return
	 */
	public String getData(String filePath, String sheetName, int rowNo, int columnNo) {
		//create a object for fileinputstream to pass the physical excel file path
		FileInputStream file;
		try {
			file = new FileInputStream(filePath);
			//create a workbook object by calling creatge method of workbook factory class
			Workbook workbook = WorkbookFactory.create(file);
			//using workbook object reference call sheet, row, and cell methods of apache poi to get the data 
			return workbook.getSheet(sheetName).getRow(rowNo).getCell(columnNo).toString();
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
		
	}
	
	/**
	 * This method will return all the data in the form of string
	 * @param filePath
	 * @param sheetName
	 * @param rowNo
	 * @param columnNo
	 * @return
	 */
	public Boolean getBooleanData(String filePath, String sheetName, int rowNo, int columnNo) {
		//create a object for fileinputstream to pass the physical excel file path
		FileInputStream file;
		try {
			file = new FileInputStream(filePath);
			//create a workbook object by calling creatge method of workbook factory class
			Workbook workbook = WorkbookFactory.create(file);
			//using workbook object reference call sheet, row, and cell methods of apache poi to get the data 
			return workbook.getSheet(sheetName).getRow(rowNo).getCell(columnNo).getBooleanCellValue();
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
		
	}
}	

