package tests.api;

import org.testng.annotations.Test;
import api.client.ApiClient;
import api.endpoints.ApiEndpoints;
import io.restassured.response.Response;
import utils.ConfigReader;


public class LocalUserGetApiTest {
    
    @Test
    public void getUsers(){
        
        ApiClient apiClient = new ApiClient();

        Response response = apiClient.get(
            ConfigReader.getProperty("baseApiUrl"), 
            ApiEndpoints.USERS);

        response.then().statusCode(200);

        System.out.println(response.asPrettyString());
    }
}
