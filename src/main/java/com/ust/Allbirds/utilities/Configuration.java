package com.ust.Allbirds.utilities;

import java.io.FileInputStream;
import java.util.Properties;

public class Configuration {
	private static Properties prop;

	public static Properties initProperties() {
		if (prop == null) {
			prop = new Properties();
			String path = System.getProperty("user.dir") + "\\src\\test\\resources\\config\\Config.properties";
			System.out.println(path);
			try (FileInputStream fis = new FileInputStream(path)) {
				prop.load(fis);
			} catch (Exception e) {
				e.printStackTrace();
			}
			;
		}
		return prop;
	}
}
