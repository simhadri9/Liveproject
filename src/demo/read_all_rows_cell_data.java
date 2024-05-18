package demo;

import java.io.FileInputStream;
import java.io.FileOutputStream;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class read_all_rows_cell_data {

	public static void main(String[] args) throws Throwable {
		//read all row cell data and write data into cell
		
		FileInputStream fi = new FileInputStream("M:/first.xlsx");
		XSSFWorkbook wb = new XSSFWorkbook(fi);
		XSSFSheet ws = wb.getSheet("EMP");
		int rc = ws.getLastRowNum();
		System.out.println(rc);
		//print all rows cell data
		for(int i=1;i<=rc;i++)
		{
			String fname = ws.getRow(i).getCell(0).getStringCellValue();
			String mname = ws.getRow(i).getCell(1).getStringCellValue();
			String lname = ws.getRow(i).getCell(2).getStringCellValue();
			int eid =(int)ws.getRow(i).getCell(3).getNumericCellValue();
			System.out.println(fname+"  "+mname+"  "+lname+"  "+eid);
			ws.getRow(i).createCell(4).setCellValue("pass");
			
		}
		fi.close();
		FileOutputStream fo = new FileOutputStream("M:/result.xlsx");
		wb.write(fo);
		fo.close();
		wb.close();

	}

}
