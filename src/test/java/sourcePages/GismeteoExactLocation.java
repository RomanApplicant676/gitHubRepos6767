package sourcePages;

import baseActions.BaseWebActions;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class GismeteoExactLocation extends BaseWebActions {
    private static final String classSimpleName = GismeteoExactLocation.class.getSimpleName();
    private static final Logger LOGGER = LogManager.getLogger(classSimpleName);

    private final By pageTitleBy = By.cssSelector("div[class='page-title']");

    private final WebDriver driver;

    public GismeteoExactLocation(WebDriver driver) {
        this.driver = driver;
    }

    public String getCleanPageTitleText() {

        waitForPageReadyState(20, driver);
        String cleanTxt = explicitWait(20, driver)
                .until(ExpectedConditions.visibilityOfElementLocated(pageTitleBy)).getAttribute("innerText")
                .replace(" ", " ");
        LOGGER.info("Page title is " + cleanTxt);
        return cleanTxt;
    }

    public boolean checkPageTitleDisplayed() throws InterruptedException {

        if (elementExists(pageTitleBy, 10, driver) &&
                elementDisplayed(pageTitleBy, 10, driver)) {
            return true;
        } else return false;
    }

}
