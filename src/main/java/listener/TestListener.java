package listener;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import core.TestCore;
import utils.CommonFunctions;

public class TestListener extends TestCore implements ITestListener {
	
	@Override
	public void onStart(ITestContext iTest) {
		logger.info("Test Started*************************" + iTest.getName());
	}

	@Override
	public void onFinish(ITestContext iTest) {
		logger.info("Test Finished*************** " + iTest.getName());
	}

	@Override
	public void onTestFailure(ITestResult iTest) {
		// TODO Auto-generated method stub
		logger.info("Test Failed************ " + iTest.getName());
		try {
			CommonFunctions.captureScreenshot(iTest.getTestClass().getName() + "_" + iTest.getName() + ".jpg");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void onTestSkipped(ITestResult arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onTestStart(ITestResult arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onTestSuccess(ITestResult iTest) {
		// TODO Auto-generated method stub
		logger.info("Test Success************ " + iTest.getName());
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		
	}
}
