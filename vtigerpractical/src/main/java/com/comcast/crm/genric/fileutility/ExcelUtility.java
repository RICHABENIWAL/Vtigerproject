package com.comcast.crm.genric.fileutility;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelUtility {
	
	public String getDataFromExcelFile(String sheetname, int row, int cell) throws Throwable, IOException {
		FileInputStream fis = new FileInputStream("./testscriptdata/data.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		
		String data = wb.getSheet(sheetname).getRow(row).getCell(cell).getStringCellValue();
		wb.close();
		return data;	
	}
	
	
	public int getRowCount(String sheetname) throws Throwable, IOException {
		FileInputStream fis = new FileInputStream("./testscriptdata/data.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		int rowcount = wb.getSheet(sheetname).getLastRowNum();
		wb.close();
		return rowcount;	
	}
	
	
	public void writeDataBackToExcel(String sheetname, int rownum, int cellnum) throws Throwable, IOException {
		FileInputStream fis = new FileInputStream("./testscriptdata/data.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
	    wb.getSheet(sheetname).getRow(rownum).createCell(cellnum);
	    
	    FileOutputStream fos = new FileOutputStream("./testscriptdata/data.xlsx");
	    wb.write(fos);
	    wb.close();
	
	}

}
