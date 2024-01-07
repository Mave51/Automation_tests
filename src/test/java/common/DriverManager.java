package common;


import org.openqa.selenium.WebDriver;

import static common.BrowserType.FIREFOX;
import static common.TestExecutionProperties.getBrowserToRun;
import static common.TestExecutionProperties.getIsRemoteRun;

public class DriverManager {
    private static WebDriver driver;

    private static final ThreadLocal<WebDriver> webDriverThreadLocal = new ThreadLocal<>();

    private DriverManager() {
    }

    public static WebDriver getWebDriver() {

        if (webDriverThreadLocal.get() == null) {
            webDriverThreadLocal.set(new BrowserFactory(getBrowserToRun(), getIsRemoteRun()).getBrowser());
        }
        return webDriverThreadLocal.get();
    }

    public static void disposeDriver() {
        webDriverThreadLocal.get().close();
        if (!getBrowserToRun().equals(FIREFOX)) {
            webDriverThreadLocal.get().quit();
        }
        webDriverThreadLocal.remove();
    }
}
