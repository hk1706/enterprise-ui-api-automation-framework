package tests;

import listeners.RetryListener;
import org.testng.annotations.Test;
import org.testng.annotations.Listeners;
import listeners.TestListener;
import org.testng.Assert;
import base.BaseTest;
import pages.LoginPage;
import utils.RandomDataUtils;
import org.apache.logging.log4j.Logger;
import utils.LoggerUtility;
import utils.DataProviderUtils;

@Listeners({
    TestListener.class,
    RetryListener.class
})
public class LoginTest extends BaseTest {

    private static final Logger log = LoggerUtility.getLogger(LoginTest.class);

    @Test(dataProvider = "loginData", dataProviderClass = DataProviderUtils.class)
    public void verifyLogin(String username, String password) {
        
        log.info("Login Test Started");
        
        LoginPage loginPage = new LoginPage(driver);
        
        log.info("Generating Random Test Data");
        
        System.out.println("Random Email : " + RandomDataUtils.getRandomEmail());
        System.out.println("Random Mobile Number : " + RandomDataUtils.getRandomMobileNumber());
        System.out.println("Random Username : " + RandomDataUtils.getRandomUsername());
        
        log.info("Performing login operation");
        log.info("Username Used : " + username);
        
        loginPage.login(username, password);
        
        Assert.assertTrue(loginPage.isDashboardDisplayed(), "Dashboard is not displayed after login");
        log.info("Login Completed Successfully");
        
        
        // try {
        //     Thread.sleep(10000);
        // } catch (InterruptedException e) {
        //     e.printStackTrace();
        // }
        // Assert.fail("Intentional failure for testing screenshot capture");
        
    }

    
    // @Test(retryAnalyzer = listeners.RetryAnalyzer.class)
    // public void failTest() {
    //     try {
    //         Thread.sleep(10000);
    //     } catch (InterruptedException e) {
    //         e.printStackTrace();
    //     }
    //     Assert.fail("Intentional Failure");
    // }
    
}