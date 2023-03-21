package io.weatherBit.testing.controller;

import io.weatherBit.testing.models.IoWeatherFlow;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

public class WeatherBitController {

    private static final String weatherBit_API_KEY = "041569772e144cbf9d73eeb0aa6172bc";


    public static Response getWeatherBit(String city, String country) {
        return given().relaxedHTTPSValidation()
                .when()
                .queryParams("city", city, "key", weatherBit_API_KEY)
                .contentType(ContentType.JSON)
                .get(baseURI + basePath + "?city=,RU&key=");
    }

    public static IoWeatherFlow getWeatherBit200(String city, String country) {
        return getWeatherBit(city, country)
                .then()
                .statusCode(200).and().log().all()
                .extract()
                .as(IoWeatherFlow.class);
    }

}