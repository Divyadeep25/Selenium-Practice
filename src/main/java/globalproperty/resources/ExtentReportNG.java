package globalproperty.resources;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReportNG {

	
	public static ExtentReports getReports() {
		String path = System.getProperty("user.dir") + "/report/index.html";
		ExtentSparkReporter report = new ExtentSparkReporter(path);
		report.config().setReportName("search google report");
		report.config().setDocumentTitle("Google Search Test");
		
		ExtentReports extent=new ExtentReports();
		extent.attachReporter(report);
		extent.setSystemInfo("Test", "First Extent Report");
		return extent;
	}
}
