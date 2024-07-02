package com.ust.Allbirds.dataproviders;

import org.testng.annotations.DataProvider;

import com.ust.Allbirds.utilities.ExcelReader;

public class ShippingData {
	@DataProvider(name = "validshipping")
	public String[][] getValidData() throws Exception {
		String path = System.getProperty("user.dir") + "\\src\\test\\resources\\datasource\\TestData.xlsx";
		String sheetName = "validshipping";
		// Reading data from excel
		return ExcelReader.getExcelData(path, sheetName);

	}

	@DataProvider(name = "invalidshipping")
	public String[][] getInvalidData() throws Exception {
		String path = System.getProperty("user.dir") + "\\src\\test\\resources\\datasource\\TestData.xlsx";
		String sheetName = "invalidshipping";
		// Reading data from excel
		return ExcelReader.getExcelData(path, sheetName);

	}
}