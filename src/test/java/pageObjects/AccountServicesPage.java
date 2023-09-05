package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AccountServicesPage extends BasePage {

    @FindBy(xpath = "//*[@id=\"rightPanel\"]/p")
    private WebElement successfulRegisterMessage;

    @FindBy(xpath = "//*[@id=\"leftPanel\"]/h2")
    private WebElement accountServicesMenu;

    @FindBy(xpath = "//*[@id=\"rightPanel\"]/p")
    private WebElement failedLoginAttemptMessage;


    public String getSuccessfulRegisterMessage(){
        LOGGER.info("After correct account registration get confirmation text");
        waitUntilElementIsVisible(successfulRegisterMessage);
        return successfulRegisterMessage.getText();
    }

    public String getAccountServicesMenuTitleNameAfterLogin(){
        LOGGER.info("After correct login get account services menu title name");
        waitUntilElementIsVisible(accountServicesMenu);
        return accountServicesMenu.getText();
    }

    public String getErrorMessageAfterFailedLoginAttempt(){
        LOGGER.info("Get error message text after failed login attempt");
        waitUntilElementIsVisible(failedLoginAttemptMessage);
        return failedLoginAttemptMessage.getText();
    }
}
