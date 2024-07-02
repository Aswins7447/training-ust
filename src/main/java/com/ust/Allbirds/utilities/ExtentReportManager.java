package com.ust.Allbirds.utilities;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.ust.Allbirds.base.ReusableFunctions;

public class ExtentReportManager {
	public static ExtentReports extent;
	public static ExtentSparkReporter htmlReporter;

	public static ExtentReports createInstance() {
		try {
			String repname = "TestReport-" + ReusableFunctions.getTimeStamp() + ".html";
			htmlReporter = new ExtentSparkReporter(System.getProperty("user.dir") + "//Reports//" + repname);

			htmlReporter.config().setDocumentTitle("Extent Reports");
			htmlReporter.config().setReportName("Test Reports");
			htmlReporter.config().setTimelineEnabled(true);
			htmlReporter.config().setTheme(Theme.DARK);
			htmlReporter.config().setTimeStampFormat("MM/dd/yyyy HH:mm:ss");

			extent = new ExtentReports();
			extent.attachReporter(htmlReporter);
			extent.setSystemInfo("OS", "Windows");
			extent.setSystemInfo("Host Name", "localhost");
			extent.setSystemInfo("Environment", "QA");
			extent.setSystemInfo("Username", "Anjali, Aswin, Anna");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return extent;
	}
}
