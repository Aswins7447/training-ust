package com.ust.assessment.utilities;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelReader {
	
	public static String[][] readExcel(String path, String sheetname) throws IOException
	{
		FileInputStream fi = new FileInputStream(path);
		@SuppressWarnings("resource")
		XSSFWorkbook workbook = new XSSFWorkbook(fi);
		XSSFSheet sheet = workbook.getSheet(sheetname);
		int rowcount = sheet.getPhysicalNumberOfRows();
		int columncount = sheet.getRow(0).getPhysicalNumberOfCells();
		
		String[][] data = new String[rowcount][columncount];
		DataFormatter df = new DataFormatter();
		for(int i = 0; i < rowcount; i++)
		{
			for(int j = 0; j < columncount; j++)
			{
				data[i][j] = df.formatCellValue(sheet.getRow(i).getCell(j));
			}
		}
		return data;
	}
}
