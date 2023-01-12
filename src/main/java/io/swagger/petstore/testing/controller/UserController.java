package io.swagger.petstore.testing.controller;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.given;

public class UserController {

    private final RequestSpecification requestSpecification = new RequestSpecBuilder()
            .log(LogDetail.ALL)
            .setContentType(ContentType.JSON)
            .addHeader("api_key", "12345")
            .build();

    public Response getUser(String userName) {
        return given(requestSpecification)
                .when()
                .get(userName);
    }

    public Response postUser(Object user) {
        return given(requestSpecification)
                .when()
                .body(user)
                .post();
    }

    public Response putUser(Object user, String username) {
        return given(requestSpecification)
                .when()
                .body(user)
                .put("/" + username);
    }

    public Response deleteUser(String userId) {
        return given(requestSpecification)
                .when()
                .delete(userId);
    }

}
