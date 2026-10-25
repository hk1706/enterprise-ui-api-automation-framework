package utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CommonActions {

    public static void enterText(WebDriver driver, By locator, String text) {
        WaitUtils.waitForVisibility(driver, locator, 10).sendKeys(text);
    }

    public static void click(WebDriver driver, By locator) {
        WaitUtils.waitForClickable(driver, locator, 10).click();
    }

    public static String getText(WebDriver driver, By locator) {
        return WaitUtils.waitForVisibility(driver, locator, 10).getText();
    }

    public static boolean isDisplayed(WebDriver driver, By locator) {
        return WaitUtils.waitForVisibility(driver, locator, 10).isDisplayed();
    }

    public static void clearText(WebDriver driver, By locator) {
        WaitUtils.waitForVisibility(driver, locator, 10).clear();
    }
}