package tests;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.chrome.ChromeDriver;
import sourcePages.Yandex;

import static org.junit.jupiter.api.Assertions.*;

public class WeatherTest {
    ChromeDriver driver = new ChromeDriver();
    private final String searchUrl = "https://ya.ru/";
    private final String weatherUrl = "https://www.gismeteo.ru/";
    private final String location = "Краснодар";
    private final String searchValue = "gismeteo";
    private final String expectedValue = "Погода в " + location + "е сегодня";

    /**
     * @author Roman N
     * @since Jan 2023
     * Steps:
     * 1. Зайти на сайт https://ya.ru/
     * 2. В поиске набрать gismeteo
     * 3. Через найденный список перейти на сайт https://www.gismeteo.ru/
     * 4. Набрать в строке поиска город вашей локации и выбрать его в выпадающем списке
     * 5. Проверить что на странице отображается фраза «Погода в .... сегодня»
     */

    @Before
    public void before() {
        System.setProperty("webdriver.chrome.driver", "C:\\autotests\\chromedriver.exe");
        driver.manage().window().maximize();
    }

    @Test
    public void run() throws Throwable {
        try {

            System.out.println("Test location = " + location);

            var gismeteoExactLocation = new Yandex(driver).navigateToYandex(searchUrl)
                    .typeSearchField(searchValue)
                    .clickSearch()
                    .clickGismeteoUrl(weatherUrl)
                    .typeSearchField(location)
                    .clickFoundValue(location);

            String actualText = gismeteoExactLocation.getCleanPageTitleText();

            assertAll("Gismeteo page title for " + location,
                    () -> assertEquals(expectedValue, actualText),
                    () -> assertTrue(gismeteoExactLocation.checkPageTitleDisplayed()));

            System.out.println("Passed");

        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
    }

    @After
    public void after() {
        driver.quit();
    }


}