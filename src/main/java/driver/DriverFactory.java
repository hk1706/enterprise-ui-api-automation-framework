package driver;

import java.net.URL;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

import utils.ConfigReader;

public class DriverFactory {

    private static final String GRID_URL = "http://localhost:4444";

    private static ThreadLocal<WebDriver> driver = new ThreadLocal<>();

    public static WebDriver getDriver(String browser) {

        String executionMode = ConfigReader.getConfigProperty("executionMode");

        if (driver.get() == null) {

            try {
                if (browser.equalsIgnoreCase("chrome")) {

                    if (executionMode.equalsIgnoreCase("grid")) {
                        ChromeOptions options = new ChromeOptions();
                        driver.set(new RemoteWebDriver(new URL(GRID_URL), options));
                    } else {
                        driver.set(new ChromeDriver());
                    }

                } else if (browser.equalsIgnoreCase("edge")) {

                    if (executionMode.equalsIgnoreCase("grid")) {
                        EdgeOptions options = new EdgeOptions();
                        driver.set(new RemoteWebDriver(new URL(GRID_URL), options));
                    } else {
                        driver.set(new EdgeDriver());
                    }

                } else {
                    throw new RuntimeException("Browser not supported: " + browser);
                }

            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }

        return driver.get();
    }

    public static WebDriver getDriver() {
        return driver.get();
    }

    public static void quitDriver() {
        if (driver.get() != null) {
            driver.get().quit();
            driver.remove();
        }
    }
}