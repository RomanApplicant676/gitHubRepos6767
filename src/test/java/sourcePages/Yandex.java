package sourcePages;

import baseActions.BaseWebActions;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class Yandex extends BaseWebActions {
    private static final String classSimpleName = Yandex.class.getSimpleName();
    private static final Logger LOGGER = LogManager.getLogger(classSimpleName);

    private final By searchFieldBy = By.cssSelector("input[id='text']");
    private final By searchBtnBy = By.cssSelector("button[type='submit']");


    private final WebDriver driver;

    public Yandex(WebDriver driver) {
        this.driver = driver;
    }

    public Yandex navigateToYandex(String url) {

        driver.get(url);
        LOGGER.info("Get yandex url " + url);
        waitForPageReadyState(20, driver);
        return this;
    }

    public Yandex typeSearchField(String searchTxt) throws InterruptedException {

        explicitWait(20, driver)
                .until(ExpectedConditions.visibilityOfElementLocated(searchFieldBy)).sendKeys(searchTxt);
        LOGGER.info("Typed search text: '" + searchTxt + "'.");
        Thread.sleep(600);
        return this;
    }

    public Yandex clickSearch() {

        explicitWait(20, driver)
                .until(ExpectedConditions.elementToBeClickable(searchBtnBy)).click();
        LOGGER.info("Clicked 'Найти' button.");
        waitForPageReadyState(20, driver);
        return this;
    }

    public Gismeteo clickGismeteoUrl(String url) {

        By foundGismeteoUrlBy = By.cssSelector("a[href='" + url + "']");
        explicitWait(20, driver)
                .until(ExpectedConditions.elementToBeClickable(foundGismeteoUrlBy)).click();
        LOGGER.info("Clicked found value with url = " + url);
        for (String winHandle : driver.getWindowHandles()) {
            driver.switchTo().window(winHandle);
        }
        waitForPageReadyState(20, driver);
        return new Gismeteo(driver);
    }

}
