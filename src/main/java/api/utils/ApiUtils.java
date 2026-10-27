package api.utils;

import api.managers.TokenManager;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;

public class ApiUtils {

    public static RequestSpecification getRequestSpecification() {

        RequestSpecBuilder builder =
                new RequestSpecBuilder()
                        .setContentType("application/json")
                        .addHeader("Accept", "application/json");

        if (TokenManager.getToken() != null) {

            builder.addHeader(
                    "Authorization",
                    "Bearer " + TokenManager.getToken());
        }

        return builder.build();
    }
}