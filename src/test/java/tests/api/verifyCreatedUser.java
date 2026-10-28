package tests.api;

import io.restassured.response.*;
import utils.ConfigReader;

import org.testng.annotations.Test;

import api.client.ApiClient;
import api.endpoints.ApiEndpoints;
import io.restassured.response.Response;
import org.testng.Assert;

public class verifyCreatedUser {
    
    @Test 
    public void verifyCreatedUserdemo() {

        ApiClient apiClient = new ApiClient();

        Response response = apiClient.get(ConfigReader.
            getProperty("baseApiUrl"), 
            ApiEndpoints.USER_BY_ID + 4);

        Assert.assertEquals(
            response.jsonPath().
            getString("name"),
            "Dipali Kesharwani"
        );
        
        Assert.assertEquals(
            response.jsonPath().
            getString("job"),
            "Technical Support"
        );

     }

}


