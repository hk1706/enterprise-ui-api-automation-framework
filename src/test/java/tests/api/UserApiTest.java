package tests.api;

import api.client.ApiClient;
import api.endpoints.ApiEndpoints;
import api.utils.ResponseSpecBuilderUtil;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;
import base.BaseApiTest;

public class UserApiTest extends BaseApiTest {

@Test
public void getUsersTest() {

    ApiClient apiClient = new ApiClient();
    //TokenManager.setToken("test123");

    Response response =
            apiClient.get(
                    ApiEndpoints.BASE_URL,
                    ApiEndpoints.GET_USERS);

    response.then()
        .spec(
                ResponseSpecBuilderUtil
                        .getSuccessResponseSpec(200));


    Assert.assertEquals(
            response.jsonPath().getInt("page"),
            1);

    Assert.assertEquals(
            response.jsonPath().getString("data[0].first_name"),
            "George");

    System.out.println("Status Code : " + response.statusCode());

    System.out.println("Response : ");
    System.out.println(response.asPrettyString());

    }

}