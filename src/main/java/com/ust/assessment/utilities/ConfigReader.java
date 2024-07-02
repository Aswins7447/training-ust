package com.ust.assessment.utilities;

import java.io.FileReader;
import java.util.Properties;

public class ConfigReader {
	
	private static Properties prop;
	private static FileReader file;
	
	public static String PATH = System.getProperty("user.dir") + "/src/test/resources/Configuration/config.properties";
	
	public static Properties getPropertyValue() {
		
		if(prop == null) {
			prop = new Properties();
		} 
		
		try {
			file = new FileReader(PATH);
			prop.load(file);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return prop;
	}

}
