package com.ust.assessment.utilities;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.ust.assessment.base.Setup;



public class ExtentReportManager {

	public static ExtentReports extent;
	public static ExtentSparkReporter htmlReporter;

	public static ExtentReports createInstance() {
		try {
			String repname = "TestReport-" + Setup.getTimeStamp() + ".html";
			htmlReporter = new ExtentSparkReporter(System.getProperty("user.dir") + "//Reports//" + repname);

			htmlReporter.config().setDocumentTitle("Extent Report");
			htmlReporter.config().setReportName("Test Report");
			htmlReporter.config().setTimelineEnabled(true);
			htmlReporter.config().setTheme(Theme.DARK);
			htmlReporter.config().setTimeStampFormat("MM/dd/yyyy HH:mm:ss");

			extent = new ExtentReports();
			extent.attachReporter(htmlReporter);
			extent.setSystemInfo("OS", "Windows");
			extent.setSystemInfo("Host Name", "localhost");
			extent.setSystemInfo("Environment", "QA");
			extent.setSystemInfo("Username", "Aswin");
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return extent;
	}
}
