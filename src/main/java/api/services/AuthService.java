package api.services;

import api.client.ApiClient;
import api.endpoints.ApiEndpoints;
import api.managers.TokenManager;
import api.models.LoginRequest;
import api.models.LoginResponse;
import io.restassured.response.Response;

public class AuthService {

    public static String getToken() {

        if (TokenManager.getToken() != null) {
            return TokenManager.getToken();
        }

        ApiClient apiClient = new ApiClient();

        LoginRequest request =
                new LoginRequest();

        request.setEmail("eve.holt@reqres.in");
        request.setPassword("cityslicka");

        Response response =
                apiClient.post(
                        ApiEndpoints.BASE_URL,
                        ApiEndpoints.LOGIN,
                        request);

        LoginResponse loginResponse =
                response.as(LoginResponse.class);

        TokenManager.setToken(
                loginResponse.getToken());

        return TokenManager.getToken();
    }
}