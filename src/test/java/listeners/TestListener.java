package listeners;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import utils.ExtentManager;

import org.apache.logging.log4j.Logger;
import utils.LoggerUtility;

import driver.DriverFactory;
import utils.ScreenshotUtils;

public class TestListener implements ITestListener {

    private static ExtentReports extent = ExtentManager.getInstance();
    private static ExtentTest test;

    private static final Logger log = LoggerUtility.getLogger(TestListener.class);

    @Override
    public void onTestStart(ITestResult result) {
        log.info("Test Started : " + result.getName());
        test = extent.createTest(result.getName());
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        log.info("Test Passed : " + result.getName());
        test.pass("Test Passed");
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        if (result.getThrowable() != null) {
            log.warn("Retrying Test : " + result.getName());
            test.warning("Retrying Test : " + result.getName());
        } else {
            log.warn("Test Skipped : " + result.getName());
            test.skip("Test Skipped");
        }
    }

    @Override
    public void onTestFailure(ITestResult result) {
        log.error("Test Failed : " + result.getName());
        if (test == null) {
            test = extent.createTest(result.getName());
        }
        test.fail("Test Failed");

        if (DriverFactory.getDriver() != null) {
            String screenshotPath = ScreenshotUtils.captureScreenshot(
                    DriverFactory.getDriver(), result.getName());
            try {
                test.addScreenCaptureFromPath(screenshotPath);
            } catch (Exception e) {
                log.error("Could not attach failure screenshot", e);
            }
        }

        System.out.println("Screenshot captured for: " + result.getName());
    }

    @Override
    public void onFinish(ITestContext context) {
        extent.flush();
    }
}