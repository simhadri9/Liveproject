package demo;

import java.io.FileInputStream;
import java.io.FileOutputStream;

import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class fail_color_to_cell {

	public static void main(String[] args)throws Throwable {
		FileInputStream fi = new FileInputStream("M:/second.xlsx");
		Workbook wb = WorkbookFactory.create(fi);
		Sheet ws = wb.getSheet("Cars");
		int rc = ws.getLastRowNum();
		System.out.println(rc);
		for(int i=1;i<=rc;i++)
		{
			ws.getRow(i).createCell(4).setCellValue("fail");
			CellStyle style = wb.createCellStyle();
			Font font = wb.createFont();
			font.setColor(IndexedColors.RED.getIndex());
			font.setBold(true);
			style.setFont(font);
			ws.getRow(i).getCell(4).setCellStyle(style);
		}
		fi.close();
		FileOutputStream fo = new FileOutputStream("M:/result.xlsx");
		wb.write(fo);
		fo.close();
		wb.close();

	}

}
