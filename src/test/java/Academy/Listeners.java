package Academy;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

import resources.base;
import resources.extentReportNG;

public class Listeners extends base implements ITestListener
{
	ExtentTest test;
	ExtentReports extent= extentReportNG.getReportObject();
	
	

	@Override
	public void onTestStart(ITestResult result) 
	{
    
    test=extent.createTest(result.getMethod().getMethodName());
    
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
		ITestListener.super.onTestSuccess(result);
	}


	@Override
	public void onTestFailure(ITestResult result) 
	{
		test.fail(result.getThrowable());
		WebDriver driver=null;
		String testmethodName=result.getMethod().getMethodName();
		
		try 
		{
			driver=(WebDriver)result.getTestClass().getRealClass().getDeclaredField("driver").get(result.getInstance());
		} 
		catch (Exception e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		getScreenshotPath(testmethodName, driver);
		
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		ITestListener.super.onTestSkipped(result);
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		ITestListener.super.onTestFailedButWithinSuccessPercentage(result);
	}

	@Override
	public void onTestFailedWithTimeout(ITestResult result) {
		// TODO Auto-generated method stub
		ITestListener.super.onTestFailedWithTimeout(result);
	}

	@Override
	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		ITestListener.super.onStart(context);
	}

	@Override
	public void onFinish(ITestContext context) 
	{
		extent.flush();
		
	}

}
