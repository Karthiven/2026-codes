package karthiks.testcomponents;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import karthiks.resources.ExtentReporter;

public class Listeners extends Basetest implements ITestListener{
	
	ExtentTest test;
	ExtentReports extent= ExtentReporter.getExtendReporter();
	
	ThreadLocal<ExtentTest> extenttest = new ThreadLocal<ExtentTest>();
	
	

	@Override
	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub
	
		
		test=extent.createTest(result.getMethod().getMethodName());
		extenttest.set(test);
		
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
		
		
		
		extenttest.get().log(Status.PASS, "Test Passed");
	}

	@Override
	public void onTestFailure(ITestResult result) {
		
		// TODO Auto-generated method stub
		
	//	test.log(Status.FAIL, "Test Failed");
		extenttest.get().fail(result.getThrowable());
		
		
		
		try {
			driver= (WebDriver) result.getTestClass().getRealClass().getField("driver").get(result.getInstance());
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		
		
		
		String filepath = null;
		
		try {
			 filepath=getScreenshot(result.getMethod().getMethodName(), driver);
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		
		extenttest.get().addScreenCaptureFromPath(filepath, result.getMethod().getMethodName());
		
		
	}

	@Override
	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		extent.flush();
	
	}
	
	

}
