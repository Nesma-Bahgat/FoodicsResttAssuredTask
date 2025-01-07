package restassured.Listeners;

import org.testng.ITestListener;
import org.testng.ITestResult;

public class TestListener implements ITestListener {

    @Override
    public void onTestFailure(ITestResult result) {
        Throwable exception = result.getThrowable();    
        System.err.println("Exception occurred: " + exception.getMessage());
    }
}