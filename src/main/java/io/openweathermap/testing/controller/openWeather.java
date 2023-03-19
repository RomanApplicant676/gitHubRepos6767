package io.openweathermap.testing.controller;

import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

public class openWeather {

    private static final String openWeather_API_KEY = "0c8bde4674fd17a0ab4f4764dd45735b";

    public Response getWeather(String city) {
        return given()
                .when()
                .get(baseURI + basePath + "weather?q=" + city + "&appid=" + openWeather_API_KEY);
    }




    /////// Response

}
