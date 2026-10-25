package api.client;

import api.utils.ApiUtils;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class ApiClient {

    public Response get(String baseUrl,
                    String endpoint) {

        return given()
                .spec(ApiUtils.getRequestSpecification())
                .log().all()

                .when()
                .get(baseUrl + endpoint)

                .then()
                .log().all()
                .extract()
                .response();
        }

    public Response post(String baseUrl,
                     String endpoint,
                     Object requestBody) {

        return given()
                .spec(ApiUtils.getRequestSpecification())
                .body(requestBody)
                .log().all()

                .when()
                .post(baseUrl + endpoint)

                .then()
                .log().all()
                .extract()
                .response();
        }

    public Response put(String baseUrl,
                    String endpoint,
                    Object requestBody) {

        return given()
                .spec(ApiUtils.getRequestSpecification())
                .body(requestBody)
                .when()
                .put(baseUrl + endpoint);
    }

    public Response delete(String baseUrl,
                       String endpoint) {

        return given()
                .spec(ApiUtils.getRequestSpecification())
                .when()
                .delete(baseUrl + endpoint);
}

}