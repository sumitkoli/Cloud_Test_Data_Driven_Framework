package listeners;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import Base_Package.Base_Class;
import util.MyExtentReports;

public class MyListeners implements ITestListener {

	WebDriver driver;
	String concatenate = ".";
	ExtentReports extentReports = MyExtentReports.getExtentReport();
	ExtentTest extentTest;
	Base_Class baseClass = new Base_Class();

	@Override
	public void onTestStart(ITestResult result) {
		extentTest = extentReports.createTest(result.getName());
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		extentTest.log(Status.PASS, "Test Passed");
	}

	@Override
	public void onTestFailure(ITestResult result) {

		String path = concatenate + baseClass.capturScreenshot(result.getName());
		extentTest.addScreenCaptureFromPath(path);

		extentTest.log(Status.FAIL, "Test Failed");
		extentTest.fail(result.getThrowable());

	}

	@Override
	public void onTestSkipped(ITestResult result) {
		extentTest.skip(result.getThrowable());
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {

	}

	@Override
	public void onTestFailedWithTimeout(ITestResult result) {

	}

	@Override
	public void onStart(ITestContext context) {
		
	}

	@Override
	public void onFinish(ITestContext context) {
		extentReports.flush();
		
	}

}
