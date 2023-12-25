package pageObjects;

import common.DriverManager;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BasePage {

    public final Logger LOGGER = LogManager.getLogger(this.getClass().getName());

    public BasePage() {
        PageFactory.initElements(DriverManager.getWebDriver(), this);
    }

    public static WebDriverWait getWebDriverWait() {
        return new WebDriverWait(DriverManager.getWebDriver(), Duration.ofSeconds(20));
    }

    public static void waitUntilElementIsVisible(WebElement element) {
        getWebDriverWait().until(ExpectedConditions.visibilityOf(element));
    }

    public static void waitUntilElementIsClickable(WebElement element) {
        getWebDriverWait().until(ExpectedConditions.elementToBeClickable(element));
    }

    public void click(WebElement element) {
        try {
            getWebDriverWait().until(ExpectedConditions.elementToBeClickable(element));
        } catch (Exception e) {
            LOGGER.info("Unable to click on element");
            e.printStackTrace();
        }

    }

    public void sendKeys(WebElement element, String text) {
        try {
            element.sendKeys(text);
        } catch (Exception e) {
            LOGGER.info("Unable to type text into input");
            e.printStackTrace();
        }
    }

    public void navigateToElement(WebElement element) {
        try {
            Actions actions = new Actions(common.DriverManager.getWebDriver());
            actions.moveToElement(element).release().perform();
        } catch (Exception e) {
            LOGGER.info("Unable navigate to exact element due to: " + e);

        }
    }

    public static String createRandomUserName(int n) {
        String AlphaNumericString = "ABCDEFGHIJKLMNOPQRSTUVWXYZ"
                + "0123456789"
                + "abcdefghijklmnopqrstuvxyz";
        StringBuilder sb = new StringBuilder(n);

        for (int i = 0; i < n; i++) {

            int index = (int) (AlphaNumericString.length() * Math.random());

            sb.append(AlphaNumericString
                    .charAt(index));
            return sb.toString();
        }
        return "User" + sb;
    }
}
