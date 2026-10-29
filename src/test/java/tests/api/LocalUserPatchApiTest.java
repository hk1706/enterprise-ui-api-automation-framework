package tests.api;

import org.testng.annotations.Test;

import api.client.ApiClient;
import api.endpoints.ApiEndpoints;
import api.models.LocalUser;
import io.restassured.response.Response;
import utils.ConfigReader;

public class LocalUserPatchApiTest {
    
    @Test 
    public void verifyPatchApiTest() {

        
        ApiClient apiClient = new ApiClient();
        int id = 4;
        LocalUser localUser = new LocalUser();

        localUser.setName("Dipali Kesharwani");

        Response response = apiClient.patch(ConfigReader.getProperty("baseApiUrl"), ApiEndpoints.USER_BY_ID + id, localUser);

        int response_code = response.getStatusCode();
        System.out.println("Status Code : "+response_code);


    }
}
