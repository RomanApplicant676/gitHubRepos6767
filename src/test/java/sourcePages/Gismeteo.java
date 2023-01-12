package sourcePages;

import baseActions.BaseWebActions;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class Gismeteo extends BaseWebActions {
    private static final String classSimpleName = Gismeteo.class.getSimpleName();
    private static final Logger LOGGER = LogManager.getLogger(classSimpleName);
    private final By searchFieldGismeteoBy = By.cssSelector("div[class='search-label']>input");
    private final WebDriver driver;

    public Gismeteo(WebDriver driver) {
        this.driver = driver;
    }

    public Gismeteo typeSearchField(String searchTxt) throws InterruptedException {

        Thread.sleep(6000);
        typeAhead(searchFieldGismeteoBy, searchTxt);
        LOGGER.info("Typed search text: '" + searchTxt + "'.");
        Thread.sleep(2000);
        return this;
    }

    public GismeteoExactLocation clickFoundValue(String foundValue) {

        By foundValueBy = By.xpath("//div[@class='city-title ' and text()='" + foundValue + "']");
        explicitWait(20, driver)
                .until(ExpectedConditions.elementToBeClickable(foundValueBy)).click();
        LOGGER.info("Clicked '" + foundValue + "' from offered list.");
        waitForPageReadyState(20, driver);
        return new GismeteoExactLocation(driver);
    }

    private void typeAhead(By locator, String text) throws InterruptedException {
        char[] symbols = text.toCharArray();
        for (char symbol : symbols) {
            driver.findElement(locator).sendKeys(String.valueOf(symbol));
            Thread.sleep(200);
        }
    }

}
