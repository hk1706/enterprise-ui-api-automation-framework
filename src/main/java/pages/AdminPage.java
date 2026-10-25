package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import utils.CommonActions;

public class AdminPage extends BasePage {

    // Locators
    private By adminHeader = By.xpath("//h6[text()='Admin']");

    // Constructor
    public AdminPage(WebDriver driver) {
        super(driver);
    }

    // Page Verification Method
    public boolean isAdminPageDisplayed() {
        return CommonActions.isDisplayed(driver, adminHeader);
    }
}