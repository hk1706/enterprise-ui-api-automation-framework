package tests.api;

import org.testng.annotations.Test;

import api.client.ApiClient;
import api.endpoints.ApiEndpoints;
import api.models.CreateUserRequest;
import api.utils.ResponseSpecBuilderUtil;
import org.testng.Assert;
import io.restassured.response.Response;

public class PatchUserRequest {

    @Test
    public void patchUserTest() {

        ApiClient apiClient = new ApiClient();

        CreateUserRequest request =
                new CreateUserRequest();

        request.setJob("Lead QA");

        Response response =
                apiClient.patch(
                        ApiEndpoints.BASE_URL,
                        "/api/users/2",
                        request);

        response.then()
                .spec(
                    ResponseSpecBuilderUtil
                            .getSuccessResponseSpec(200));

        Assert.assertEquals(
                response.jsonPath()
                        .getString("job"),
                "Lead QA");

        Assert.assertNotNull(
                response.jsonPath()
                        .getString("updatedAt"));
    }
    
}
