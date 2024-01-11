package util;

import java.util.Date;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class MyExtentReports {

	public static ExtentReports getExtentReport() {
		
		Date currentdate = new Date();

		String extentreportdate = currentdate.toString().replace(" ", "-").replace(":", "-");
		
		
		String extentReportFilePath= System.getProperty("user.dir")+"\\reports\\extentreport"+extentreportdate+".html";
		
		ExtentSparkReporter sparkReporter= new ExtentSparkReporter(extentReportFilePath);
		
		sparkReporter.config().setReportName("Cloud Test Automation Result");
		sparkReporter.config().setDocumentTitle("Cloud Test Report");
		
		ExtentReports extentReports = new ExtentReports();
		extentReports.attachReporter(sparkReporter);
		extentReports.setSystemInfo("Selenium Version", "4.4.0");
		extentReports.setSystemInfo("Operating System", "Windows");
		extentReports.setSystemInfo("Executed by", "Sumit Koli");
		
		return extentReports;
		
	}
}
