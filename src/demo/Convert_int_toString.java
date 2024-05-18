package demo;

import java.io.FileInputStream;
import java.io.FileOutputStream;

import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class Convert_int_toString {

	public static void main(String[] args) throws Throwable {
		FileInputStream fi = new FileInputStream("M:/first.xlsx");
		Workbook wb= WorkbookFactory.create(fi);
		Sheet ws = wb.getSheet("EMP");
		int rc = ws.getLastRowNum();
		System.out.println(rc);
		for(int i=1;i<=rc;i++)
		{
			if(ws.getRow(i).getCell(3).getCellType()==CellType.NUMERIC)
			{
				int cc = (int)ws.getRow(i).getCell(3).getNumericCellValue();
				String eid = String.valueOf(cc);
				System.out.println(eid);
				ws.getRow(i).createCell(4).setCellValue("i am lazy to work");
			}
		}
		fi.close();
		FileOutputStream fo = new FileOutputStream("M:/result.xlsx");
		wb.write(fo);
		fo.close();
		wb.close();

	}

}
