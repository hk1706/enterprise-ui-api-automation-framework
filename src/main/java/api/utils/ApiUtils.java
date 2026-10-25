package api.utils;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;

public class ApiUtils {

    public static RequestSpecification getRequestSpecification() {

        return new RequestSpecBuilder()
                .setContentType("application/json")
                .log(io.restassured.filter.log.LogDetail.ALL)
                .build();
    }
}