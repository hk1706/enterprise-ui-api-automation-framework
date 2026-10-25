package components;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import pages.AdminPage;
import utils.CommonActions;

public class LeftMenuComponent {

    private WebDriver driver;

    // Locators
    private By adminMenu = By.xpath("//span[text()='Admin']");

    // Constructor
    public LeftMenuComponent(WebDriver driver) {
        this.driver = driver;
    }

    // Navigation Method - returns next page (Navigation Chaining)
    public AdminPage goToAdminPage() {
        CommonActions.click(driver, adminMenu);
        return new AdminPage(driver);
    }
}