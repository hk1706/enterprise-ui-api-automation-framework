package utils;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentManager {

    private static ExtentReports extent;

    public static ExtentReports getInstance() {
        
        if (extent == null) {
            ExtentSparkReporter spark = 
                new ExtentSparkReporter("reports/ExtentReport.html");
            
            spark.config().setReportName("Selenium Framework Report");
            spark.config().setDocumentTitle("Automation Test Results");
            
            extent = new ExtentReports();
            
            extent.attachReporter(spark);
            extent.setSystemInfo("Tester", "Himanshu");
            extent.setSystemInfo("Environment", "QA");
            extent.setSystemInfo("Framework", "Selenium + TestNG");
        }
        
        return extent;
    }
}