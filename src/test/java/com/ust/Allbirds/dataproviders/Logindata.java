package com.ust.Allbirds.dataproviders;

import org.testng.annotations.DataProvider;

import com.ust.Allbirds.utilities.ExcelReader;

public class Logindata {
	@DataProvider(name = "validLogindetails")
	public String[][] getValidData() throws Exception {
		String path = System.getProperty("user.dir") + "/src/test/resources/datasource/TestData.xlsx";
		String sheetName = "validlogin";
		// Reading data from excel
		return ExcelReader.getExcelData(path, sheetName);

	}

	@DataProvider(name = "invalidLogindetails")
	public String[][] getInvalidData() throws Exception {
		String path = System.getProperty("user.dir") + "/src/test/resources/datasource/TestData.xlsx";
		String sheetName = "invalidlogin";
		// Reading data from excel
		return ExcelReader.getExcelData(path, sheetName);

	}
}
