package com.ust.Allbirds.utilities;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelReader {
	public static String[][] getExcelData(String path, String sheetName) throws IOException {
		FileInputStream fis = new FileInputStream(path);
		try (XSSFWorkbook workbook = new XSSFWorkbook(fis)) {
			XSSFSheet sheet = workbook.getSheet(sheetName);
			int rowCount = sheet.getPhysicalNumberOfRows();
			int cellCount = sheet.getRow(0).getPhysicalNumberOfCells();
			String[][] data = new String[rowCount][cellCount];
			DataFormatter df = new DataFormatter();
			for (int i = 0; i < rowCount; i++) {
				for (int j = 0; j < cellCount; j++) {
					data[i][j] = df.formatCellValue(sheet.getRow(i).getCell(j));
				}
			}
			return data;
		}
	}
}
