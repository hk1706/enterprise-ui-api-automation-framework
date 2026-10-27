package tests.api;

import api.client.ApiClient;
import api.endpoints.ApiEndpoints;
import api.models.CreateUserRequest;
import api.models.CreateUserResponse;
import api.utils.ResponseSpecBuilderUtil;
import base.BaseApiTest;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;


public class CreateUserApiTest extends BaseApiTest {

    @Test
    public void createUserTest() {

        ApiClient apiClient = new ApiClient();

        CreateUserRequest requestBody = new CreateUserRequest();

        requestBody.setName("Harsh");
        requestBody.setJob("QA Automation Engineer");

        Response response =
                apiClient.post(
                        ApiEndpoints.BASE_URL,
                        ApiEndpoints.CREATE_USER,
                        requestBody);

        CreateUserResponse userResponse = response.as(CreateUserResponse.class);
        
        response.then()
        .spec(
            ResponseSpecBuilderUtil
                .getSuccessResponseSpec(201));

        Assert.assertEquals(
                        userResponse.getName(),
                        "Harsh");

        System.out.println("Status Code : " + response.statusCode());

        System.out.println("Response : ");
        System.out.println(response.asPrettyString());
    }
}