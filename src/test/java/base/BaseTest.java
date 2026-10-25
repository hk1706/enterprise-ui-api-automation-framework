package base;

import org.openqa.selenium.WebDriver;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import driver.DriverFactory;
import utils.ConfigReader;

import org.apache.logging.log4j.Logger;
import utils.LoggerUtility;

public class BaseTest {

    protected WebDriver driver;

    private static final Logger log = LoggerUtility.getLogger(BaseTest.class);

    @BeforeMethod
    public void setup() throws InterruptedException {
        
        log.info("===== Test Setup Started =====");
        driver = DriverFactory.getDriver(ConfigReader.getProperty("browser"));
        driver.manage().window().maximize();
        
        driver.get(ConfigReader.getProperty("url"));
        log.info("===== Test Setup Completed =====");
        log.info("Browser : " + ConfigReader.getProperty("browser"));
        log.info("URL : " + ConfigReader.getProperty("url"));
        log.info("Page Title : " + driver.getTitle());
        log.info("Current URL : " + driver.getCurrentUrl());
    }

    @AfterMethod
    public void tearDown() {
        log.info("===== Browser Closing =====");
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        DriverFactory.quitDriver();
        log.info("Driver Quit Successfully");
    }
}