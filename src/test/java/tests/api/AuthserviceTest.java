package tests.api;

import org.testng.annotations.Test;
import org.testng.Assert;
import api.services.AuthService;

public class AuthserviceTest {
    
    @Test
    public void authServiceTest() {

        String token = AuthService.getToken();

        Assert.assertNotNull(token);

        System.out.println(token);
    }

}
