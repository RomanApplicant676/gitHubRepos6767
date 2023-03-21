package io.openweathermap.testing.controller;

import io.openweathermap.testing.models.WeatherFlow;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

public class OpenWeather {

    private static final String openWeather_API_KEY = "0c8bde4674fd17a0ab4f4764dd45735b";
    private static final String openWeather_ENDPOINT = "weather?q=&appid=" + openWeather_API_KEY;


    public static Response getWeather(String city) {
        return given().relaxedHTTPSValidation()
                .when()
                .queryParams("q", city)
                .contentType(ContentType.JSON)
                .get(baseURI + basePath + openWeather_ENDPOINT);
    }

    public static WeatherFlow getWeather200(String city) {
        return getWeather(city)
                .then()
                .statusCode(200).and().log().all()
                .extract()
                .as(WeatherFlow.class);
    }

}
