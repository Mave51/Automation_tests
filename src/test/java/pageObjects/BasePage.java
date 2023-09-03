package pageObjects;

import common.DriverManager;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BasePage {

    protected WebDriverWait wait;
    public final Logger LOGGER = LogManager.getLogger(BasePage.class);

    public BasePage(WebDriver driver, WebDriverWait wait) {
        this.wait = wait;
        PageFactory.initElements(driver, this);
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
        getWebDriverWait().until(ExpectedConditions.elementToBeClickable(element));
    }

    public void navigateToElement(WebElement element) {
        try {
            Actions actions = new Actions(common.DriverManager.getWebDriver());
            actions.moveToElement(element).release().perform();
        } catch (Exception e) {
            LOGGER.info("Unable navigate to exact element due to: " + e);

        }
    }


}
