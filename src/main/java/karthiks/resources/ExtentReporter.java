package karthiks.resources;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReporter {
	
	public static ExtentReports getExtendReporter()
	{
	
	
	String path= System.getProperty("user.dir")+"\\Reports\\index.html";
	ExtentSparkReporter reporter= new ExtentSparkReporter(path);
	reporter.config().setReportName("My result");
	reporter.config().setDocumentTitle("Test Result");
	
	ExtentReports extent=new ExtentReports();
	extent.attachReporter(reporter);
	extent.setSystemInfo("Testerinfo", "Karthik");
	return extent;
	

}
}
