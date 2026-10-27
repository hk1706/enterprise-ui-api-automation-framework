package tests.api;

import org.testng.annotations.Test;
import org.testng.Assert;
import api.managers.TokenManager;

public class AuthenticatedFlowTest {
    
    @Test
    public void authenticatedFlowTest() {

        LoginApiTest loginApiTest =
                new LoginApiTest();

        loginApiTest.loginTest();

        Assert.assertNotNull(
                TokenManager.getToken());

        System.out.println(
                "Stored Token : "
                        + TokenManager.getToken());
    }

}
