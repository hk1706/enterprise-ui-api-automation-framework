package tests.api;

import org.testng.annotations.Test;


import org.testng.Assert;
import api.client.ApiClient;
import api.endpoints.ApiEndpoints;
import api.models.LocalUser;
import io.restassured.response.Response;
import utils.ConfigReader;


public class ResourceLifecycleApiTest {
    
    @Test 
    public void verifyEndToEndApi() {

        LocalUser localUser = new LocalUser();
        ApiClient apiClient = new ApiClient();

        localUser.setName("Vanya Kesharwani");
        localUser.setJob("Spreading Happiness");

        Response response_create = apiClient.post(ConfigReader.getProperty("baseApiUrl"), ApiEndpoints.USERS, localUser);

        response_create.then().statusCode(201);
        int user_id = response_create.jsonPath().getInt("id");

        Assert.assertEquals(response_create.jsonPath().getString("name"), "Vanya Kesharwani");

        Response response_read = apiClient.get(ConfigReader.getProperty("baseApiUrl"), ApiEndpoints.USER_BY_ID + user_id);

        response_read.then().statusCode(200);
        Assert.assertEquals(response_read.jsonPath().getString("name"), "Vanya Kesharwani");
        Assert.assertEquals(response_read.jsonPath().getString("job"), "Spreading Happiness");


        localUser.setName("Shaurya Kesharwani");
        localUser.setJob("Spreading Happiness");
        Response response_update = apiClient.put(ConfigReader.getProperty("baseApiUrl"), ApiEndpoints.USER_BY_ID + user_id, localUser);

        response_update.then().statusCode(200);
        System.out.println(response_update.asPrettyString());

        Response after_update = apiClient.get(ConfigReader.getProperty("baseApiUrl"), ApiEndpoints.USER_BY_ID + user_id);
        Assert.assertEquals(after_update.jsonPath().getString("name"), "Shaurya Kesharwani");
        Assert.assertEquals(after_update.jsonPath().getString("job"), "Spreading Happiness");

        

        localUser.setJob("Learning new things");
        Response response_patch = apiClient.patch(ConfigReader.getProperty("baseApiUrl"), ApiEndpoints.USER_BY_ID + user_id, localUser);
        response_patch.then().statusCode(200);
        Assert.assertEquals(response_patch.jsonPath().getString("job"), "Learning new things");
        
        Response after_patch = apiClient.get(ConfigReader.getProperty("baseApiUrl"), ApiEndpoints.USER_BY_ID + user_id);
        Assert.assertEquals(after_patch.jsonPath().getString("job"), "Learning new things");
        Assert.assertEquals(after_patch.jsonPath().getString("name"), "Shaurya Kesharwani");
        

        System.out.println(response_patch.asPrettyString());


        Response response_delete = apiClient.delete(ConfigReader.getProperty("baseApiUrl"), ApiEndpoints.USER_BY_ID+user_id);
        response_delete.then().statusCode(200);
        
        Response response_after_delete =apiClient.get(ConfigReader.getProperty("baseApiUrl"), ApiEndpoints.USER_BY_ID + user_id);
        response_after_delete.then().statusCode(404);

    }
}
