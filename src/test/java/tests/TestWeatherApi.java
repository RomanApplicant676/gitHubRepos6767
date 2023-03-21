package tests;

import io.openweathermap.testing.controller.OpenWeather;
import io.restassured.RestAssured;
import io.weatherBit.testing.controller.WeatherBitController;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;

import static junit.framework.TestCase.assertTrue;

@Slf4j
public class TestWeatherApi {

    private static final String city = "Samara";
    private static final String country = "RU";

    @Test
    @DisplayName("Тест API совпадения погоды в 2х погодных сервисах (API KEYs valid till 31/03/2023)")
    public void compareWeatherServices() {

        RestAssured.baseURI = "https://api.openweathermap.org/";
        RestAssured.basePath = "data/2.5/";

        double openWeatherTempCels = OpenWeather.getWeather200(city).getMain().getTemp() - 273.15;

        System.out.println("openweathermap temperature in Samara is " + openWeatherTempCels);

        RestAssured.baseURI = "https://api.weatherbit.io/";
        RestAssured.basePath = "v2.0/current";

        double bitWeatherTemp = WeatherBitController.getWeatherBit200(city, country).getData().get(0).getTemp();

        System.out.println("bitWeatherTemp is " + bitWeatherTemp);

        assertTrue(Math.abs(bitWeatherTemp - openWeatherTempCels) < 0.7);

    }


}
