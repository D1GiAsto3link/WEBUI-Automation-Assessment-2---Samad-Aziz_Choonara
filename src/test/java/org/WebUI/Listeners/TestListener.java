package org.WebUI.Listeners;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import org.Magneto.utils.ExtentManager;
import org.Magneto.utils.ScreenshotUtils;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class TestListener implements ITestListener {
    private ExtentReports extentReports = ExtentManager.getInstance();
    private ThreadLocal<ExtentTest> extentTestThreadLocal = new ThreadLocal<>();

    @Override
    public void onStart(ITestContext context) {
        // Setup extent reports and other configurations
    }

    @Override
    public void onTestStart(ITestResult result) {
        // Create extent test for each test case
        ExtentTest extentTest = extentReports.createTest(result.getMethod().getMethodName());
        extentTestThreadLocal.set(extentTest);
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        // Log test success and other relevant actions
        extentTestThreadLocal.get().pass("Test Passed");
    }

    @Override
    public void onTestFailure(ITestResult result) {
        // Log test failure and other relevant actions
        extentTestThreadLocal.get().fail(result.getThrowable(),
                MediaEntityBuilder.createScreenCaptureFromBase64String(getScreenshot()).build());
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        // Log test skipped and other relevant actions
        extentTestThreadLocal.get().skip(result.getThrowable());
    }

    @Override
    public void onFinish(ITestContext context) {
        // Flush extent reports and close any open resources
        extentReports.flush();
    }

    private String getScreenshot() {
        try {
            WebDriver driver = BaseTest.getDriver(); // Replace BaseTest with your actual base test class
            return ScreenshotUtils.captureScreenshot(driver);
        } catch (Exception e) {
            System.out.println("Failed to capture screenshot: " + e.getMessage());
            return "";
        }
    }
}
