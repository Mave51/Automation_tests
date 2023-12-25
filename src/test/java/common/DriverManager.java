package common;


import org.openqa.selenium.WebDriver;

import static common.BrowserType.FIREFOX;
import static common.TestExecutionProperties.getBrowserToRun;
import static common.TestExecutionProperties.getIsRemoteRun;

public class DriverManager {
    private static WebDriver driver;

    private DriverManager() {
    }

    public static WebDriver getWebDriver() {

        if (driver == null) {
            driver = new BrowserFactory(getBrowserToRun(), getIsRemoteRun()).getBrowser();
        }

        return driver;
    }

    public static void disposeDriver() {
        driver.close();
        if (!getBrowserToRun().equals(FIREFOX)) {
            driver.quit();
        }
        driver = null;
    }
}
