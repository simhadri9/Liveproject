package demo;

import java.io.FileInputStream;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class read_rowof_cell_data {

	public static void main(String[] args)throws Throwable {
		FileInputStream fi = new FileInputStream("M:/first.xlsx");
		XSSFWorkbook wb = new XSSFWorkbook(fi);
		XSSFSheet ws = wb.getSheet("EMP");
		int rc = ws.getLastRowNum();
		System.out.println("no of rows::"+"  "+rc);
		XSSFRow row = ws.getRow(7);
	    XSSFCell c1 = row.getCell(0);
	    XSSFCell c2 = row.getCell(1);
	    XSSFCell c3 = row.getCell(2);
	    XSSFCell c4 = row.getCell(3);
	    String fname = c1.getStringCellValue();
	    String mname = c2.getStringCellValue();
	    String lname = c3.getStringCellValue();
	    int eid =(int)c4.getNumericCellValue();
	    System.out.println(fname+"  "+mname+" "+lname+" "+eid);
	    wb.close();
	    fi.close();
		

	}

}
