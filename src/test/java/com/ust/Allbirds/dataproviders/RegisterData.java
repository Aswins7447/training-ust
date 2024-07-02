package com.ust.Allbirds.dataproviders;

import org.testng.annotations.DataProvider;

import com.ust.Allbirds.utilities.ExcelReader;

public class RegisterData {
	@DataProvider(name = "invalidRegisterdetails")
	public String[][] getInvalidData() throws Exception {
		String path = System.getProperty("user.dir") + "/src/test/resources/datasource/TestData.xlsx";
		String sheetName = "invalidRegdata";
		// Reading data from excel
		return ExcelReader.getExcelData(path, sheetName);

	}

	@DataProvider(name = "validRegisterdetails")
	public String[][] getValidData() throws Exception {
		String path = System.getProperty("user.dir") + "/src/test/resources/datasource/TestData.xlsx";
		String sheetName = "validRegdata";
		// Reading data from excel
		return ExcelReader.getExcelData(path, sheetName);

	}
}
