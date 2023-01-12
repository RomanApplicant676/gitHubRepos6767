package baseActions;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;


public class BaseWebActions {

    protected WebDriverWait explicitWait(int timeOutSeconds, WebDriver driver) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOutSeconds));
        return wait;
    }

    protected void waitForPageReadyState(int timeOutSeconds, WebDriver driver) throws TimeoutException {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeOutSeconds));
        wait.until(webDriver -> ((JavascriptExecutor) webDriver)
                .executeScript("return document.readyState").equals("complete"));
    }

    protected static boolean elementExists(By elementBy, int secondsToWait, WebDriver driver) throws InterruptedException {
        boolean result = false;
        for (int i = 0; i < secondsToWait; i++) {
            try {
                driver.findElement(elementBy);
                result = true;
                break;
            } catch (NoSuchElementException e) {
                Thread.sleep(1000);
            }
        }
        return result;
    }

    protected static boolean elementDisplayed(By elementBy, int secondsToWait, WebDriver driver) throws InterruptedException {
        boolean result = false;
        for (int i = 0; i < secondsToWait; i++) {
            try {
                result = driver.findElement(elementBy).isDisplayed();
                break;
            } catch (NoSuchElementException e) {
                Thread.sleep(1000);
            }
        }
        return result;
    }

    protected static boolean elementIsClickable(By elementBy, int secondsToWait, WebDriver driver) throws InterruptedException {
        boolean result = false;
        for (int i = 0; i < secondsToWait; i++) {
            try {
                result = driver.findElement(elementBy).isDisplayed() && driver.findElement(elementBy).isEnabled();
                break;
            } catch (NoSuchElementException e) {
                Thread.sleep(1000);
            }
        }
        return result;
    }


}
