package tests.api;

import org.testng.annotations.Test;

import api.client.ApiClient;
import api.endpoints.ApiEndpoints;
import io.restassured.response.Response;
import utils.ConfigReader;

public class LocalUserDeleteApiTest {
    
    @Test 
    public void deleteAndVerify() {

        ApiClient apiClient = new ApiClient();
        int id = 4;

        Response response = apiClient.delete(ConfigReader.getProperty("baseApiUrl"), ApiEndpoints.USER_BY_ID + id);

        response.then().statusCode(200);

        response = apiClient.get(ConfigReader.getProperty("baseApiUrl"), ApiEndpoints.USER_BY_ID + id);

        response.then().statusCode(404);

    }

}
