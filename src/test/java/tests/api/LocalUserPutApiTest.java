package tests.api;

import org.testng.Assert;
import org.testng.annotations.Test;

import api.client.ApiClient;
import api.endpoints.ApiEndpoints;
import api.models.LocalUser;
import io.restassured.response.Response;
import utils.ConfigReader;

public class LocalUserPutApiTest {

    @Test
    public void updateUserAndVerifyPersistence() {

        int userId = 4;

        ApiClient apiClient = new ApiClient();

        LocalUser updatedUser = new LocalUser();

        updatedUser.setName("Dipali Kesharwani Updated");
        updatedUser.setJob("Senior Technical Support");

        Response putResponse =
                apiClient.put(
                        ConfigReader.getProperty("baseApiUrl"),
                        ApiEndpoints.USER_BY_ID + userId,
                        updatedUser);

        putResponse.then().statusCode(200);

        Response getResponse =
                apiClient.get(
                        ConfigReader.getProperty("baseApiUrl"),
                        ApiEndpoints.USER_BY_ID + userId);

        getResponse.then().statusCode(200);

        Assert.assertEquals(
                getResponse.jsonPath().getString("name"),
                "Dipali Kesharwani Updated");

        Assert.assertEquals(
                getResponse.jsonPath().getString("job"),
                "Senior Technical Support");
    }
}