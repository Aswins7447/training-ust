package com.ust.Allbirds.dataproviders;

import org.testng.annotations.DataProvider;

import com.ust.Allbirds.utilities.ExcelReader;

public class SearchData {
	@DataProvider(name = "validproduct")
	public String[][] getValidData() throws Exception {
		String path = System.getProperty("user.dir") + "/src/test/resources/datasource/TestData.xlsx";
		String sheetName = "validproductsearch";
		// Reading data from excel
		return ExcelReader.getExcelData(path, sheetName);

	}

	@DataProvider(name = "invalidproduct")
	public String[][] getInvalidData() throws Exception {
		String path = System.getProperty("user.dir") + "/src/test/resources/datasource/TestData.xlsx";
		String sheetName = "invalidproductsearch";
		// Reading data from excel
		return ExcelReader.getExcelData(path, sheetName);

	}
}