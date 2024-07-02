package com.ust.assessment.dataprovider;

import java.io.IOException;

import org.testng.annotations.DataProvider;

import com.ust.assessment.utilities.ExcelReader;



public class DataProviderUtility {
	  ExcelReader reader;

	  @DataProvider(name = "datas")
	  public Object[][] dp() throws IOException {
		 String  path = System.getProperty("user.dir")+"/datasource/TestDataSet.xlsx";
		  //String  path = "C:\\Users\\271462\\eclipse-workspace\\seleniumcucumber\\simpleproject\\datasource\\data.xlsx";
		  String sheetname = "data";
		  
	    return ExcelReader.readExcel(path, sheetname);
	      
	  
	  }
	  
}
