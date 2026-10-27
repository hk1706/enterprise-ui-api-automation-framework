package tests.api;


import api.services.AuthService;
import base.BaseApiTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginApiTest extends BaseApiTest {

    @Test
        public void loginTest() {

        String token = AuthService.getToken();
        String token1 = AuthService.getToken();
        String token2 = AuthService.getToken();

        Assert.assertNotNull(token);

        System.out.println("Token : " + token);
        
        Assert.assertEquals(token1, token2);
        }
}
