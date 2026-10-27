package tests.api;

import org.testng.annotations.Test;

import api.client.ApiClient;
import api.endpoints.ApiEndpoints;
import api.models.CreateUserRequest;
import api.utils.ResponseSpecBuilderUtil;
import org.testng.Assert;
import io.restassured.response.Response;

public class PutUserApiTest {
    
    @Test
    public void updateUserTest() {

        ApiClient apiClient = new ApiClient();

        CreateUserRequest request = new CreateUserRequest();

        request.setName("Harsh");
        request.setJob("Senior QA");

        Response response =
                apiClient.put(
                        ApiEndpoints.BASE_URL,
                        "/api/users/2",
                        request);

        response.then()
                .spec(
                    ResponseSpecBuilderUtil
                        .getSuccessResponseSpec(200));

        Assert.assertEquals(
                response.jsonPath()
                        .getString("name"),
                "Harsh");

        Assert.assertEquals(
                response.jsonPath()
                        .getString("job"),
                "Senior QA");
    }

}
