package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import utils.CommonActions;

public class LoginPage extends BasePage {

    // Locators
    private By usernameTxt = By.name("username");
    private By passwordTxt = By.name("password");
    private By loginBtn = By.xpath("//button[@type='submit']");
    private By dashboardHeader = By.xpath("//h6[text()='Dashboard']");

    // Constructor
    public LoginPage(WebDriver driver) {
        super(driver);
    }

    // Login Method with Navigation Chaining
    public DashboardPage login(String username, String password) {
        CommonActions.enterText(driver, usernameTxt, username);
        CommonActions.enterText(driver, passwordTxt, password);
        CommonActions.click(driver, loginBtn);
        return new DashboardPage(driver);
    }

    public boolean isDashboardDisplayed() {
        return CommonActions.isDisplayed(driver, dashboardHeader);
    }
}