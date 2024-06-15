package GenericUtilities;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class ListenersImplementation implements ITestListener {

	
	public void onTestStart(ITestResult result) {
	String methodName=result.getMethod().getMethodName();	
	System.out.println("----test script execution started---");
	}

	
	public void onTestSuccess(ITestResult result) {
		String methodName=result.getMethod().getMethodName();	
		System.out.println("----test script is passed---");
	}

	
	public void onTestFailure(ITestResult result) {
		String methodName=result.getMethod().getMethodName();
		System.out.println("---test script is falied----");
	}

	
	public void onTestSkipped(ITestResult result) {
		String methodName=result.getMethod().getMethodName();
		System.out.println("----test script is failed----");
	}

	
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		
	}

	
	public void onTestFailedWithTimeout(ITestResult result) {
		
	}

	
	public void onStart(ITestContext context) {
		System.out.println("-----suite execution started----");
	}

    public void onFinish(ITestContext context) {
		System.out.println("-----suite execution finished-----");
	}

}
