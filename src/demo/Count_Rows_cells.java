package demo;

import java.io.FileInputStream;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Count_Rows_cells {

	public static void main(String[] args) throws Throwable {
		//count rows and cols
		FileInputStream fi = new FileInputStream("M:/first.xlsx");
		//get workbook from file
		XSSFWorkbook wb = new XSSFWorkbook(fi);
		//get sheet from workbook
		XSSFSheet ws = wb.getSheet("EMP");
		//get first row from sheet
		XSSFRow row = ws.getRow(0);
		//count no of rows in sheet
		int rc = ws.getLastRowNum();
		//count no of cells in first row
		int cc = row.getLastCellNum();
		System.out.println("No of rows are"+rc+"  "+"No of cells"+cc);
		fi.close();
		wb.close();

		

	}

}
