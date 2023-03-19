package tests;


import io.openweathermap.testing.models.WeatherFlow;
import io.restassured.RestAssured;
import io.weatherBit.testing.models.IoWeatherFlow;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;

import static io.restassured.RestAssured.*;
import static org.junit.jupiter.api.Assertions.assertTrue;

@Slf4j
public class TestWeatherApi {

    private static final String city = "Samara";
    private static final String country = "RU";
    private static final String openWeather_API_KEY = "0c8bde4674fd17a0ab4f4764dd45735b";
    private static final String openWeather_ENDPOINT = "weather?q=" + city + "&appid=" + openWeather_API_KEY;
    private static final String weatherBit_API_KEY = "041569772e144cbf9d73eeb0aa6172bc";

    @Test
    @DisplayName("Тест совпадения погоды в 2х погодных сервисах")
    public void compareWeatherServices() {

        RestAssured.baseURI = "https://api.openweathermap.org/";
        RestAssured.basePath = "data/2.5/";

        WeatherFlow weatherflow = given()
                .header("Content-Type", "application/json")
                .when()
                .get(baseURI + basePath + openWeather_ENDPOINT)
                .then()
                .statusCode(200)
                .and()
                .log().all()
                .extract().response().as(WeatherFlow.class);

        double temperature = weatherflow.getMain().getTemp();
        log.info("its Okay, temperature in Samara is " + temperature);

        RestAssured.baseURI = "https://api.weatherbit.io/";//http://api.weatherbit.io/v2.0/current
        RestAssured.basePath = "v2.0/current";

        IoWeatherFlow ioWeatherFlow = given()
                .header("Content-Type", "application/json")
                .when()
                .get(baseURI + basePath + "?city=" + city + "," + country + "&key=" + weatherBit_API_KEY)
                .then()
                .statusCode(200)
                .and()
                .log().all()
                .extract().response().as(IoWeatherFlow.class);

        double temperatureIo = ioWeatherFlow.getData().get(0).getTemp();
        log.info("its Okay, temperature in " + city + " is " + temperatureIo);

        assertTrue(temperatureIo - temperature < 1);

    }


}
