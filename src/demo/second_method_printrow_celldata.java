package demo;

import java.io.FileInputStream;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class second_method_printrow_celldata {

	public static void main(String[] args) throws Throwable{
	FileInputStream fi = new FileInputStream("M:/second.xlsx");
	XSSFWorkbook wb = new XSSFWorkbook(fi);
	XSSFSheet ws = wb.getSheet("Cars");
	int cr = ws.getLastRowNum();
	System.out.println(cr);
	String fname = ws.getRow(3).getCell(0).getStringCellValue();
	String mname = ws.getRow(10).getCell(1).getStringCellValue();
	String lname = ws.getRow(5).getCell(2).getStringCellValue();
	int eid = (int)ws.getRow(12).getCell(3).getNumericCellValue();
	System.out.println(fname+" "+mname+"  "+lname+"  "+eid);
	fi.close();
	wb.close();
	

	}

}
