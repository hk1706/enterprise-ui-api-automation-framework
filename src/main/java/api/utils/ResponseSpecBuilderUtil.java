package api.utils;

import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.specification.ResponseSpecification;

public class ResponseSpecBuilderUtil {

    public static ResponseSpecification getSuccessResponseSpec(int statusCode) {

        return new ResponseSpecBuilder()
                .expectStatusCode(statusCode)
                .expectContentType("application/json")
                .build();
    }
}