package tests.api;

import org.testng.annotations.Test;

import api.client.ApiClient;
import api.endpoints.ApiEndpoints;
import api.models.LocalUser;
import utils.ConfigReader;
import io.restassured.response.*;;

public class LocalUserPostApiTest {
    
    @Test
    public void createUserdemo(){

        ApiClient apiClient = new ApiClient();
        LocalUser localUser = new LocalUser();

        localUser.setName("Dipali Kesharwani");
        localUser.setJob("Technical Support");

        Response response = apiClient.post(ConfigReader.getProperty("baseApiUrl"), ApiEndpoints.USERS, localUser);

        response.then().statusCode(201);

        int statuscode = response.statusCode();

        int id = response.jsonPath().getInt("id");

        System.out.println("Status Code : "+statuscode);
        System.out.println("Captured ID : "+id);

    }

}
