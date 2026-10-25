package tests;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import base.BaseTest;
import listeners.RetryListener;
import listeners.TestListener;
import pages.AdminPage;
import pages.DashboardPage;
import pages.LoginPage;

import org.apache.logging.log4j.Logger;

import utils.DataProviderUtils;
import utils.LoggerUtility;

@Listeners({
        TestListener.class,
        RetryListener.class
})
public class AdminTest extends BaseTest {

    private static final Logger log =
            LoggerUtility.getLogger(AdminTest.class);

    @Test(dataProvider = "loginData", dataProviderClass = DataProviderUtils.class)
    public void verifyAdminPageNavigation(String username, String password) {
        log.info("Admin Navigation Test Started");

        LoginPage loginPage = new LoginPage(driver);

        DashboardPage dashboardPage = loginPage.login(username, password);

        Assert.assertTrue(dashboardPage.isDashboardDisplayed(), "Dashboard is not displayed after login");
        log.info("Navigating to Admin Page");

        AdminPage adminPage = dashboardPage.getLeftMenu().goToAdminPage();

        Assert.assertTrue(adminPage.isAdminPageDisplayed(), "Admin page is not displayed");

        log.info("Admin Navigation Test Completed Successfully");
    }
}