package tests.api;

import org.testng.annotations.Test;

import api.client.ApiClient;
import api.endpoints.ApiEndpoints;
import api.models.LoginRequest;
import io.restassured.response.*;
import org.testng.Assert;

public class LoginWithoutPassword {
    
    @Test
    public void loginWithoutPasswordTest() {

        ApiClient apiClient = new ApiClient();

        LoginRequest request = new LoginRequest();

        request.setEmail("eve.holt@reqres.in");
        // password intentionally omitted

        Response response =
                apiClient.post(
                        ApiEndpoints.BASE_URL,
                        ApiEndpoints.LOGIN,
                        request);

        Assert.assertEquals(
                response.statusCode(),
                400);

        Assert.assertEquals(
                response.jsonPath()
                        .getString("error"),
                "Missing password");
    }

}
