package dataDrivenTesting;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class FetchExcelData {

	public static void main(String[] args) throws EncryptedDocumentException, IOException {
		//Convert physical representation of excel sheet into java representation
		FileInputStream fis = new FileInputStream("D:\\demoApps\\src\\test\\resources\\testData\\ExcelData.xlsx");
		
		//Get the access of the workbook
		Workbook workbook = WorkbookFactory.create(fis);
		
		//Get the access if the sheet 
		Sheet sheet = workbook.getSheet("Sheet1");
		
		//Get the access if the row
		Row row = sheet.getRow(1);
		
		//Get the access if the cell
		Cell cell = row.getCell(2);
		
		//Fetch string Data
		String password = cell.getStringCellValue();
		
		System.out.println(password);
		//Fetching long data
		long phoneNo = (long)row.getCell(3).getNumericCellValue();
		
		System.out.println(phoneNo);
		//Fetching boolean data
		boolean status = row.getCell(4).getBooleanCellValue();
		
		System.out.println(status);
	}

}
