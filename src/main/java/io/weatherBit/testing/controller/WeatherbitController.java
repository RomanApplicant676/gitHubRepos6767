package io.weatherBit.testing.controller;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.given;

public class WeatherbitController {

    private final RequestSpecification requestSpecification = new RequestSpecBuilder()
            .log(LogDetail.ALL)
            .setContentType(ContentType.JSON)
            .addHeader("api_key", "12345")
            .build();

    public Response getWeather() {
        return given(requestSpecification)
                .when()
                .get();
    }

}
