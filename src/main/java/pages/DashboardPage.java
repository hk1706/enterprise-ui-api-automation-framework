package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import components.LeftMenuComponent;
import utils.CommonActions;

public class DashboardPage extends BasePage {

    // Locators
    private By dashboardHeader = By.xpath("//h6[text()='Dashboard']");

    // Component
    private LeftMenuComponent leftMenu;

    // Constructor
    public DashboardPage(WebDriver driver) {
        super(driver);
        leftMenu = new LeftMenuComponent(driver);
    }

    // Getter for Left Menu Component
    public LeftMenuComponent getLeftMenu() {
        return leftMenu;
    }

    // Page Verification Method
    public boolean isDashboardDisplayed() {
        return CommonActions.isDisplayed(driver, dashboardHeader);
    }
}