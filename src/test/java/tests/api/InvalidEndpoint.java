package tests.api;

import org.testng.annotations.Test;

import api.client.ApiClient;
import api.endpoints.ApiEndpoints;
import io.restassured.response.Response;
import org.testng.Assert;

public class InvalidEndpoint {
    
    @Test
    public void invalidEndpointTest() {

        ApiClient apiClient = new ApiClient();

        Response response =
                apiClient.get(
                        ApiEndpoints.BASE_URL,
                        "/api/invalidEndpoint");

        Assert.assertEquals(
                response.statusCode(),
                404);
    }

}
