package tests.api;

import org.testng.annotations.Test;

import api.client.ApiClient;
import api.endpoints.ApiEndpoints;
import org.testng.Assert;
import io.restassured.response.Response;

public class DeleteUserRequest {
    
    @Test
    public void deleteUserTest() {

        ApiClient apiClient = new ApiClient();

        Response response =
                apiClient.delete(
                        ApiEndpoints.BASE_URL,
                        "/api/users/2");

        Assert.assertEquals(
                response.statusCode(),
                204);
    }

}
